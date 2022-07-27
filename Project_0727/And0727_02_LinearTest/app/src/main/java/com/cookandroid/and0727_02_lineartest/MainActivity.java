package com.cookandroid.and0727_02_lineartest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtX, edtY;
    Spinner op;
    Button btn;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산앱");
        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        btn = findViewById(R.id.btn);
        op = findViewById(R.id.op);
        txtResult = findViewById(R.id.txtResult);
        op.setSelection(2); // 기본으로 더하기를 초기화.
        txtResult.setTextSize(20);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = op.getSelectedItemPosition();
                int X = Integer.parseInt(edtX.getText().toString());
                int Y = Integer.parseInt(edtY.getText().toString());
                switch (i){
                    case 0: txtResult.setText("" + (X + Y)); break;
                    case 1: txtResult.setText("" + (X - Y)); break;
                    case 2: txtResult.setText("" + (X * Y)); break;
                    case 3: txtResult.setText("" + (X % Y)); break;
                }
            }
        });
    }
}