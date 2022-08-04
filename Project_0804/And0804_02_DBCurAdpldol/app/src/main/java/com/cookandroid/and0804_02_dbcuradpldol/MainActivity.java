package com.cookandroid.and0804_02_dbcuradpldol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.and0804_02_dbcuradpldol.MyDBHelper;
import com.cookandroid.and0804_02_dbcuradpldol.R;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtCount;
    Button btnClear, btnAdd, btnSelect;
    ListView listview;

    MyDBHelper myHelper;
    SQLiteDatabase sqlDB; //데이터베이스 연결을 위해 필요
    IdolAdapter cAdapter; //리스트뷰를 연결하기 위해 필요.
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("박선주[아이돌 그룹 관리 나는야 프로듀서 ^^]");
        edtName = findViewById(R.id.edtName);
        edtCount = findViewById(R.id.edtCount);
        btnClear = findViewById(R.id.btnClear);
        btnAdd = findViewById(R.id.btnAdd);
        btnSelect = findViewById(R.id.btnSelect);
        listview = findViewById(R.id.listview);
        myHelper = new MyDBHelper(this);

        btnClear.setOnClickListener(new View.OnClickListener() { //초기화
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setMessage("정말 초기화 시키시겠습니까?");
                dlg.setPositiveButton("초기화", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sqlDB = myHelper.getWritableDatabase();
                        myHelper.onUpgrade(sqlDB, 1, 2);
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "초기화 완료", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() { //리스트 추가
            @Override
            public void onClick(View view) {
                try{
                    sqlDB = myHelper.getWritableDatabase();
                    String name = edtName.getText().toString().trim();
                    String count = edtCount.getText().toString().trim();
                    if(!name.isEmpty() && !count.isEmpty()){
                        String sql = "INSERT INTO contactTBL(name, count) VALUES('"+name+"', '"+count+"')";
                        sqlDB.execSQL(sql);
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                        edtName.setText(""); edtCount.setText("");
                        btnSelect.callOnClick();
                    }else Toast.makeText(getApplicationContext(), "그룹명, 인원을 입력하세요. ", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() { // 리스트 조회
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM contactTBL;", null);
                if(cursor.getCount()>0){
                    cAdapter = new IdolAdapter(MainActivity.this, cursor, true);
                    listview.setAdapter(cAdapter);
                }else{
                    cAdapter = null;
                    listview.setAdapter(cAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회됨", Toast.LENGTH_SHORT).show();
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {//listView클릭했을 때
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                TextView txtTel = view.findViewById(R.id.txtCount);
                String out = "이름: " + txtName.getText().toString();
                out += "\n인원 수: " + txtTel.getText().toString();
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });

    } //onCreate

    @Override
    protected void onStop() {
        super.onStop();
        cursor.close(); //커서를 닫으면 오류가 남 커서는 onStop()에서 닫기
    }

}