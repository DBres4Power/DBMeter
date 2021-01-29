wcnt=`awk '{print $1}' loader.properties |awk -F= '/warehouses/ {print $2}' |tr -cd "[:digit:]"`
wend=`expr $wcnt - 1`
t_wid=1
cnt_wid=3
slv=0
while [ ${slv} -lt 300 ]
do
used_wid=`expr $slv \* $cnt_wid`
##reserve 1 warehouse at least
wthis=`expr $used_wid + $cnt_wid`
if [ $wthis -gt $wend ];then
st_wid=`expr $wend - $cnt_wid`
else
st_wid=`expr $used_wid + 1`
fi

slv=`expr $slv + 1`
cslv=`echo $slv |awk '{printf("%03d",$1)}'`
echo "cslv=$cslv " "st_wid=$st_wid "

if [ ${slv} -gt 150 ];then
sed "s/SLAVE_ID/slave${cslv}/g; s/CNT_WID/${cnt_wid}/g; s/START_WID/${st_wid}/g; s/102.119/109.119/g;" slaveXX.properties > slave${cslv}.properties
else
sed "s/SLAVE_ID/slave${cslv}/g; s/CNT_WID/${cnt_wid}/g; s/START_WID/${st_wid}/g;" slaveXX.properties > slave${cslv}.properties
fi
done

