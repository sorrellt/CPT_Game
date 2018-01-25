package com.strobertchs.cptassignment;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements ActivityInterface {
    @LayoutRes
    private int backlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening__screen);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Utilities.app = this;
        Utilities.connectToServer();

    }

//    public void addScreen(View view) {
//        Intent intent = new Intent(this, )
//    }

    public void onChooseSignIn(View view){

        setContentView(R.layout.activity_sign_in_screen);
        setbacklayout(R.layout.activity_opening__screen);
    }

    public void onChooseRegister(View view){

        setContentView(R.layout.activity_register_screen);
        setbacklayout(R.layout.activity_opening__screen);

    }

    public void onChooseRegtoSign(View view){

        setContentView(R.layout.activity_sign_in_screen);
        setbacklayout(R.layout.activity_opening__screen);

    }
    public void onChooseSign2app(View view){
        if (Utilities.isConnected()) {
            Utilities.login(getApplicationContext(), "Marco", "Milk");
        }
    }
    public void onwednesday(View view){

        setContentView(R.layout.activity_wednesday);
        setbacklayout(R.layout.activity_main_screen);
    }
    public void onmonday(View view){
        setContentView(R.layout.activity_monday);
        setbacklayout(R.layout.activity_main_screen);
    }
    public void ontuesday(View view){
        setContentView(R.layout.activity_tuesday);
        setbacklayout(R.layout.activity_main_screen);
    }
    public void onthursday(View view){
        setContentView(R.layout.activity_thursday);
        setbacklayout(R.layout.activity_main_screen);
    }
    public void onfriday(View view){
        setContentView(R.layout.activity_friday);
        setbacklayout(R.layout.activity_main_screen);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            setContentView(backlayout);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        return super.onOptionsItemSelected(item);
    }
    public void setbacklayout(@LayoutRes int layout){
        backlayout = layout;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onLogin() {
        setContentView(R.layout.activity_main_screen);
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(getApplicationContext(), "Invalid username and/or password", Toast.LENGTH_SHORT).show();
    }
}
