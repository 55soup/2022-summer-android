package com.cookandroid.and0802_act_twoway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnReturn = findViewById(R.id.btnReturn);
        Intent in = getIntent();
        int x = in.getIntExtra("Num1", 0);
        int y = in.getIntExtra("Num2", 0);
        final int sum = x+y;
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), MainActivity.class);
                out.putExtra("sum", sum);
                setResult(RESULT_OK,out);
            }
        });
    }
}