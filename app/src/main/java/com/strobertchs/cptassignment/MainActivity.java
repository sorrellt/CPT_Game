package com.strobertchs.cptassignment;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MainActivity extends AppCompatActivity implements ActivityInterface {
    private static final String TAG = "MainActivity";
    public static String user;

    @LayoutRes
    private int backlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening__screen);
        Log.d(TAG, "onCreate: ");

        /*
        Button btnNavToContacts = (Button) findViewById(R.id.btnToContacts);
        btnNavToContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked btnNavToContacts");
                Intent intent = new Intent(MainActivity.this, contacts_screen.class);
                startActivity(intent);
            }
        });*/
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Utilities.app = this;
        Utilities.connectToServer();

    }

    public void onChooseSignIn(View view) {

        setContentView(R.layout.activity_sign_in_screen);
        setbacklayout(R.layout.activity_opening__screen);
    }

    public void onChooseRegister(View view) {

        setContentView(R.layout.activity_register_screen);
        setbacklayout(R.layout.activity_opening__screen);

    }

    public void onChooseRegtoSign(View view) {

        if (Utilities.isConnected()) {
            String username = ((EditText) findViewById(R.id.Register_Username)).getText().toString();
            String password = ((EditText) findViewById(R.id.Register_Password)).getText().toString();
            String confirmPass = ((EditText) findViewById(R.id.Register_ConPassword)).getText().toString();

            if (!password.equals(confirmPass)) {
                Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                Utilities.register(username, password);
            }
        }

    }

    public void onChooseSign2app(View view) {
        if (Utilities.isConnected()) {
            String username = ((EditText) findViewById(R.id.UsernameTXT)).getText().toString();
            String password = ((EditText) findViewById(R.id.PasswordTxt)).getText().toString();
            Utilities.login(username, password);
        }
    }

    public void onwednesday(View view) {
        if (Utilities.isConnected()) {
            Utilities.loadEvent(user, 0);
        }
    }
    public void onwednesdayload(ResultSet rs){
        try {
            setbacklayout(R.layout.activity_main_screen);
            setContentView(R.layout.activity_wednesday);

            if (rs.next()) {
                ((EditText) findViewById(R.id.editText9)).setText(rs.getString("event_name"));
                ((EditText) findViewById(R.id.editText8)).setText(rs.getString("event_time"));
                ((EditText) findViewById(R.id.editText10)).setText(Integer.toString(rs.getInt("event_rm_number")));
                ((EditText) findViewById(R.id.editText11)).setText(rs.getString("event_details"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onWednesdayConfirm(View view) {
        if (Utilities.isConnected()) {
            try {
                String eventName = ((EditText) findViewById(R.id.editText9)).getText().toString();
                String eventTime = ((EditText) findViewById(R.id.editText8)).getText().toString();
                int eventRmNumber = Integer.parseInt(((EditText) findViewById(R.id.editText10)).getText().toString());
                String eventDetails = ((EditText) findViewById(R.id.editText11)).getText().toString();
                Utilities.updateEvent(user, 0, eventName, eventTime, eventRmNumber, eventDetails);
            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(), "Invalid room number", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void onmonday(View view) {
        if (Utilities.isConnected()) {
            Utilities.loadEvent(user, 0);
        }
    }
    public void onmondayload(ResultSet rs){
        try {
            setbacklayout(R.layout.activity_main_screen);
            setContentView(R.layout.activity_monday);

            if (rs.next()) {
                ((EditText) findViewById(R.id.editText9)).setText(rs.getString("event_name"));
                ((EditText) findViewById(R.id.editText8)).setText(rs.getString("event_time"));
                ((EditText) findViewById(R.id.editText10)).setText(Integer.toString(rs.getInt("event_rm_number")));
                ((EditText) findViewById(R.id.editText11)).setText(rs.getString("event_details"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onMondayConfirm(View view) {
        if (Utilities.isConnected()) {
            try {
                String eventName = ((EditText) findViewById(R.id.editText9)).getText().toString();
                String eventTime = ((EditText) findViewById(R.id.editText8)).getText().toString();
                int eventRmNumber = Integer.parseInt(((EditText) findViewById(R.id.editText10)).getText().toString());
                String eventDetails = ((EditText) findViewById(R.id.editText11)).getText().toString();
                Utilities.updateEvent(user, 0, eventName, eventTime, eventRmNumber, eventDetails);
            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(), "Invalid room number", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void ontuesday(View view) {
        if (Utilities.isConnected()) {
            Utilities.loadEvent(user, 0);
        }
    }
    public void ontuesdayload(ResultSet rs){
        try {
            setbacklayout(R.layout.activity_main_screen);
            setContentView(R.layout.activity_tuesday);

            if (rs.next()) {
                ((EditText) findViewById(R.id.editText9)).setText(rs.getString("event_name"));
                ((EditText) findViewById(R.id.editText8)).setText(rs.getString("event_time"));
                ((EditText) findViewById(R.id.editText10)).setText(Integer.toString(rs.getInt("event_rm_number")));
                ((EditText) findViewById(R.id.editText11)).setText(rs.getString("event_details"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void onTuesdayConfirm(View view) {
        if (Utilities.isConnected()) {
            try {
                String eventName = ((EditText) findViewById(R.id.editText9)).getText().toString();
                String eventTime = ((EditText) findViewById(R.id.editText8)).getText().toString();
                int eventRmNumber = Integer.parseInt(((EditText) findViewById(R.id.editText10)).getText().toString());
                String eventDetails = ((EditText) findViewById(R.id.editText11)).getText().toString();
                Utilities.updateEvent(user, 0, eventName, eventTime, eventRmNumber, eventDetails);
            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(), "Invalid room number", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onthursday(View view) {
        if (Utilities.isConnected()) {
            Utilities.loadEvent(user, 0);
        }
    }
    public void onthursdayload(ResultSet rs) {
        try {
        setbacklayout(R.layout.activity_main_screen);
        setContentView(R.layout.activity_thursday);

        if (rs.next()) {
            ((EditText) findViewById(R.id.editText9)).setText(rs.getString("event_name"));
            ((EditText) findViewById(R.id.editText8)).setText(rs.getString("event_time"));
            ((EditText) findViewById(R.id.editText10)).setText(Integer.toString(rs.getInt("event_rm_number")));
            ((EditText) findViewById(R.id.editText11)).setText(rs.getString("event_details"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    public void onThursdayConfirm(View view) {
        if (Utilities.isConnected()) {
            try {
                String eventName = ((EditText) findViewById(R.id.editText9)).getText().toString();
                String eventTime = ((EditText) findViewById(R.id.editText8)).getText().toString();
                int eventRmNumber = Integer.parseInt(((EditText) findViewById(R.id.editText10)).getText().toString());
                String eventDetails = ((EditText) findViewById(R.id.editText11)).getText().toString();
                Utilities.updateEvent(user, 0, eventName, eventTime, eventRmNumber, eventDetails);
            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(), "Invalid room number", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void onfriday(View view) {
        if (Utilities.isConnected()) {
            Utilities.loadEvent(user, 0);
        }
    }
    public void onfridayload(ResultSet rs){
        try {
            setbacklayout(R.layout.activity_main_screen);
            setContentView(R.layout.activity_friday);

            if (rs.next()) {
                ((EditText) findViewById(R.id.editText9)).setText(rs.getString("event_name"));
                ((EditText) findViewById(R.id.editText8)).setText(rs.getString("event_time"));
                ((EditText) findViewById(R.id.editText10)).setText(Integer.toString(rs.getInt("event_rm_number")));
                ((EditText) findViewById(R.id.editText11)).setText(rs.getString("event_details"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onFridayConfirm(View view) {
        if (Utilities.isConnected()) {
            try {
                String eventName = ((EditText) findViewById(R.id.editText9)).getText().toString();
                String eventTime = ((EditText) findViewById(R.id.editText8)).getText().toString();
                int eventRmNumber = Integer.parseInt(((EditText) findViewById(R.id.editText10)).getText().toString());
                String eventDetails = ((EditText) findViewById(R.id.editText11)).getText().toString();
                Utilities.updateEvent(user, 0, eventName, eventTime, eventRmNumber, eventDetails);
            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(), "Invalid room number", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void onschoolsite(View view) {
        Intent link = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://stro.ycdsb.ca/"));
        startActivity(link);
    }

    public void ongoogleclassroom(View view) {
        Intent link = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://classroom.google.com/h"));
        startActivity(link);
    }

    public void onmap(View view) {
        setContentView(R.layout.activity_mainschoolmap);
        setbacklayout(R.layout.activity_main_screen);
    }

    public void onmeme(View view) {
        setContentView(R.layout.activity_memeoftheday);
        setbacklayout(R.layout.activity_main_screen);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            setContentView(backlayout);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        return super.onOptionsItemSelected(item);
    }

    public void setbacklayout(@LayoutRes int layout) {
        backlayout = layout;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onLogin() {

        setContentView(R.layout.activity_main_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(getApplicationContext(), "Invalid username and/or password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegister() {
        setContentView(R.layout.activity_sign_in_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void onRegisterFail() {
        Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
    }


    public void onspiritvideo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/watch?v=3I1mA679tHc"));
        startActivity(intent);

    }
    @Override
    public void eventConfirm() {
        setContentView(R.layout.activity_main_screen);
    }

}


