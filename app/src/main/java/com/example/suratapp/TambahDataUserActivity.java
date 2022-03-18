package com.example.suratapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahDataUserActivity extends AppCompatActivity {

    EditText usernameAdd;
    EditText passwordAdd;
    EditText fullnameAdd;
    EditText positionAdd;

    Button buttonAdd;
    Button buttonCancel;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_user);

        usernameAdd = findViewById(R.id.addUsername);
        passwordAdd = findViewById(R.id.addPassword);
        fullnameAdd = findViewById(R.id.addFullName);
        positionAdd = findViewById(R.id.addPosition);
        buttonAdd   = findViewById(R.id.butSimpanUser);
        buttonCancel= findViewById(R.id.butBatalUser);


        buttonCancel.setOnClickListener(v -> {
            Intent intent = new Intent(TambahDataUserActivity.this, BAAKmainActivity.class);
            startActivity(intent);
        });

        buttonAdd.setOnClickListener(v -> {
            String username = usernameAdd.getText().toString();
            String password = passwordAdd.getText().toString();
            String fullname = fullnameAdd.getText().toString();
            String position = positionAdd.getText().toString();

            myRef.child("user").child(username).child("username").setValue(username);
            myRef.child("user").child(username).child("password").setValue(password);
            myRef.child("user").child(username).child("nama").setValue(fullname);
            myRef.child("user").child(username).child("jabatan").setValue(position);

            Toast.makeText(TambahDataUserActivity.this, "user ditambahkan", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(TambahDataUserActivity.this, BAAKmainActivity.class);
            startActivity(intent);

        });

    }
}