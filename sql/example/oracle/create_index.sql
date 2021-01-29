alter session enable parallel dml;
alter session enable parallel ddl;

create unique index k_warehouse on warehouse(w_id)  initrans 255 pctfree 30 NOLOGGING;
create unique index k_district on district(d_w_id,d_id)  initrans 255 pctfree 30 NOLOGGING;
create unique index k_item on item(i_id)  initrans 255 pctfree 30 NOLOGGING;
create unique index ndx_oorder_carrier on oorder (o_w_id, o_d_id, o_carrier_id, o_id)  initrans 255 pctfree 30 NOLOGGING;
create unique index k_new_order on new_order(no_w_id, no_d_id, no_o_id)  initrans 255 pctfree 30 NOLOGGING;
create index ndx_customer_name on customer (c_w_id, c_d_id, c_last, c_first)  initrans 255 pctfree 30 NOLOGGING;
create unique index k_oorder on oorder(o_w_id, o_d_id, o_id)  initrans 255 pctfree 30 NOLOGGING;
create unique index k_customer on customer(c_w_id, c_d_id, c_id)  initrans 255 pctfree 30 NOLOGGING;
create unique index k_order_line on order_line(ol_w_id, ol_d_id, ol_o_id, ol_number)  initrans 255 pctfree 30 NOLOGGING;
create unique index k_stock on stock(s_w_id, s_i_id)  initrans 255 pctfree 30 NOLOGGING;
create unique index pk_0order on oorder(o_w_id, o_d_id, o_c_id, o_id)  initrans 255 pctfree 30 NOLOGGING;

alter table warehouse add constraint pk_warehouse primary key (w_id) using index k_warehouse;
alter table district add constraint pk_district primary key (d_w_id, d_id) using index k_district;
alter table item add constraint pk_item primary key (i_id) using index k_item;
alter table new_order add constraint pk_new_order primary key (no_w_id, no_d_id, no_o_id) using index k_new_order;
alter table oorder add constraint pk_oorder primary key (o_w_id, o_d_id, o_id) using index k_oorder;
alter table customer add constraint pk_customer primary key (c_w_id, c_d_id, c_id) using index k_customer;
alter table order_line add constraint pk_order_line primary key (ol_w_id, ol_d_id, ol_o_id, ol_number) using index k_order_line;
alter table stock add constraint pk_stock primary key (s_w_id, s_i_id) using index k_stock;

exec dbms_stats.gather_schema_stats(ownname => 'TPCC',estimate_percent => dbms_stats.AUTO_SAMPLE_SIZE,block_sample => true, degree => 64, granularity => 'ALL',cascade => true,method_opt => 'FOR ALL INDEXED COLUMNS size 1');

