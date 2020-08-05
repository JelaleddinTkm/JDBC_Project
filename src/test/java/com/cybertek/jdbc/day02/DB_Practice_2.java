package com.cybertek.jdbc.day02;


import java.sql.ResultSet;
import java.sql.SQLException;


public class DB_Practice_2 {


    public static void main(String[] args) throws SQLException {

        // print out all data from Jobs Table
        DB_Utility.createConnection();  // ==> CONNECTION SUCCESSFUL

        System.out.println("==============================1===========================");

        ResultSet rs = DB_Utility.runQuery("SELECT * FROM REGIONS");

        // this method call is displaying the data of the resultSet
        DB_Utility.displayAllData();

        /*
        1	Europe
        2	Americas
        3	Asia
        4	Middle East and Africa
         */

        System.out.println("==============================2===========================");

        // move resultset cursor to second row
        // rs.absolute(2);
        //DB_Utility.runQuery("SELECT * FROM EMPLOYEES WHERE SALARY>19000  ");

        DB_Utility.displayAllData();

        /*
        1	Europe
        2	Americas
        3	Asia
        4	Middle East and Africa
         */

        System.out.println("==============================3===========================");

        System.out.println(DB_Utility.getColumnDataAtRow(3, 2));  // Asia
        System.out.println(DB_Utility.getColumnDataAtRow(3, "REGION_NAME")); // Asia

        System.out.println("==============================4===========================");

        DB_Utility.runQuery("SELECT * FROM EMPLOYEES");
        System.out.println(DB_Utility.getRowDataAsList(4) );
        // [103, Alexander, Hunold, AHUNOLD, 590.423.4567, 2006-01-03 00:00:00, IT_PROG, 9000, null, 102, 60]

        System.out.println("==============================5===========================");

        System.out.println( DB_Utility.getColumnDataAsList(2) );
        System.out.println( DB_Utility.getColumnDataAsList("FIRST_NAME") );
    /*
    [Steven, Neena, Lex, Alexander, Bruce, David, Valli, Diana, Nancy, Daniel, John, Ismael, Jose Manuel, Luis, Den, Alexander, Shelli, Sigal, Guy, Karen, Matthew, Adam, Payam, Shanta, Kevin, Julia, Irene, James, Steven, Laura, Mozhe, James, TJ, Jason, Michael, Ki, Hazel, Renske, Stephen, John, Joshua, Trenna, Curtis, Randall, Peter, John, Karen, Alberto, Gerald, Eleni, Peter, David, Peter, Christopher, Nanette, Oliver, Janette, Patrick, Allan, Lindsey, Louise, Sarath, Clara, Danielle, Mattea, David, Sundar, Amit, Lisa, Harrison, Tayler, William, Elizabeth, Sundita, Ellen, Alyssa, Jonathon, Jack, Kimberely, Charles, Winston, Jean, Martha, Girard, Nandita, Alexis, Julia, Anthony, Kelly, Jennifer, Timothy, Randall, Sarah, Britney, Samuel, Vance, Alana, Kevin, Donald, Douglas, Jennifer, Michael, Pat, Susan, Hermann, Shelley, William]
    [Steven, Neena, Lex, Alexander, Bruce, David, Valli, Diana, Nancy, Daniel, John, Ismael, Jose Manuel, Luis, Den, Alexander, Shelli, Sigal, Guy, Karen, Matthew, Adam, Payam, Shanta, Kevin, Julia, Irene, James, Steven, Laura, Mozhe, James, TJ, Jason, Michael, Ki, Hazel, Renske, Stephen, John, Joshua, Trenna, Curtis, Randall, Peter, John, Karen, Alberto, Gerald, Eleni, Peter, David, Peter, Christopher, Nanette, Oliver, Janette, Patrick, Allan, Lindsey, Louise, Sarath, Clara, Danielle, Mattea, David, Sundar, Amit, Lisa, Harrison, Tayler, William, Elizabeth, Sundita, Ellen, Alyssa, Jonathon, Jack, Kimberely, Charles, Winston, Jean, Martha, Girard, Nandita, Alexis, Julia, Anthony, Kelly, Jennifer, Timothy, Randall, Sarah, Britney, Samuel, Vance, Alana, Kevin, Donald, Douglas, Jennifer, Michael, Pat, Susan, Hermann, Shelley, William]
     */



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
