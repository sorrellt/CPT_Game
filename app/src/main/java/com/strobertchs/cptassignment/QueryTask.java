package com.strobertchs.cptassignment;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by robuntu on 1/23/18.
 */

public class QueryTask extends AsyncTask<PreparedStatement, Void, ResultSet>
{
    private int queryType;

    public QueryTask(int queryType)
    {
        this.queryType = queryType;
    }

    @Override
    protected ResultSet doInBackground(PreparedStatement... statement) {
        try {
            if (queryType == 0) // connect to server
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
                return null;
            }
            else
            {
                return statement[0].executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ResultSet result)
    {
        if (queryType == 1) //login query
        {

        }
    }
}
