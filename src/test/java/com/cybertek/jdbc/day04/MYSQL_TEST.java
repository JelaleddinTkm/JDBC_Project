package com.cybertek.jdbc.day04;


import com.cybertek.jdbc.utility.ConfigurationReader;
import com.cybertek.jdbc.utility.DB_Utility;



import com.cybertek.jdbc.utility.ConfigurationReader;
import com.cybertek.jdbc.utility.DB_Utility;

public class MYSQL_TEST {

    public static void main(String[] args) {

        // added mysql pom dependency for mysql driver
        // we provided connection string , username password
        // and used the utility to make connection

        String connectionStr = ConfigurationReader.getProperty("library1.database.url");
        String username = ConfigurationReader.getProperty("library1.database.username");
        String password = ConfigurationReader.getProperty("library1.database.password");

        DB_Utility.createConnection(connectionStr,username,password);
        DB_Utility.destroy();


    }

}
