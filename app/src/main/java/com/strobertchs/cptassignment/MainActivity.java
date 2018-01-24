package com.strobertchs.cptassignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening__screen);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Utilities.connectToServer();

    }

//    public void addScreen(View view) {
//        Intent intent = new Intent(this, )
//    }

    public void onChooseSignIn(View view){

        setContentView(R.layout.activity_sign_in_screen);

    }

    public void onChooseRegister(View view){

        setContentView(R.layout.activity_register_screen);

    }

    public void onChooseRegtoSign(View view){

        setContentView(R.layout.activity_sign_in_screen);

    }
    public void onChooseSign2app(View view){
        setContentView(R.layout.activity_main_screen);
        if (Utilities.isConnected()) {
            //setContentView(R.layout.activity_main_screen);
            Utilities.login(getApplicationContext(), "", "");
        }
    }
    public void onwednesday(View view){

        setContentView(R.layout.activity_wednesday);
    }
    public void onmonday(View view){
        setContentView(R.layout.activity_monday);
    }
    public void ontuesday(View view){
        setContentView(R.layout.activity_tuesday);
    }
    public void onthursday(View view){
        setContentView(R.layout.activity_thursday);
    }
    public void onfriday(View view){
        setContentView(R.layout.activity_friday);
    }
    public void onschoolsite(View view){
        Intent link = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://stro.ycdsb.ca/"));
        startActivity(link);
    }
    public void ongoogleclassroom(View view){
        Intent link = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://classroom.google.com/h"));
        startActivity(link);
    }
}
