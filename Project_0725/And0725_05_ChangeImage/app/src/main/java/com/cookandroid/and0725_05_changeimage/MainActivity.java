package com.cookandroid.and0725_05_changeimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn_change, btn_hide;
    ImageView image;
    int imgType = 2; // 1==키캣, 2==마시멜로
    boolean change_toggle = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_change = findViewById(R.id.btn_change);
        btn_hide = findViewById(R.id.btn_hide);
        image = findViewById(R.id.image);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgType==1){
                    image.setImageResource(R.drawable.kitkat);
                    imgType=2;
                }else{
                    image.setImageResource(R.drawable.marshmallow);
                    imgType=1;
                }
            }
        });
        btn_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(image.getVisibility() == View.VISIBLE){
                    image.setVisibility(View.INVISIBLE);
                    btn_hide.setText("보이기");
                }else{
                    image.setVisibility(View.VISIBLE);
                    btn_hide.setText("숨기기");
                }
            }
        });
    }
}