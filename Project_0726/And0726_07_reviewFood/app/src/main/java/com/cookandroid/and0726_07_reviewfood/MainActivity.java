package com.cookandroid.and0726_07_reviewfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox chkStart;
    LinearLayout layReview;
    RadioGroup rg;
    Button btnInit;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkStart = findViewById(R.id.chkStart);
        layReview = findViewById(R.id.layReview);
        rg = findViewById(R.id.rg);
        btnInit = findViewById(R.id.btnInit);
        img = findViewById(R.id.img);

        chkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) layReview.setVisibility(View.VISIBLE);
                else layReview.setVisibility(View.INVISIBLE);
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rbKor:
                        img.setImageResource(R.drawable.korean);
                        break;
                    case R.id.rbChi:
                        img.setImageResource(R.drawable.chinese);
                        break;
                    case R.id.rbBun:
                        img.setImageResource(R.drawable.bunsic);
                        break;
                    case R.id.rbNig:
                        img.setImageResource(R.drawable.night);
                        break;
                }
            }
        });
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
            }
        });
    }
}