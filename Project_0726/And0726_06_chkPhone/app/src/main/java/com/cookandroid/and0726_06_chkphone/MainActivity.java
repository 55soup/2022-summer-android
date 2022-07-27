package com.cookandroid.and0726_06_chkphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.cookandroid.and0726_06_chkphone.R;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chkList = new CheckBox[4];
    Integer[] chkText = {R.id.chkBerry, R.id.chkGrape, R.id.chkiwi, R.id.chkGrapefruit};
    TextView txtResult;
    String str = "";
    int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
        for(int i=0; i<chkList.length; i++)  chkList[i] = findViewById(chkText[i]);


        for(int i=0; i<chkList.length; i++){
            final int k=i;
            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    if(b) str += chkList[k].getText().toString();
//                    else str = "";
//                    txtResult.setText("선택결과: " + str);
//                    btn.performClick();
                }
            });
        }

    }
}