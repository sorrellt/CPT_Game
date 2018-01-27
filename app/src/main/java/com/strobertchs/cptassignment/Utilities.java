package com.strobertchs.cptassignment;

import android.content.Context;
import java.sql.Connection;
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

    public static void login(String username, String password) {
        try {

            Properties p = new Properties();
            p.setProperty("username", username);
            p.setProperty("password", password);
            //execute query to server
            new QueryTask(1).execute(p);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void register(String username, String password) {
        try {

            Properties p = new Properties();
            p.setProperty("username", username);
            p.setProperty("password", password);
            //execute query to server
            new QueryTask(2).execute(p);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void onLoginComplete(ResultSet rs)
    {
        try {
            if (rs.next())//if ResultSet.next() is true means match found
            {
                MainActivity.user = rs.getString("username");
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

    public static void onEventUpdate()
    {
        app.eventConfirm();
    }
    public static void onEventLoad(ResultSet rs, int day){
        if (day == 0){
            app.onmondayload(rs);
        }
        else if(day == 1){
            app.ontuesdayload(rs);
        }
        else if(day == 2){
            app.onwednesdayload(rs);
        }
        else if(day == 3){
            app.onthursdayload(rs);
        }
        else if(day == 4){
            app.onfridayload(rs);
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
    public static void loadEvent(String username, int day) {
        try {

            Properties p = new Properties();
            p.setProperty("username", username);
            p.setProperty("day", Integer.toString(day));
            //execute query to server
            new QueryTask(4).execute(p);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateEvent(String username, int day, String eventName, String eventTime, int eventRmNumber, String eventDetails) {
        try {

            Properties p = new Properties();
            p.setProperty("username", username);
            p.setProperty("day", Integer.toString(day));
            p.setProperty("eventName", eventName);
            p.setProperty("eventTime", eventTime);
            p.setProperty("eventRmNumber", Integer.toString(eventRmNumber));
            p.setProperty("eventDetails", eventDetails);
            //execute query to server
            new QueryTask(3).execute(p);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
