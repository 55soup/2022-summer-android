package com.cookandroid.and0802_02_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnTel, btnHome, btnMap, btnSearch, btnMess, btnPhoto, btnContect, btnMail, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTel = findViewById(R.id.btnTel);
        btnHome = findViewById(R.id.btnHome);
        btnMap = findViewById(R.id.btnMap);
        btnSearch = findViewById(R.id.btnSearch);
        btnMess = findViewById(R.id.btnMess);
        btnPhoto = findViewById(R.id.btnPhoto);
        btnContect = findViewById(R.id.btnContect);
        btnMail = findViewById(R.id.btnMail);
        btnExit = findViewById(R.id.btnExit);

        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:010-1234-5678");
                Intent in = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(in);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://m.naver.com");
                Intent in = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(in);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//서울 우러드컵경기장 위도 경도
                Uri uri = Uri.parse("https://maps.google.com/maps?q=" + 37.568256 + "," + 126.897240);
                Intent in = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(in);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}