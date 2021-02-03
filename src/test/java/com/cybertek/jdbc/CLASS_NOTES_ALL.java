package com.cybertek.jdbc;

public class CLASS_NOTES_ALL {

    /*

What is JDBC ?

Java Database Connectivity
	--  Comes with JDK , used to work with relational database system
	--  Its under java.sql package   import java.sql.* ;
	--  It define set of Interfaces and classes to work with any RDBMS

 Java App   ------ JDBC ------- Actual Database you are connecting to

 JDBC does not provide actual implementation.
 Each RDBMS(database vendor like Oracle, MySQL, Postgress) will provide
 actual implementation known as driver

 so oracle has oracle driver ( the one we are using thin driver)
 and mysql has connectorJ driver  and others has their own driver

 We used the maven dependency to import this driver

        <dependency>
            <groupId>com.oracle.ojdbc</groupId>
            <artifactId>ojdbc8</artifactId>
            <version>19.3.0.0</version>
        </dependency>


  JDBC has DriverManager class to manage connection according to
  		the url | connection string  and username /password
  		to get connection object

  	url | connection string  (YOU WILL BE GIVE THIS INFORMATION)
  	"jdbc:oracle:thin:@IP_ADDRESS:1521:XE";
  	jdbc  --  connection using java
  	oracle -- database vendor , RDBMS
  	thin  --- one type oracle driver
  	IP_ADDRESS  -- HOSTNAME or IP
  	1521  ---- port used for oracle database
  	XE   ----- sid name  unique identifier for your oracle db


 3 important Interfaces in JDBC

 	Connection
 		according to the connection string | url and username password provided
 		DriverManager will look for suitable driver of that RDBMS
 		and return the Connection object
 		Connection conn = DriverManager.getConnection(url,username,password)

 	Statement
 		we can use the Connection object created above to create Statement object
 		2 ways of creating statement object

 		// this will be used to created forward only ResultSet
 		// and we can not move up and down freely using this
 		Statement stmt = conn.createStatement();

 		// this will be used to created ResultSet that can move freely
 		Statement stmt
 		= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );


 	ResultSet
 		This is used to store the result of the query run
 		and it has a lot of built in method to work with its data

		ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");


		Connection , Statement , ResultSet are all resources need to be closed after usage
		call the close method to close at the end of the code
		rs.close() ;
		stmnt.close();
		conn.close();



		the resultset contains all the data returned from the query
		it also has a cursor that point to the row you are currently at

		the cursor by default at before-first location ,  right before first row

		in order to get to the next row  --- next() method is used so we can read first row data

		rs.next()

	getting the data using the column names or column index
			getString(ColumName)
			getString(Index)
			getInt(ColumName)
			getInt(Index)
			getDouble(ColumName)
			getDouble(Index)
			getDate(ColumName)
			getDate(Index)

		rs.getString(1) --->> return the first column cell value at this row
		rs.getString("column name") --->> return the cell value at this column at this row

	----- other methods available under ResultSet class

		rs.next()       // move to next
		rs.previous()   // move to previous
		rs.first() 		// move to first row
		rs.last()		// move to last row
		rs.beforeFirst()  // back to before first row location
		rs.afterLast() 	  // move to the after last row location
		rs.absolute(rowNum)   // move specific row you specified


	---- Iterating over a ResultSet object to see all rows data

	// make sure we are at before first location
	  while( rs.next() == true ){

	  		print( rs.getString( "some column name here") ) ;

	  }

	  // make sure you are at after last location
	  while (rs.previous() == true ){

	  		print( rs.getString( "some column name here") ) ;

	  }

	  ---- we can get meta data out of our resultset object to
	  	get the informations like Column names , data type , column count

	  // ResultSetMetadata is data about the ResultSet like column count , column name
        // any many more info about the ResultSet itself
        // getMetaData method will return ResultSetMetaData object
        ResultSetMetaData rsmd = rs.getMetaData();
        // counting how many columns we have in our ResultSet object
        int columnCount =  rsmd.getColumnCount() ;
        System.out.println("columnCount = " + columnCount);

        // find out column name according to the index
        String secondColumnName = rsmd.getColumnName(2);
        System.out.println("secondColumnName = " + secondColumnName);



-----  eventually we will create a utility class with many reusable methods
		to hire all the complexicity so we can directly say
		run this query and store the result to a data structure like list or map
		or Lits<Map<>>

---- few scenario you will use your database knowledge

	 * test case require the data added through the UI is persisted in the database
	 * the data dispayed on the UI side is actually coming from database

	 * get the latest up to date data to work with your exising scenario

	 	assuming you are working on amazon order details page
	 	you will need to have a valid order id (which can not be made up )
	 	to get those details
	 	Assuming the order info is stored in ORDER table
	 	write a query to grab valid order id with valid state ()
	 	then run your UI test with that valid data

	 	SELECT order_id from ORDER where status = 'SHIPPING' ;

	 	--- how do you handle dynamic data in UI
	 	-- for example the data work on expire once you run your test
	 	-- and next time you run the test it will fail because of data

	 	--  I will make a connection with the database using JDBC
	 	--  I query the database to get valid data ,
	 	-- and use that data to run the test




Utility class  :
		static fields|variables
			    private static Connection conn;
			    private static Statement stmnt;
			    private static ResultSet rs ;

		static methods :

		public static void createConnection()
			PENDING : public static void createConnection(url, user, password)

		public static ResultSet runQuery(String query)
		public static void destroy()
		public static int getRowCount()
		public static int getColumnCNT()

		public static List<String> getColumnDataAsList(int columnIndex)
		public static List<String> getColumnDataAsList(String columnName)

		public static List<String> getColumnDataAtRow (int rowNum , int columnIndex)
		public static List<String> getColumnDataAtRow (int rowNum , String columnName)

		public static Map<String,String> getRowMap( int rowNum )
		public static List<Map<String,String>> getAllDataAsListOfMap()

		add more..


Database connectionString , username password are
	information should be kept outside of source code



	SQL --- Programming language to access , manipulate relational database


	MYSQL -- like Oracle Database , is a RDBMS --Relational Database Management System



	Oracle SQL Developer is the IDE by Oracle to easily work with oracle databse

	each database vendors usually have their own IDE and yet support different database

	MYSQL database has its specific IDE called MYSQL Workbench

	Oracle SQL Developer also support connecting to other databases by adding their driver
	so if we connect to MYSQL database we provide mysql database driver so we can make connection



Download MYSQL driver

	go to sql developer
		go to preference (mac user  COMMAND + comma(,) )
		go to preference (windows user , tools . preference )

		select database from right panel , expand it
		you will see Third party database driver
		Click on add entry -- find your driver file and click select


In IntelliJ project this will add the driver automatically in pom
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.21</version>
        </dependency>


MySQL Connection
        String connectionStr = "jdbc:mysql://18.233.97.71:3306/library1";
        String username = "library1_client" ;
        String password = "WVF4NdGXCKHeE6VQ" ;

        DB_Utility.createConnection(connectionStr,username,password);
        DB_Utility.destroy();




------- difference between truncate and drop
--- truncate will delete all the data from the table but will keep the table structure
--- drop will delete the table + all of its data


DML  : data maipulation language SELECT , INSERT , UPDATE ,DELETE

DDL : data definition languge  CREATE , ALTER , DROP , TRUNCATE , RENAME


DIFFERENCE BETWEEN JOIN AND SET OPERATORS
	JOIN USE PRIMARY KEY AND FOREIGN KEY RELATIONSHIP SO WE CAN QUERY MULTIPLE TABLE
	2 TABLE CAN HAVE ANY NUMBER OF COLUMNS OR DATA TYPES
	AS LONG AS PRIMARY KEY AND FOREIGN KEY RELATIONSHIP EXISTS



     SET OPERATORS LIKE UNION , UNION ALL , MINUS , INTERSECT
     IS USED FOR 2 RESULTSET OF QUERY WITH SAME COLUMN COUNT , COLUMN DATA TYPE , COLUMN NAME

--- UNION ALL
    -- WILL COMBINE THE RESULTSET OF 2 QUERY ON TOP OF EACH OTHER.
      --- IT DOES NOT REMOVE DUPLICATE IT DOES NOT SORT

--- UNION
     -- WILL COMBINE THE RESULTSET OF 2 QUERY ON TOP OF EACH OTHER.
     --- REMOVE DUPLICATE AND SORT BY FIRST COLUMN

--- MINUS
    --- WILL REMOVE FROM FIRST RESULTSET IF IT EXISTS IN SECOND TABLE

--- INTERSECT
    --- WILL ONLY RETURN THE MATCHING(OVERLAPING) ROWS FROM BOTH RESULTSET

      WHAT IS A VIRTUAL TABLE  : VIEW
      A view is a virtual table resulted from a query and act like a table
      Its easy to create view from SQL Develoepr
      by clicking view -- new -->> provide the valid query and click ok
      if the name of the view is EMP_NAME_SALARY_VIEW
        you can query using

      SELECT * FROM EMP_NAME_SALARY_VIEW
      just like you would for any table
      Command for creating table is :

      CREATE VIEW YOUR_VIEW_NAME_HERE AS (
            THE QUERY GOES HERE
      )


------  JDBC REVIEW

    JDBC is java database connectivity, which helps us connect java and database, in order to connect we need a database driver
    we have 3 important interfaces: CONNECTION, STATEMENT, RESULTSET

    EACH DATABASE VENDOR WILL HAVE THEIR DRIVER TO PROVIDE IMPLEMENTATION
    ORACLE HAS ORACLE DRIVER , MYSQL HAS MYSQL DRIVER
    AND in our maven project we specify the drivers as dependency

        This is oracle dependency

        <dependency>
            <groupId>com.oracle.ojdbc</groupId>
            <artifactId>ojdbc8</artifactId>
            <version>19.3.0.0</version>
        </dependency>


        This is my sql dependency

         <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.21</version>
        </dependency>

      Once we have the driver
      DriverManager Class will use the Connection String , username , password
      to create the Connection object
      Connection String is the way Driver manager find database vendor , driver type
      host and port information

      Then we create a statement and with that we get resultset to work on .
      It does not matter what database vendor you are connecting ,
      JDBC will work the same way.


     */
}
