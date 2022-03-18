package com.example.suratapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MahasiswaMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_main);
    }

    public void filing(View view){

    }

    public void mailStatus(View view){

    }

    public void cancelation(View view){

    }

    public void logout(View view){
        Intent intent = new Intent(MahasiswaMainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}