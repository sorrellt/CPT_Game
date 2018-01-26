package com.strobertchs.cptassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Thomas on 1/26/2018.
 */

public class contacts_btn extends AppCompatActivity {
    private static final String TAG = "contacts_btn";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_screen);
        Log.d(TAG, "onCreate: Starting");
        Button btnGoBack = (Button) findViewById(R.id.btnGoBack);

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked btnGoBack");

                Intent intent = new Intent(contacts_screen.this, MainActivity.class);
                StartActivity(intent);
            }
        });
    }
}
