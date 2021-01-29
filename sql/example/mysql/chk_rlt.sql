use tpcc;

select 'detail_info' detail, a.* from dbmeter_result a
where s_phase='Run_avg' and t_time> (select max(t_time) from dbmeter_result where s_phase='Warmup');

select 'sum_of_trans' trans,sum(tpm) avg_tpm,sum(num_total) all_trans,sum(warmup_total) warmup_trans, sum(num_total-warmup_total) run_total
from dbmeter_result where s_phase='Run_avg' and t_time> (select max(t_time) from dbmeter_result where s_phase='Warmup');

select 'avg_tpm' avg_tpm,  sum(tpm) tpm from dbmeter_result 
where s_phase='Run_avg' and t_time> (select max(t_time) from dbmeter_result where s_phase='Warmup');

