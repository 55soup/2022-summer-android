package com.cookandroid.and0725_04_eventpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_1, edt_2;
    Button btn_even, btn_point;
    TextView txt_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주 - 간단 계산기");
        edt_1 = findViewById(R.id.edt_1);
        edt_2 = findViewById(R.id.edt_2);
        btn_even = findViewById(R.id.btn_even);
        btn_point = findViewById(R.id.btn_point);
        txt_result = findViewById(R.id.txt_result);
        
        btn_even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(edt_1.getText().toString());
                int num2 = Integer.parseInt(edt_2.getText().toString());
                int result = 0;
                for (int i = num1; i <= num2; i++) {
                    if (i % 2 == 0) result += i;
                }
                txt_result.setText(num1 + "~" + num2+"까지 짝수의 합 결과: " + result);
            }
        });
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int unit = Integer.parseInt(edt_1.getText().toString());
                int total = Integer.parseInt(edt_2.getText().toString());
                if(total < unit) txt_result.setText("가용할 포인터가 부족합니다. ");
                else {int use_point = total - (total % unit);
                txt_result.setText("가용포인터 값: " + use_point);
                }
            }
        });
    }
}