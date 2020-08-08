package com.cybertek.jdbc.day03;

import com.cybertek.jdbc.utility.DB_Utility;

public class SpartanDB_Practice {

    public static void main(String[] args) {

        // please create a package called utility
        // and move your DB_Utility under that package

//        String url = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
//        DB_Utility.createConnection(url,"SP","SP");

        DB_Utility.createConnection("dev");


//            Run query "SELECT * FROM SPARTANS"
        DB_Utility.runQuery("SELECT * FROM SPARTANS");

////            1. Display all data in console
//        DB_Utility.displayAllData();

////            2. Print column count
//        System.out.println("COLUMN COUNT IS " + DB_Utility.getColumnCNT() );

////            3. Print row count
//        System.out.println("ROW COUNT IS " + DB_Utility.getRowCount() );


////            4. Print out 3rd row data as a list
//        System.out.println("3RD ROW DATA as a list \n"
//                                    + DB_Utility.getRowDataAsList(3)  );

////            5. Print out 2nd column data as a list
//        System.out.println("2ND COLUMN as a list \n"
//                                    + DB_Utility.getColumnDataAsList(2) );

////            6, Print out Name column data as a list
//        System.out.println("NAME COLUMN as a list \n"
//                                    + DB_Utility.getColumnDataAsList("NAME") ) ;

////            7, Print out 4th row as a Map
//        System.out.println("4TH ROW AS A MAP \n"
//                                    + DB_Utility.getRowMap(4)  );

////            8, Print out the data at row 5, column 1
//        System.out.println("DATA at row 5 column 1 : --->>>  "
//                                    +  DB_Utility.getColumnDataAtRow(5,1));

////            9, Print out the data at row 53, phone column
//        System.out.println("DATA at row 53 Phone column  : --->>>  "
//                +  DB_Utility.getColumnDataAtRow(53,"PHONE") );

////            10. Print out all the data as List of Map
        System.out.println( DB_Utility.getAllDataAsListOfMap() );

        // WE Are storing each row as map object
        // and we have 100 row ,  so can store this 100 map object into one Collection
        // --->>  List of these Map object  List< Map<String,String>  >


//        System.out.println("4TH ROW AS A MAP \n"
//                + DB_Utility.getRowMap(4)  );

//        System.out.println("5TH ROW AS A MAP \n"
//                + DB_Utility.getRowMap(5)  );


    }


}
