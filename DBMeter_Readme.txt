DB2
	username: db2inst1
	password: tpcc
	
	1. Create Database
	
	2. Create Table
		
		db2batch -d tpcc -f sql/example/db2/create_table.sql
	
	3. Load Data

		java -cp bin/DBMeter_v1.0.jar:lib/db2jcc4.jar rdbms.DBMeter.Loader conf/example/db2/loader.properties

	4. Create index
		
		db2batch -d tpcc -f sql/example/db2/create_index.sql

	5. Run Master
		
                java -cp bin/DBMeter_v1.0.jar:lib/db2jcc4.jar rdbms.DBMeter.Master conf/example/db2/master.properties

    	6. Run Slaves on Clients

                java -cp bin/DBMeter_v1.0.jar:lib/db2jcc4.jar rdbms.DBMeter.Slave conf/example/db2/slave001.properties
                java -cp bin/DBMeter_v1.0.jar:lib/db2jcc4.jar rdbms.DBMeter.Slave conf/example/db2/slave002.properties

	7. Check Data and Result

		## count table data
		 db2batch -d tpcc -f  sql/example/mysql/select_cnt.sql
		## check result, compare with log_master
		 db2batch -d tpcc -f  sql/example/mysql/chk_rlt.sql

MySQL

	username: root
	password: tpcc

	1. Create Database
		
		mysql -uroot -prootroot -vvv -n < sql/example/mysql/create_database.sql

	2. Create Table

		mysql -uroot -prootroot -vvv -n < sql/example/mysql/create_table.sql

	3. Load Data
		
		java -cp bin/DBMeter_v1.0.jar:lib/mysql-connector-java-5.1.7-bin.jar rdbms.DBMeter.Loader conf/example/mysql/loader.properties

	4. Create index

		mysql -uroot -prootroot -vvv -n < sql/example/mysql/create_index.sql

	5. Run Master

		java -cp bin/DBMeter_v1.0.jar:lib/mysql-connector-java-5.1.7-bin.jar rdbms.DBMeter.Master conf/example/mysql/master.properties

	6. Run Slaves on Clients

		java -cp bin/DBMeter_v1.0.jar:lib/mysql-connector-java-5.1.7-bin.jar rdbms.DBMeter.Slave conf/example/mysql/slave001.properties
		java -cp bin/DBMeter_v1.0.jar:lib/mysql-connector-java-5.1.7-bin.jar rdbms.DBMeter.Slave conf/example/mysql/slave002.properties

	7. Check Data and Result

		## count table data
		mysql -uroot -prootroot -vvv -n < sql/example/mysql/select_cnt.sql
		## check result, compare with log_master
		mysql -uroot -prootroot -vvv -n < sql/example/mysql/chk_rlt.sql

PostgreSQL

	username: tpcc
	password: tpcc

	1. Create User & Database
		
		psql -d postgres -f sql/example/postgresql/create_user.sql
		psql -d postgres -f sql/example/postgresql/create_database.sql

	2. Create Table

		psql -U tpcc -d tpcc -f sql/example/postgresql/create_table.sql

	3. Load Data
		
		java -cp bin/DBMeter_v1.0.jar:lib/postgresql-42.2.8.jar rdbms.DBMeter.Loader conf/example/postgresql/loader.properties

	4. Create index

		psql -U tpcc -d tpcc -f sql/example/postgresql/create_index.sql

	5. Run Master

		java -cp bin/DBMeter_v1.0.jar:lib/postgresql-42.2.8.jar rdbms.DBMeter.Master conf/example/postgresql/master.properties

	6. Run Slaves on Clients

		java -cp bin/DBMeter_v1.0.jar:lib/postgresql-42.2.8.jar rdbms.DBMeter.Slave conf/example/postgresql/slave001.properties
		java -cp bin/DBMeter_v1.0.jar:lib/postgresql-42.2.8.jar rdbms.DBMeter.Slave conf/example/postgresql/slave002.properties

	7. Check Data and Result

		## count table data
		psql -U tpcc -d tpcc -f sql/example/postgresql/select_cnt.sql
		## check result, compare with log_master
		psql -U tpcc -d tpcc -f sql/example/postgresql/chk_rlt.sql

SQLServer

	1. Create Database

		sqlcmd -e -p 1 -y 30 -Y 30 -i sql\example\sqlserver\create_database.sql

	2. Create User

		sqlcmd -e -p 1 -y 30 -Y 30 -i sql\example\sqlserver\create_user.sql

	3. Create Tables

		sqlcmd -e -p 1 -y 30 -Y 30 -i sql\example\sqlserver\create_table.sql
		
	4. Load Data
		
		java -cp bin/DBMeter_v1.0.jar;lib\sqljdbc4.jar rdbms.DBMeter.Loader conf\example\sqlserver\loader.properties

	5. Create index

		sqlcmd -e -p 1 -y 30 -Y 30 -i sql\example\sqlserver\create_index.sql

	6. Run Master

		java -cp bin/DBMeter_v1.0.jar;lib\sqljdbc4.jar rdbms.DBMeter.Master conf\example\sqlserver\master.properties

	7. Run Slaves on Clients

		java -cp bin/DBMeter_v1.0.jar;lib\sqljdbc4.jar rdbms.DBMeter.Slave conf\example\sqlserver\slave001.properties
		java -cp bin/DBMeter_v1.0.jar;lib\sqljdbc4.jar rdbms.DBMeter.Slave conf\example\sqlserver\slave002.properties


