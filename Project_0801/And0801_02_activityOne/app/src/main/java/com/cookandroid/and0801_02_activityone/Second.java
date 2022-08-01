package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    Button btnMain;
    TextView txtContent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("second");
        btnMain = findViewById(R.id.btnMain);
        txtContent2 = findViewById(R.id.txtContent2);
        ////////////////////////////////////////////////////////
        Intent in = getIntent(); // Main에서 가져온변수
        String str = in.getStringExtra("Content2");
        ////////////////////////////////////////////////////////
        txtContent2.setText("넘겨받은 내용: " + str);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });

    }
}