package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView textContent;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("두번 째 화면");
        textContent = findViewById(R.id.textContent);
        btn = findViewById(R.id.btn);

        Intent in = getIntent();
        String name = in.getStringExtra("name");
        String age = in.getStringExtra("age");
        ArrayList<String> hobby = in.getStringArrayListExtra("hobby");
        String str = "이름: " + name + "\n나이: " + age + "\n취미: ";
        for(String h:hobby)textContent.setText(str += h+" ");
        textContent.setText(str);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in2);
            }
        });
    }
}