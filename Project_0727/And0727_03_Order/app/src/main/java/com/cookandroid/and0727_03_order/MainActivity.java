package com.cookandroid.and0727_03_order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgMenu;
    ImageView img;
    Button btn;
    String checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주 파스타 전문점");
        rgMenu = findViewById(R.id.rgMenu);
        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn);

        rgMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbOil: img.setImageResource(R.drawable.oil); break;
                    case R.id.rbTomato: img.setImageResource(R.drawable.tomato); break;
                    case R.id.rbCream: img.setImageResource(R.drawable.cream); break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedRadio = rgMenu.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(checkedRadio);
                Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}