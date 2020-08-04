package com.cybertek.jdbc.day01;

import java.sql.*;

public class IteratingResultSetBackward_5 {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@18.234.93.146:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);

        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");


        rs.afterLast();


        while ( rs.previous() ){
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }

        /*
        4 Middle East and Africa
        3 Asia
        2 Americas
        1 Europe
         */

        System.out.println("------------more moving ------------------");


    // How to move to the second row from here?

        rs.absolute(2);  // 2 Americas
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        rs.first();          // 1 Europe
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        rs.last();          // 4 Middle East and Africa
        System.out.println(rs.getString(1) + " " + rs.getString(2));


    // How do I know which row number I am right now at this location

        // getRow() method return the row number
        System.out.println("rs.getRow()  = " + rs.getRow());

        // there is no count method in ResultSet
        // so in order to get the row count of the resultSet
        // just return the last row number by moving cursor to last row and call getRow method

    }

}