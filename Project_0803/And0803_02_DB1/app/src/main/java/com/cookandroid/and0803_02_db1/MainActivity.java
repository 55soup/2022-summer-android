package com.cookandroid.and0803_02_db1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    TextView txtNameResult, txtNumberResult;
    Button btnClear, btnInsert, btnSelect, btnModify, btnDelete;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[박선주]가수그룹 관리");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        txtNameResult = findViewById(R.id.txtNameResult);
        txtNumberResult = findViewById(R.id.txtNumberResult);
        btnClear = findViewById(R.id.btnClear);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnModify = findViewById(R.id.btnModify);
        btnDelete = findViewById(R.id.btnDelete);
        edtName = findViewById(R.id.edtName);
        myHelper = new MyDBHelper(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//DB의 테이블 삭제 후 다시 생성
                sqlDB = myHelper.getWritableDatabase(); //수정모드 오픈
                myHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "초기화 완료", Toast.LENGTH_SHORT).show();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String name = edtName.getText().toString().trim();
                    int num = Integer.parseInt(edtNumber.getText().toString());
                    if(name.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "이름 입력필수", Toast.LENGTH_SHORT).show();
                    }else{
//                        String s = "이름" + name + "나이" + num;
                        sqlDB = myHelper.getWritableDatabase();
                        String str = "insert into groupTBL(gName, gNumber) values('"+name+"', "+num+");";
                        sqlDB.execSQL(str);
                        sqlDB.close();
                        edtName.setText("");
                        edtNumber.setText("");
                        btnSelect.callOnClick(); //btnSelect() 함수 호출
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("select * from groupTBL;", null);
                String strNames = "그룹이름\r\n" + "--------------\r\n";
                String strNums = "인원수\r\n" + "--------------\r\n";
                while(cursor.moveToNext()){
                    strNames += cursor.getString(0)+"\n";
                    strNums += cursor.getInt(1)+"\n";
                }
                txtNameResult.setText(strNames);
                txtNumberResult.setText(strNums);
                cursor.close();
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회성공", Toast.LENGTH_SHORT).show();
            }
        });

        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.modify, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 정보 변경");
                dlg.setView(v);
                EditText edtGModify = v.findViewById(R.id.edtGModify);
                EditText edtGCount = v.findViewById(R.id.edtGCount);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtGModify.getText().toString().trim();
                            String number = edtGCount.getText().toString().trim();
                            if(!name.isEmpty() && !number.isEmpty()){
                                String sql = "UPDATE groupTBL SET gNumber= " + number +"WHERE gName = '" + name +"'";
                                sqlDB.execSQL(sql);
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(), "수정됨", Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            }
                            else Toast.makeText(getApplicationContext(), "이름과 인원을 입력해야 합니다.", Toast.LENGTH_SHORT).show();
                        }catch(Exception e){
                            Toast.makeText(getApplicationContext(), "수정실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.delete, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                AlertDialog.Builder dlgAgain = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 삭제");
                dlg.setView(v);
                dlgAgain.setMessage("정말 삭제하시겠습니까?");
                final EditText edtDelGName = v.findViewById(R.id.edtDelGName);

                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgAgain.setNegativeButton("취소", null);
                        dlgAgain.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try{
                                    sqlDB = myHelper.getWritableDatabase();
                                    String name = edtDelGName.getText().toString().trim();
                                    if(!name.isEmpty()){
                                        sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '"+ name +"'; ");
                                        sqlDB.close();
                                        Toast.makeText(getApplicationContext(), name + " 삭제됨" ,Toast.LENGTH_SHORT).show();

                                        btnSelect.callOnClick();
                                    }
                                    else Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                                }catch(Exception e){
                                    Toast.makeText(getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        dlgAgain.show();
                    }
                });

                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });
    }
}