package com.strobertchs.cptassignment;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Ali on 2018-01-15.
 */

public class Utilities
{
    static Connection conn;

    public static Connection connectToServer()
    {
        String url = "jdbc:postgresql://ec2-54-235-244-185.compute-1.amazonaws.com:5432/";
        Properties props = new Properties();
        props.setProperty("user","wgibtmqeiltsdf");
        props.setProperty("password","b3ca2821037ac3b7354d13bf6a72291431b5d73a92e5fd03b3c9749ffb460360");
        try {
            Connection conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getConnection()
    {
        return conn;
    }

    public static boolean login(Context c, String username, String password) {
        boolean result = false;
        try {
//            PreparedStatement statement = conn.prepareStatement("select username, password from accounts where username = ? and password = ?");
//
//            //put theusername and pw into statement(in where the question marks are)
//            statement.setString(1, username);
//            statement.setString(2, password);

            if (conn == null) {
                Log.i("test", "milk");
            }
            PreparedStatement statement = conn.prepareStatement("select username, password from accounts");


            //execute query to server
            ResultSet rs = statement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public static void onLoginComplete(ResultSet rs)
    {
        try {
            if (rs.next())//if ResultSet.next() is true means match found
            {
                Log.i("username", rs.getString("username"));
                Log.i("password", rs.getString("password"));
//                Toast.makeText(c, "Sign-in successful", Toast.LENGTH_SHORT).show();
//                Toast.makeText(c, rs.getString("username"), Toast.LENGTH_SHORT).show();
//                Toast.makeText(c, rs.getString("password"), Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
