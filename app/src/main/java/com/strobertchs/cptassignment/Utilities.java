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


public class Utilities
{
    static Connection conn;
    static boolean connected;
    static ActivityInterface app;

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

            Properties p = new Properties();
            p.setProperty("username", username);
            p.setProperty("password", password);
            //execute query to server
            new QueryTask(1).execute(p);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public static boolean register(Context c, String username, String password) {
        boolean result = false;
        try {

            Properties p = new Properties();
            p.setProperty("username", username);
            p.setProperty("password", password);
            //execute query to server
            new QueryTask(2).execute(p);


        } catch (Exception e) {
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
                app.onLogin();
            }
            else
            {
                app.onLoginFail();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void onRegisterComplete(boolean success)
    {
        if (success)
        {
            app.onRegister();
        }
        else
        {
            app.onRegisterFail();
        }
    }

}
