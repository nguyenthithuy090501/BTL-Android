package com.example.appenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrangMainChuDe extends AppCompatActivity {
    Button btnTopic1, btnTopic2, btnTopic3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_main_chu_de);
        btnTopic1 = (Button) findViewById(R.id.btnTopic1);
        btnTopic2 = (Button) findViewById(R.id.btnTopic2);
        btnTopic3 = (Button) findViewById(R.id.btnTopic3);

        //click vào btnTopic chuyển sang trang bài đọc
        btnTopic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangMainChuDe.this, TrangSecondaryChuDe.class);
                startActivity(intent);
            }
        });
    }
}