use tpcc;

select 'count_of_warehouse  ' tbname,count(1) cnt from warehouse  ;
select 'count_of_item       ' tbname,count(1) cnt from item       ;
select 'count_of_district   ' tbname,count(1) cnt from district   ;
select 'count_of_customer   ' tbname,count(1) cnt from customer   ;
select 'count_of_stock      ' tbname,count(1) cnt from stock      ;
select 'count_of_history    ' tbname,count(1) cnt from history    ;
select 'count_of_new_order  ' tbname,count(1) cnt from new_order  ;
select 'count_of_oorder     ' tbname,count(1) cnt from oorder     ;
select 'count_of_order_line ' tbname,count(1) cnt from order_line ;


