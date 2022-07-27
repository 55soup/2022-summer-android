package com.cookandroid.and0726_02_radioflower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_rose:
                        Toast.makeText(getApplicationContext(), "장미", Toast.LENGTH_SHORT).show(); break;
                    case R.id.rb_pansy:
                        Toast.makeText(getApplicationContext(), "팬지", Toast.LENGTH_SHORT).show(); break;
                    case R.id.rb_lily:
                        Toast.makeText(getApplicationContext(), "백합", Toast.LENGTH_SHORT).show(); break;
                }
            }
        });
    }
}