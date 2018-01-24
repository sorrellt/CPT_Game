package com.strobertchs.cptassignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class googleclassroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googleclassroom);
        Intent link = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://classroom.google.com/h"));
        startActivity(link);
    }
}
