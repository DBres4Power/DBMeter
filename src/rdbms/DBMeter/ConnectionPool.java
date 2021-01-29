/*
 * Copyright (c) 2018 IPS, All rights reserved.
 *
 * The contents of this file are subject to the terms of the Apache License, Version 2.0.
 * Release: v1.0, By IPS, 2021.01.
 *
 */
package rdbms.DBMeter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Database Connection Pool <BR>
 * 
 * NOTE: invoke destroy() before program termination
 * 
 * @version 1.0
 * 
 */
public class ConnectionPool {
	private String className;
	private String url;
	private String userName;
	private String password;
	private int maxConnections;
	private int currentConnections = 0;

	/** store the connections recycled */
	private LinkedList<Connection> pool = new LinkedList<Connection>();

	/** store the connections coming out of this pool */
	private LinkedList<Connection> out = new LinkedList<Connection>();

	public ConnectionPool(String className, String url, String userName,
			String password, int maxConns) throws ClassNotFoundException {
		Class.forName(className);
		this.className = className;
		this.url = url;
		this.userName = userName;
		this.password = password;
		this.maxConnections = maxConns;
	}

	public Connection getConnection() {
		Connection conn = null;
		synchronized (pool) {
			if (pool.size() > 0) {
				conn = pool.remove();
			} else {
				if (this.currentConnections < this.maxConnections) {
					try {
						conn = DriverManager.getConnection(url, userName,
								password);
						conn.setAutoCommit(false);		
						if (className.endsWith("IfxDriver")) {
							Statement stmt = conn.createStatement();
							//COMMITTED READ;  DIRTY READ
							stmt.execute("SET ISOLATION TO COMMITTED READ");
							stmt.execute("SET LOCK MODE TO WAIT 15");
							stmt.close();
						}
						this.currentConnections++;
					} catch (SQLException e) {
						System.out.println(e);
					}
				} else {
					try {
						while (pool.size() <= 0) {
							pool.wait();
						}
						conn = pool.remove();
					} catch (InterruptedException e) {
						System.err.println(e);
					} catch (NoSuchElementException e1) {
						System.err.println(Thread.currentThread().getName()
								+ " - Pool Size: " + pool.size());
					}
				}
			}
			out.add(conn);
			return conn;
		}

	}

	public boolean recycle(Connection conn) {
		synchronized (pool) {
			if (out.remove(conn) == true) {
				pool.add(conn);
				pool.notify();
				return true;
			} else {
				return false;
			}
		}
	}

	public synchronized void destroy() {
		Connection conn = null;
		try {
			while (this.currentConnections > 0) {
				if (pool.size() > 0) {
					// 2020-3-08 should rollback before close(); 
					// Raise error: com.ibm.db2.jcc.am.SqlException: [jcc][t4][10251][10308][4.24.92] java.sql.Connection.close() requested while a transaction is in progress on the connection.
					// pool.remove().close(); 
					conn = pool.remove();
					conn.rollback();
					conn.close();
					this.currentConnections--;
				} else {
					//this.wait(); //not synchronized this.currentConnections maybe >0
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
