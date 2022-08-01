package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.nio.file.WatchKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    CheckBox chkGame, chkMusic, chkGym;
    Button btnInput;
    Integer[] chkString = {R.id.chkGame, R.id.chkMusic, R.id.chkGym};
    CheckBox[] chk = new CheckBox[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        chkGame = findViewById(R.id.chkGame);
        chkMusic = findViewById(R.id.chkMusic);
        chkGym = findViewById(R.id.chkGym);
        btnInput = findViewById(R.id.btnInput);
        ArrayList<String> hobby = new ArrayList<>();

        for(int i=0; i<chkString.length; i++){
            final int index = i;
            chk[i] = findViewById(chkString[i]);
            chk[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b)hobby.add(chk[index].getText().toString()); //배열추가
                    else hobby.remove(chk[index].getText().toString());
                }
            });


        }

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  취미 가져오기


                Intent in = new Intent(getApplicationContext(), MainActivity2.class);
                in.putExtra("name", edtName.getText().toString()); //이름
                in.putExtra("age", edtAge.getText().toString()); //나이
                in.putExtra("hobby", hobby);
                startActivity(in);
            }
        });
    }
}