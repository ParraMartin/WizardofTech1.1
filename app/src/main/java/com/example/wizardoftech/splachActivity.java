package com.example.wizardoftech;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent cargar = new Intent(splachActivity.this, MainActivity.class);
                startActivity(cargar);
                finish();
            }
        },3000);
    }

}