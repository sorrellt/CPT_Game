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

public class QueryTask extends AsyncTask<Properties, Void, ResultSet>
{
    // 0 = connect, 1 = login, 2 = register
    private int queryType;
    static Connection conn;

    public QueryTask(int queryType)
    {
        this.queryType = queryType;
    }

    @Override
    protected ResultSet doInBackground(Properties... props) {
        try {
            if (queryType == 0) // connect to server
            {
                String url = "jdbc:postgresql://ec2-54-235-244-185.compute-1.amazonaws.com:5432/db7cra04jm8qls";
                Properties urlprops = new Properties();
                urlprops.setProperty("user","wgibtmqeiltsdf");
                //urlprops.setProperty("database", "db7cra04jm8qls");
                urlprops.setProperty("password","b3ca2821037ac3b7354d13bf6a72291431b5d73a92e5fd03b3c9749ffb460360");
                urlprops.setProperty("ssl", "true");
                urlprops.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
                try {
                    conn = DriverManager.getConnection(url, urlprops);
                    Utilities.setConnection(conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
            else if (queryType == 1)
            {
                return getLoginQuery(props[0].getProperty("username"), props[0].getProperty("password")).executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PreparedStatement getLoginQuery(String username, String password) throws SQLException {
        PreparedStatement statement =  conn.prepareStatement("select username, password from accounts");
        statement.setString(1, username);
        statement.setString(2, password);
        return statement;
    }

    @Override
    protected void onPostExecute(ResultSet result)
    {
        if (queryType == 0)
        {
            Utilities.setConnected(true);
        }
        else if (queryType == 1) //login query
        {
            Utilities.onLoginComplete(result);
        }
    }
}
