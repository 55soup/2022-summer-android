package com.cookandroid.and0726_04_internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    ImageView img;
    Button btn_page, btn_letter;
    EditText ed_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좀 그럴듯한 앱 박선주");
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rg = findViewById(R.id.rg);
        img = findViewById(R.id.img);
        btn_page = findViewById(R.id.btn_page);
        btn_letter = findViewById(R.id.btn_letter);
        ed_link = findViewById(R.id.ed_link);

        btn_letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = ed_link.getText().toString();
                Toast.makeText(getApplicationContext(), link, Toast.LENGTH_SHORT).show();
            }
        });
        btn_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = ed_link.getText().toString();
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(urlOpen);
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_pie: img.setImageResource(R.drawable.pie); break;
                    case R.id.rb_orea: img.setImageResource(R.drawable.oreo); break;
                }
            }
        });
    }
}