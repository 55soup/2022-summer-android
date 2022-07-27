package com.cookandroid.and0726_01_check;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chkList = new CheckBox[3];
    Integer [] chkText = {R.id.chkAndroid, R.id.chkIphone, R.id.chkWindow}; //한 요소가 연속으로 있을 때 객체로 선언하면 편함.
    Button btn_android;
    RadioGroup rg;
    RadioButton rbRed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("체크박스실습 박선주");
        btn_android = findViewById(R.id.btn_android);
        rg = findViewById(R.id.rg);
        rbRed  = findViewById(R.id.rbRed);
        rbRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Red버튼 클릭", Toast.LENGTH_SHORT).show();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbRed :
                        Toast.makeText(getApplicationContext(), "Red", Toast.LENGTH_SHORT).show(); break;
                    case R.id.rbGreen :
                        Toast.makeText(getApplicationContext(), "Green", Toast.LENGTH_SHORT).show(); break;
                    case R.id.rbBlue :
                        Toast.makeText(getApplicationContext(), "Blue", Toast.LENGTH_SHORT).show(); break;
                }
            }
        });
        for(int i=0; i<chkList.length; i++) chkList[i] = findViewById(chkText[i]);
        //이벤트처리
        for(int i=0; i<chkList.length; i++){
            final int k = i;
            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) { // boolean값이 true일 때 체크박스가 체크됨.
                    if(b) Toast.makeText(getApplication(), chkList[k].getText().toString()+"선택", Toast.LENGTH_SHORT).show();
                    else Toast.makeText(getApplication(), chkList[k].getText().toString()+"취소", Toast.LENGTH_SHORT).show();
                }
            });
        }
//        btn_android.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                chkList[0].setChecked(true);
//            }
//        });
    }
    public void onRadioBtnClick(View v){
        boolean chk = ((RadioButton)v).isChecked();
        if(chk){
            Toast.makeText(getApplicationContext(), ((RadioButton)v).getText().toString()+"선택", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(getApplicationContext(), ((RadioButton)v).getText().toString()+"선택", Toast.LENGTH_SHORT).show();
    }
}