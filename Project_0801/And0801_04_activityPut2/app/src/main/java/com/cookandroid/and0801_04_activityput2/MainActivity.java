package com.cookandroid.and0801_04_activityput2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtTel, edtAdd;
    Button btnInput;
    RadioGroup rg;
    String name, gender, tel, add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtTel = findViewById(R.id.edtTel);
        edtAdd = findViewById(R.id.edtAdd);
        btnInput = findViewById(R.id.btnInput);
        rg = findViewById(R.id.rg);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                tel = edtTel.getText().toString();
                add = edtAdd.getText().toString();
                if(rg.getCheckedRadioButtonId()==R.id.rdMan) gender = "남자";
                else gender = "여자";
                Person p = new Person(name, gender, tel, add);
                Intent in = new Intent(getApplicationContext(), MainActivity2.class);
                in.putExtra("person", p);
                startActivity(in);
            }
        });
    }

}