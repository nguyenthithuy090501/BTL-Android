package com.example.appenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Image extends AppCompatActivity {
    Button btnTiepTheo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        btnTiepTheo = (Button) findViewById(R.id.btnTiepTheo);

        btnTiepTheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Image.this, KetQua.class);
                startActivity(intent);
            }
        });
    }
}