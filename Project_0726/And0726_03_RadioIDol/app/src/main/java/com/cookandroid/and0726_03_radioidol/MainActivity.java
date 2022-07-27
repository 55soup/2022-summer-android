package com.cookandroid.and0726_03_radioidol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg_idol;
    Button btn_vote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_idol = findViewById(R.id.rg_idol);
        btn_vote = findViewById(R.id.btn_vote);
        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(rg_idol.getCheckedRadioButtonId()){
                    case R.id.Cosmic:
                        Toast.makeText(getApplicationContext(), "우주소녀를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.BTS:
                        Toast.makeText(getApplicationContext(), "방탄소년단을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Seventeen:
                        Toast.makeText(getApplicationContext(), "세븐틴을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}