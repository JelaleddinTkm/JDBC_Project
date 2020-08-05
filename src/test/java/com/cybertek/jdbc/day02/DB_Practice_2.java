package com.cybertek.jdbc.day02;


import java.sql.ResultSet;
import java.sql.SQLException;


public class DB_Practice_2 {

    public static void main(String[] args) throws SQLException {


        // print out all data from Jobs Table
        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("SELECT * FROM REGIONS");
        // this method call is displaying the data of the resultset
        DB_Utility.displayAllData();

        // move resultset cursor to second row
        // rs.absolute(2);
        //DB_Utility.runQuery("SELECT * FROM EMPLOYEES WHERE SALARY>19000  ");
        DB_Utility.displayAllData();

        System.out.println(DB_Utility.getColumnDataAtRow(3, 2));
        System.out.println(DB_Utility.getColumnDataAtRow(3, "REGION_NAME"));

        DB_Utility.runQuery("SELECT * FROM EMPLOYEES");
        System.out.println(DB_Utility.getRowDataAsList(4) );


        System.out.println( DB_Utility.getColumnDataAsList(2) );

    /*
        // get the first row data  | without knowing the column names
        int colCount = DB_Utility_1.getColumnCNT() ;

        // in order to get whole result cursor must be at before first location !
        while ( rs.next() ) {    // row iteration

                for (int i = 1; i <= colCount; i++) {
                    System.out.print( rs.getString(i) + "\t" );
                }
        }

    */


    }


}
