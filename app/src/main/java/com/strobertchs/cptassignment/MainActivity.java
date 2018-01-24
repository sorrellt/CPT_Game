package com.strobertchs.cptassignment;

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
        //Utilities.login(getApplicationContext(), "", "");
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

    }
    public void onwednesday(View view){

        setContentView(R.layout.activity_wednesday);
    }
    public void onmonday(View view){
        setContentView(R.layout.activity_monday);
    }
}
