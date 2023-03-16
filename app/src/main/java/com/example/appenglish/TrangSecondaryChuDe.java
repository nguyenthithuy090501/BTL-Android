package com.example.appenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrangSecondaryChuDe extends AppCompatActivity {
    Button btnBack, btnOnTap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_secondary_chu_de);
        //ánh xạ
        btnBack = (Button) findViewById(R.id.btnBack);
        btnOnTap = (Button) findViewById(R.id.btnOnTap);
        //xét sự kiện click
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangSecondaryChuDe.this, TrangMainChuDe.class);
                startActivity(intent);
            }
        });
        btnOnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(TrangSecondaryChuDe.this, TrangOnTap.class);
                startActivity(in);
            }
        });
    }
}