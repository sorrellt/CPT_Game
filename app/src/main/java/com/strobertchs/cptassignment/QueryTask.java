package com.strobertchs.cptassignment;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class QueryTask extends AsyncTask<Properties, Void, ResultSet>
{
    private int queryType;
    private int day;
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
            else if (queryType == 2)
            {
                return getRegisterQuery(props[0].getProperty("username"), props[0].getProperty("password")).executeQuery();
            }
            else if (queryType == 3)
            {
                return getEventUpdateQuery(props[0].getProperty("username"), Integer.parseInt(props[0].getProperty("day")), props[0].getProperty("eventName"), props[0].getProperty("eventTime"), Integer.parseInt(props[0].getProperty("eventRmNumber")), props[0].getProperty("eventDetails")).executeQuery();
            }
            else if (queryType == 4)
            {
                day = Integer.parseInt(props[0].getProperty("day"));
                return getEventSelectQuery(props[0].getProperty("username"), Integer.parseInt(props[0].getProperty("day"))).executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PreparedStatement getLoginQuery(String username, String password) throws SQLException {
        PreparedStatement statement =  conn.prepareStatement("select username, password from accounts where username = ? and password = ?");
        statement.setString(1, username);
        statement.setString(2, password);
        return statement;
    }

    private PreparedStatement getRegisterQuery(String username, String password) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("insert into accounts(username, password) values (?, ?) returning *");
        statement.setString(1, username);
        statement.setString(2, password);
        return statement;
    }

    private PreparedStatement getEventSelectQuery(String username, int day) throws SQLException{
        PreparedStatement statement = conn.prepareStatement(" select event_name, event_time, event_rm_number, event_details from events where username = ? and day = ?");
        statement.setString(1, username);
        statement.setInt(2, day);
        return statement;
    }

    private PreparedStatement getEventUpdateQuery(String username, int day, String eventName, String eventTime, int eventRmNumber, String eventDetails) throws SQLException{
        PreparedStatement statement = conn.prepareStatement(" insert into events(username, day, event_name, event_time, event_rm_number, event_details) values (?, ?, ?, ?, ?, ?) on conflict (username, day) do update set event_name = EXCLUDED.event_name, event_time = EXCLUDED.event_time, event_rm_number = EXCLUDED.event_rm_number, event_details = EXCLUDED.event_details ");
        statement.setString(1, username);
        statement.setInt(2, day);
        statement.setString(3, eventName);
        statement.setString(4, eventTime);
        statement.setInt(5, eventRmNumber);
        statement.setString(6, eventDetails);

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
        else if (queryType == 2)
        {
            try {
                Utilities.onRegisterComplete(result.next());
            } catch (SQLException e) {
                Utilities.onRegisterComplete(false);
                e.printStackTrace();
            }
        }
        else if (queryType == 3)
        {
            Utilities.onEventUpdate();
        }

    }
}
