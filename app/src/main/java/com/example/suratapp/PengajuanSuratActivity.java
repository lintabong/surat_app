package com.example.suratapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PengajuanSuratActivity extends AppCompatActivity {

    EditText subName;
    EditText subNim;
    EditText subDepartment;
    EditText subLecture;
    EditText subReason;

    Button butSubmit;
    Button butCancel;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengajuan_surat);

        subName         = findViewById(R.id.submissionName);
        subNim          = findViewById(R.id.submissionNim);
        subDepartment   = findViewById(R.id.submissionDepartmen);
        subLecture      = findViewById(R.id.submissionlecture);
        subReason       = findViewById(R.id.submissionReason);

        butSubmit       = findViewById(R.id.submissionButton);
        butCancel       = findViewById(R.id.submissionCancel);

        butSubmit.setOnClickListener(v -> {
            String name         = subName.getText().toString();
            String nim          = subNim.getText().toString();
            String department   = subDepartment.getText().toString();
            String lecture      = subLecture.getText().toString();
            String reason       = subReason.getText().toString();

            myRef.child("buffPengajuan").child(nim).child("name").setValue(name);
            myRef.child("buffPengajuan").child(nim).child("nim").setValue(nim);
            myRef.child("buffPengajuan").child(nim).child("jurusan").setValue(department);
            myRef.child("buffPengajuan").child(nim).child("dosen").setValue(lecture);
            myRef.child("buffPengajuan").child(nim).child("alasan").setValue(reason);

            Intent intent = new Intent(PengajuanSuratActivity.this, MahasiswaMainActivity.class);
            startActivity(intent);
        });

        butCancel.setOnClickListener(v -> {
            Intent intent = new Intent(PengajuanSuratActivity.this, MahasiswaMainActivity.class);
            startActivity(intent);
        });

    }
}