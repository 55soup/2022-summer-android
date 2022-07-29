package com.cookandroid.and0729_01_innerrawmem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnInnerRead, btnInnerWrite, btnRawRead;
    EditText edtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주 파일입출력 (내장, RAW)");
        btnInnerRead = findViewById(R.id.btnInnerRead);
        btnInnerWrite = findViewById(R.id.btnInnerWrite);
        btnRawRead = findViewById(R.id.btnRawRead);
        edtData = findViewById(R.id.edtData);

        btnInnerWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outFs = openFileOutput("fileTest.txt", Context.MODE_PRIVATE); //파일 쓰기용으로 open
                    String str = "안녕 오늘 안드로이드 수업 재밌다 ^^";
//                    String str2 = edtData.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "fileTest파일 생성됨", Toast.LENGTH_SHORT).show();
                }catch(Exception e){}
            }
        });
        btnInnerRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream inFs = openFileInput("fileTest.txt");
                    byte[] in = new byte[100];
                    inFs.read(in);
                    edtData.setText(new String(in)); //str.toString()
                    inFs.close();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRawRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream ins = getResources().openRawResource(R.raw.test);
                    byte[] in = new byte[ins.available()];
                    ins.read(in);
                    edtData.setText(new String(in)); //str.toString()
                    ins.close();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}