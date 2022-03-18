package com.example.suratapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    EditText usernameLogin;
    EditText passwordLogin;
    Button buttonLogin;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameLogin = findViewById(R.id.UsernameLoginInput);
        passwordLogin = findViewById(R.id.PasswordLoginInput);
        buttonLogin   = findViewById(R.id.LoginButton);

        buttonLogin.setOnClickListener(v -> {
            String getUsername = usernameLogin.getText().toString();
            String getPassword = passwordLogin.getText().toString();

            myRef.child("user").child(getUsername).child("password").get().addOnCompleteListener(task -> {
                String myText = String.valueOf(task.getResult().getValue());

                if (getPassword.equals(myText)){
                    myRef.child("user").child(getUsername).child("jabatan").get().addOnCompleteListener(task1 -> {
                        String position = String.valueOf(task1.getResult().getValue());

                        if (position.equals("admin")){
                            Intent intent = new Intent(LoginActivity.this, BAAKmainActivity.class);
                            startActivity(intent);
                        } else if (position.equals("mahasiswa")){
                            Intent intent = new Intent(LoginActivity.this, MahasiswaMainActivity.class);
                            startActivity(intent);
                        } else if (position.equals("wk")){
                            Intent intent = new Intent(LoginActivity.this, WKmainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Maaf, username atau password anda salah", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Maaf, username atau password anda salah", Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}