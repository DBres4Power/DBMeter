/*
 * Copyright (c) 2018 IPS, All rights reserved.
 *
 * The contents of this file are subject to the terms of the Apache License, Version 2.0.
 * Release: v1.0, By IPS, 2021.01.
 *
 */
package rdbms.DBMeter;

import java.io.Serializable;

/**
 * Table NewOrder
 * 
 * @version 1.0
 */
public class TableNewOrder implements Serializable {
	private static final long serialVersionUID = -7157565243376951198L;
	public int no_w_id;
	public int no_d_id;
	public int no_o_id;

	public String toString() {
		StringBuffer desc = new StringBuffer();
		desc.append("\n***************** NewOrder ********************");
		desc.append("\n*      no_w_id = " + no_w_id);
		desc.append("\n*      no_d_id = " + no_d_id);
		desc.append("\n*      no_o_id = " + no_o_id);
		desc.append("\n**********************************************");
		return desc.toString();
	}
}
