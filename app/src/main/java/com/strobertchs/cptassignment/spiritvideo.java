package com.strobertchs.cptassignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class spiritvideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiritvideo);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://3I1mA679tHc"));
        startActivity(intent);

    }

}

