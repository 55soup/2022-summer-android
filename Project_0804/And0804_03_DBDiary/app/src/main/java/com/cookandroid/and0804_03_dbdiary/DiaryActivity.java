package com.cookandroid.and0804_03_dbdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class DiaryActivity extends AppCompatActivity {
    DatePicker datePicker1;
    EditText edtDiary;
    Button btnWrite, btnDel;
    String fileName;
    String strSDPath;
    File myDir;
//    ListView diaryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        setTitle("[일기장-내장메모리에 저장]");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        datePicker1 = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);
//        diaryList = findViewById(R.id.diaryList);
        btnDel = findViewById(R.id.btnDel);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR); //시스템 달력에서 년도 가져ㅏ오기
        int month = cal.get(Calendar.MONTH); //시스템 달력에서 월 가져오기
        int day = cal.get(Calendar.DAY_OF_MONTH); //시스템 달력에서 일 가져오기
        strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath(); //sd카드 경로 가져오기
        strSDPath += "/myDir/";
        myDir = new File(strSDPath);
        if(!myDir.isDirectory()) myDir.mkdir();
//        if(myDir.isDirectory() != true)

        fileName = strSDPath + year + "_" + (month+1) + "_" + day + ".txt"; //파일이름 만들기 년_월_일.txt
        // 오늘날짜의 일기가 있으면 읽어서 edtDiary에 setText() 하기
        String str = readDiary(fileName); //일기 읽기 완성
        edtDiary.setText(str);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outFs = new FileOutputStream(fileName); // new FileoutputStream
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "파일 저장됨", Toast.LENGTH_SHORT).show();
                }catch(Exception e){}
            }
        });
        datePicker1.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = strSDPath + y + "_" + (m+1) + "_" + d + ".txt"; //파일이름 만들기 년_월_일.txt
                String str = readDiary(fileName); //일기 있으면 읽어오기
                edtDiary.setText(str);
            }
        });
    }

    String readDiary(String fname){
        String diaryData = null; //일기 내용 저장하는 변수
        try{
            FileInputStream inFs = new FileInputStream(fname);
            byte[] in = new byte[500];
            inFs.read(in);
            diaryData = (new String(in)).trim();
            btnWrite.setText("수정하기");
            btnDel.setVisibility(View.VISIBLE);
            inFs.close();
        }catch(Exception e){
            btnWrite.setText("새로저장");
//            Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();
        }
        return diaryData;
    }
}