Oracle

	1. Create Tablespace

		sqlplus / as sysdba @sql/example/oracle/create_tablespace.sql
		
	2. Create User

		sqlplus / as sysdba @sql/example/oracle/create_user.sql

	3. Create Tables

		sqlplus user1/pswd @sql/example/oracle/create_table.sql

	4. Load Data
		
		java -cp bin/DBMeter_v1.0.jar:lib/ojdbc8.jar:lib/orai18n.jar rdbms.DBMeter.Loader conf/example/oracle/loader.properties

	5. Create index

		sqlplus user1/pswd @sql/example/oracle/create_index.sql

	6. Run Master

		java -cp bin/DBMeter_v1.0.jar:lib/ojdbc8.jar:lib/orai18n.jar rdbms.DBMeter.Master conf/example/oracle/master.properties

	7. Run Slaves on Clients

		java -cp bin/DBMeter_v1.0.jar:lib/ojdbc8.jar:lib/orai18n.jar rdbms.DBMeter.Slave conf/example/oracle/slave001.properties
		java -cp bin/DBMeter_v1.0.jar:lib/ojdbc8.jar:lib/orai18n.jar rdbms.DBMeter.Slave conf/example/oracle/slave002.properties

	8. Check Data and Result

		## count table data
		sqlplus tpcc/tpcc  @sql/example/oracle/select_cnt.sql
		## check result, compare with log_master
		sqlplus tpcc/tpcc  @sql/example/oracle/chk_rlt.sql

KDB

	1. Create Tablespace

		kdsql sys/kdb @sql/example/kdb/create_tablespace.sql
		
	2. Create User

		kdsql sys/kdb @sql/example/kdb/create_user.sql

	3. Create Tables

		kdsql tpcc/tpcc @sql/example/kdb/create_table.sql

	4. Load Data
		
		java -cp bin/DBMeter_v1.0.jar:lib/inspur11-jdbc.jar rdbms.DBMeter.Loader conf/example/kdb/loader.properties

	5. Create index

		kdsql tpcc/tpcc @sql/example/kdb/create_index.sql

	6. Run Master

		java -cp bin/DBMeter_v1.0.jar:lib/inspur11-jdbc.jar rdbms.DBMeter.Master conf/example/kdb/master.properties

	7. Run Slaves on Clients

		java -cp bin/DBMeter_v1.0.jar:lib/inspur11-jdbc.jar rdbms.DBMeter.Slave conf/example/kdb/slave001.properties
		java -cp bin/DBMeter_v1.0.jar:lib/inspur11-jdbc.jar rdbms.DBMeter.Slave conf/example/kdb/slave002.properties

	8. Check Data and Result

		## count table data
		kdsql sys/kdb @sql/example/kdb/select_cnt.sql
		## check result, compare with log_master
		kdsql sys/kdb @sql/example/kdb/chk_rlt.sql

Informix

	username: informix
	password: tpcc

	1. Create dbspace

		onspaces -c -d tpccdbs1 -p $INFORMIXDIR/data/tpccdbs1 -o 0 -s `cat /proc/partitions | awk '/sdc/{printf "%d000",$3/1000}'` -ef 1024 -en 8192 -k 4
		printf "\n" | ontape -s -L 0

	2. Create Database

		dbaccess - sql/example/informix/create_database.sql

	3. Create Tables

		dbaccess tpcc sql/example/informix/create_table.sql
		
	4. Load Data
		
		java -cp bin/DBMeter_v1.0.jar:lib/ifxjdbc.jar rdbms.DBMeter.Loader conf/example/informix/loader.properties

	5. Create index

		dbaccess tpcc sql/example/informix/create_index.sql

	6. Run Master

		java -cp bin/DBMeter_v1.0.jar:lib/ifxjdbc.jar rdbms.DBMeter.Master conf/example/informix/master.properties

	7. Run Slaves on Clients

		java -cp bin/DBMeter_v1.0.jar:lib/ifxjdbc.jar rdbms.DBMeter.Slave conf/example/informix/slave001.properties
		java -cp bin/DBMeter_v1.0.jar:lib/ifxjdbc.jar rdbms.DBMeter.Slave conf/example/informix/slave002.properties

	8. Check Data and Result

		## count table data
		dbaccess tpcc sql/example/kdb/select_cnt.sql
		## check result, compare with log_master
		dbaccess tpcc sql/example/kdb/chk_rlt.sql
