package com.cookandroid.and0729_05_quiz_sdmem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    Button btnIn, btnStart, btnNext;
    EditText edAns, dlgEdName, dlgEdId;
    TextView tvNum, tvOX, tvQuiz;
    View dlgViewScore, dlgViewInput;
    String[] quiz = {"캐나다의 수도는?", "호주의 수도는?", "케냐의 수도는?", "스페인의 수도는?", "독일의 수도는?"};
    String[] ans = {"오타와", "캔버라", "나이로비", "스톡홀름", "베를린"};
    int index = 0, ans_num = 0; //문제번호, 맞은 개수
    File myDir; //생성한 디렉터리 변수
    String strSDPath; //SD카드 절대주소

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        setTitle("박선주 수도이름 맞추기 퀴즈");
        btnIn = findViewById(R.id.btnIn);
        btnStart = findViewById(R.id.btnStart);
        btnNext = findViewById(R.id.btnNext);
        edAns = findViewById(R.id.edAns);
        tvNum = findViewById(R.id.tvNum);
        tvOX = findViewById(R.id.tvOX);
        tvQuiz = findViewById(R.id.tvQuiz);

        strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath(); //sd카드 경로 가져오기
        strSDPath += "/myQuiz/";
        myDir = new File(strSDPath);
        if (!myDir.isDirectory()) myDir.mkdir();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = ans_num = 0; //문제 1번부터 보이도록 설정
                tvNum.setText("문제 - " + (index + 1));
                tvQuiz.setText(quiz[index]);
                btnIn.setEnabled(true);
                btnStart.setEnabled(false);
                btnNext.setEnabled(false);
            }
        });

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String an = edAns.getText().toString();
                if (an.equals(ans[index])) {
                    ans_num++; //맞은 갯수 1씩 증가.
                    tvOX.setText("O : 맞았습니다.");
                } else {
                    tvOX.setText("X : 틀렸습니다.");
                }
                btnNext.setEnabled(true);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edAns.setText("");
                btnNext.setEnabled(false);
                index++;
                if(index<ans.length){// 문제가 남음
                    tvOX.setText("OX");
                    tvNum.setText("문제-" + (index+1));
                    tvQuiz.setText(quiz[index]);
                }else{ //문제 다 풀면 초기화면
                    // 풀이 결과 저장할건지 다이얼로그로 물어보기
                    tvOX.setText("OX");
                    tvNum.setText("문제 - Number");
                    tvQuiz.setText("문제");
                    btnIn.setEnabled(false);
                    btnStart.setEnabled(true);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("퀴즈 맞은 개수");
                    dlg.setMessage("총 맞은 갯수: " + ans_num + "\n점수를 저장하겠습니까?");
                    dlg.setNegativeButton("취소", null);
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //저장하기 위해서 이름과 아이디 입력받아 파일로 저장
                            AlertDialog.Builder dlg2 = new AlertDialog.Builder(MainActivity.this);
                            dlg2.setTitle("파일이름 입력: 이름&ID입력"); //문제 초기화 1번부터
                            dlgViewInput = (View)View.inflate(MainActivity.this, R.layout.dlg, null);
                            dlg2.setView(dlgViewInput);
                            dlg2.setNegativeButton("취소", null);
                            dlg2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dlgEdId = dlgViewInput.findViewById(R.id.edID);
                                    dlgEdName = dlgViewInput.findViewById(R.id.edName);
                                    String id = dlgEdId.getText().toString();
                                    String name = dlgEdName.getText().toString();
                                    String fileName = strSDPath+name+"_" + id + ".txt";
                                    try{
                                        FileOutputStream inFs = new FileOutputStream(fileName); // new FileoutputStream
                                        String str = name + "님 점수>> 5문제에서 맞은 개수 : " +ans_num;
                                        inFs.write(str.getBytes());
                                        inFs.close();
                                        String out = name+"님 점수 확인 \n" + str;
                                        Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
                                    }catch(Exception e){
                                        Toast.makeText(getApplicationContext(), "파일이 존재하지 않음", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            dlg2.show();
                        }
                    });
                    dlg.show();
                }
            }
        });
    }
    //옵션메뉴 생성 및 아이템 선택 처리함수 구현
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        AlertDialog.Builder dlg;
        switch(item.getItemId()){
            case R.id.item_exit:
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("종료");
                dlg.setMessage("프로그램 종료합니다.");
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dlg.show();
                return true;
            case R.id.item_start:
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("다시 풀기");
                dlg.setMessage("처음부터 다시 풀어봅니다.");
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        index = ans_num = 0;
                        tvNum.setText("문제 - " + (index+1));
                        tvQuiz.setText(quiz[index]);
                        btnIn.setEnabled(false);
                        btnNext.setEnabled(false);
                    }
                });
                dlg.show();
                return true;
            case R.id.item_score: //내 점수 확인>>이름, 아이디 입력 필요
                //파일이름->이름_아이디.txt
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("파일이름 입력: 이름&ID입력"); //문제 초기화 1번부터
                dlgViewScore = (View)View.inflate(MainActivity.this, R.layout.dlg, null);
                dlg.setView(dlgViewScore);
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgEdId = dlgViewScore.findViewById(R.id.edID);
                        dlgEdName = dlgViewScore.findViewById(R.id.edName);
                        String id = dlgEdId.getText().toString();
                        String name = dlgEdName.getText().toString();
                        String fileName = strSDPath+name+"_" + id + ".txt";
                        try{
                            FileInputStream inFs = new FileInputStream(fileName); // new FileoutputStream
                            byte[] in = new byte[inFs.available()];
                            inFs.read(in);
                            String str = new String(in);
                            inFs.close();
                            String out = name+"님 점수 확인 \n" + str;
                            Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
                        }catch(Exception e){
                            Toast.makeText(getApplicationContext(), "파일이 존재하지 않음", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.show();
                return true;
        }
        return false;
    }
}