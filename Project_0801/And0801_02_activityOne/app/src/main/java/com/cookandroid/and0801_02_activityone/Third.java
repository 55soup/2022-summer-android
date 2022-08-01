package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Third extends AppCompatActivity {
    Button btnMain;
    TextView txtContent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setTitle("Third");
        btnMain = findViewById(R.id.btnMain3);
        txtContent3 = findViewById(R.id.txtContent3);
        ////////////////////////////////////////////////////////////////////////////
        Intent in = getIntent();
        String str = in.getStringExtra("Content3"); //넘기는 변수와 넘겨받는 변수의 이름이 같아야함.
        ////////////////////////////////////////////////////////////////////////////
        txtContent3.setText("넘겨 받은 내용: " + str);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }
}