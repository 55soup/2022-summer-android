package com.cookandroid.and0725_02_sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edt_input;
    Button btn_getsum;
    TextView txt_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주(합구하기)");
        edt_input = findViewById(R.id.edt_input);
        btn_getsum = findViewById(R.id.btn_getsum);
        txt_result = findViewById(R.id.txt_result);

        btn_getsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(edt_input.getText().toString());
                int result = 0;
                for(int i=1; i<=num; i++) result += i;
                txt_result.setText("1~ " + num + " 까지 합 = " + result);
                edt_input.setText(""); //clear
            }

        });
    }
}