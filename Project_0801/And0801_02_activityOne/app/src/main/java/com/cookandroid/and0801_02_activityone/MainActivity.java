package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btnOpen;
    EditText edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        btnOpen = findViewById(R.id.btnOpen);
        edtContent = findViewById(R.id.edtContent);

        btnOpen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String str = edtContent.getText().toString();
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.rb2:
                        Intent in = new Intent(getApplicationContext(), Second.class);
                        in.putExtra("Content2", str);
                        startActivity(in);
                        break;
                    case R.id.rb3:
                        Intent in2 = new Intent(getApplicationContext(), Third.class);
                        in2.putExtra("Content3", str);
                        startActivity(in2);
                        break;
                }
            }
        });
    }
}