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
 * Table OrderLine
 * 
 * @version 1.0
 */
public class TableOrderLine implements Serializable {

	private static final long serialVersionUID = 7497884607471624581L;
	public int ol_w_id;
	public int ol_d_id;
	public int ol_o_id;
	public int ol_number;
	public int ol_i_id;
	public int ol_supply_w_id;
	public int ol_quantity;
	public long ol_delivery_d;
	public float ol_amount;
	public String ol_dist_info;

	public String toString() {
		StringBuffer desc = new StringBuffer();
		desc.append("\n***************** OrderLine ********************");
		desc.append("\n*        ol_w_id = " + ol_w_id);
		desc.append("\n*        ol_d_id = " + ol_d_id);
		desc.append("\n*        ol_o_id = " + ol_o_id);
		desc.append("\n*      ol_number = " + ol_number);
		desc.append("\n*        ol_i_id = " + ol_i_id);
		desc.append("\n*  ol_delivery_d = " + ol_delivery_d);
		desc.append("\n*      ol_amount = " + ol_amount);
		desc.append("\n* ol_supply_w_id = " + ol_supply_w_id);
		desc.append("\n*    ol_quantity = " + ol_quantity);
		desc.append("\n*   ol_dist_info = " + ol_dist_info);
		desc.append("\n************************************************");
		return desc.toString();
	}
}
