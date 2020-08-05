package com.cybertek.jdbc.day01;

import java.sql.*;


public class MovingForwardAndBackwardWithResult_4 {



    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
        String username = "hr" ;
        String password = "hr" ;
        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        // if we create the Statement in this way , this will generate a forward only resultSet
        // meaning we can only move forward with next() and can not move backward with previous
        //Statement stmnt = conn.createStatement();
        // ResultSet.TYPE_SCROLL_INSENSITIVE will make the resultSet created from this statement
        // be able to move forward and backward ,
        // ResultSet.CONCUR_READ_ONLY  will make resultSet readonly and that's what we need

        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY) ;

        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES") ;

        rs.next() ;
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.next() ;
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));


   // HOW DO I GO BACK TO PREVIOUS ROW

        rs.previous();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));


    // MOVING THE CURSOR FREELY between rows
        // rs.previous();    --->> we are out of first row,
        // System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));


    // MOVING THE LAST ROW directly
        rs.last();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

    // MOVING THE FIRST ROW directly
        rs.first();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

    // MOVING THE DESIRED ROW directly
        rs.absolute(5);
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.beforeFirst();
        rs.afterLast();
    }

}
