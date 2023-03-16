package com.example.appenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrangOnTap extends AppCompatActivity {
    Button btnTuVung;
    Button btnBack, btnOnTap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_on_tap);
        //ánh xạ
        btnTuVung = (Button) findViewById(R.id.btnTuVung);
        //xét sự kiện click
        btnTuVung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangOnTap.this, Image.class);
                startActivity(intent);
            }
        });
    }
}