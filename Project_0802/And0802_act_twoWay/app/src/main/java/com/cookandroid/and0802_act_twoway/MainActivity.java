package com.cookandroid.and0802_act_twoway;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                in.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(in, 0); //requestCode는 세컨액티비티 번호
                //세컨액티비티에 return 값이 있을 때 사용(세컨에서 putExtra()해서 되돌려 받는 경우)
                
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int sum = data.getIntExtra("sum", 0);
            Toast.makeText(getApplicationContext(), "합계: " + sum, Toast.LENGTH_SHORT).show();
        }
    }
}