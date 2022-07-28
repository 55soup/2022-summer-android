package com.cookandroid.and0728_02_menudlgtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.MenuPopupWindow;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnTel, btnGen, btnSign;
    EditText editTel, editGen;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTel = findViewById(R.id.btnTel);
        btnGen = findViewById(R.id.btnGen);
        btnSign = findViewById(R.id.btnSignUp);
        editTel = findViewById(R.id.editTel);
        editGen = findViewById(R.id.editGen);


        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("가입정보 확인");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("전화번호 : " + editTel.getText().toString() + "\n성별 : " + editGen.getText().toString());
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입완료~~", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입취소하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.widget.PopupMenu p = new android.widget.PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.popup_gender, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId()){
                            case R.id.popup_man:
                                editGen.setText("남자");
                                return true;
                            case R.id.popup_woman:
                                editGen.setText("여자");
                                return true;
                        }
                        return false;
                    }
                });
                p.show();
            }
        });
    }// onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //생성
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.op_init :
                Toast.makeText(getApplicationContext(), "초기화", Toast.LENGTH_SHORT).show();
                editTel.setText("");
                editGen.setText("");
                return true;
            case R.id.op_exit:
                Toast.makeText(getApplicationContext(), "종료", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택안됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }


}