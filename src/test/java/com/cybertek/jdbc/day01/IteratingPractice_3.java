package com.cybertek.jdbc.day01;

import java.sql.*;

public class IteratingPractice_3 {

        // TASK 1:
        // CREATE A NEW CLASS , ADD CONNECTION , STATEMENT , RESULTSET
        // TRY OUT TO PRINT OUT EACH AND EVERYTHING FROM COUNTRY TABLE


    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@18.234.93.146:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");
        // ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1");

        // as long as rs.next() return true I know I have next row to print the data
        // we will keep looping as long as rs.next() return true

        while ( rs.next() ) {

            System.out.println(rs.getString(1) + " "
                             + rs.getString(2) + " "
                             + rs.getString(3)
            );
        }



    }

}
