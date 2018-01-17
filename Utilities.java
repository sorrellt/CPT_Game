package com.strobertchs.cptassignment;

import android.util.Log;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Ali on 2018-01-15.
 */

public class Utilities
{
    static ComboPooledDataSource cpds;

    public static ComboPooledDataSource connectToServer()
    {
        cpds = new ComboPooledDataSource();

        try
        {
            cpds.setDriverClass("org.postgresql.Driver");
            cpds.setUser("wgibtmqeiltsdf");
            cpds.setPassword("b3ca2821037ac3b7354d13bf6a72291431b5d73a92e5fd03b3c9749ffb460360");
            cpds.setJdbcUrl("jdbc:postgresql://ec2-54-235-244-185.compute-1.amazonaws.com:5432/");

            cpds.setMinPoolSize(1);
            cpds.setMaxPoolSize(1);
            cpds.setAcquireIncrement(0);
        }
        catch(Exception sqle)
        {
            Log.e("sql", sqle.getMessage());
        }

        return cpds;
    }

    public static Connection getConnection() throws SQLException
    {
        return cpds.getConnection();
    }

    public static boolean login(String username, String password)
    {
        boolean result = false;
        try
        {
            Connection con = getConnection();

            preparedStatement statement = con.prepareStatement("select username, password from accounts where username = ? and password = ?");

            //put theusername and pw into statement(in where the question marks are)
            statement.setString(1, username);
            statement.setString(2, password);

            //execute query to server
            ResultSet rs = sta.executeQuery();

            if(rs.next())//if ResultSet.next() is true means match found
            {
                result = true;
            }
        }
    }
}
