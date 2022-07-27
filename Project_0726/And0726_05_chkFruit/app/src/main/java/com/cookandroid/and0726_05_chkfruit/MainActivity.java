package com.cookandroid.and0726_05_chkfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chkList = new CheckBox[4];
    Integer[] chkText = {R.id.chkBerry, R.id.chkGrape, R.id.chkiwi, R.id.chkGrapefruit};
    Button btnChk;
    TextView txtResult;
    String str = "";
    int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChk = findViewById(R.id.btnChk);
        txtResult = findViewById(R.id.txtResult);
        for(int i=0; i<chkList.length; i++)  chkList[i] = findViewById(chkText[i]);

        if(str.equals("")) txtResult.setText("선택하지 않았습니다.");
        else txtResult.setText("선택결과: " + txtResult);

        btnChk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = " "; // 문자열 초기화
                for(int i=0; i<chkList.length; i++){
                    if(chkList[i].isChecked()) str+=chkList[i].getText().toString();
                }
                txtResult.setText("선택결과: " + str);
            }
        });

    }
}