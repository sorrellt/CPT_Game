package com.strobertchs.cptassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://ec2-54-235-244-185.compute-1.amazonaws.com:5432/";
        Properties props = new Properties();
        props.setProperty("user","wgibtmqeiltsdf");
        props.setProperty("password","b3ca2821037ac3b7354d13bf6a72291431b5d73a92e5fd03b3c9749ffb460360");
        try {
            Connection conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
