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
    static boolean connected;

    public static void connectToServer()
    {
        new QueryTask(0).execute();
    }

    public static Connection getConnection()
    {
        return conn;
    }
    public static void setConnection(Connection conn)
    {
        Utilities.conn = conn;
    }

    public static boolean isConnected()
    {
        return connected;
    }

    public static void setConnected(boolean connected)
    {
        Utilities.connected = connected;
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
            PreparedStatement statement = QueryTask.conn.prepareStatement("select username, password from accounts");


            //execute query to server
            new QueryTask(0).execute(statement);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public static void onLoginComplete(ResultSet rs)
    {
        try {
            while (rs.next())//if ResultSet.next() is true means match found
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
