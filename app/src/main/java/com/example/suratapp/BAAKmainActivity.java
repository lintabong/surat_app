package com.example.suratapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BAAKmainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baakmain);
    }

    public void mailIn(View view) {
    }

    public void mailOut(View view){

    }

    public void cancelation(View view){

    }

    public void disposition(View view){

    }

    public void report(View view){

    }

    public void addUser(View view) {
        Intent intent = new Intent(BAAKmainActivity.this, TambahDataUserActivity.class);
        startActivity(intent);
    }
}