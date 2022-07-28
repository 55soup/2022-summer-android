package com.cookandroid.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtName, txtTel;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴실습 박선주");

        txtName = findViewById(R.id.txtName);
        txtTel = findViewById(R.id.txtTel);
        btnExit = findViewById(R.id.btnExit);

        btnExit.setOnClickListener(new View.OnClickListener() { //종료하기
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.popup_exit, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.popInit:
                                txtName.setText("");
                                txtTel.setText("");
                                return true;
                            case R.id.popExit:
                                finish();
                        }
                        return false;
                    }
                });
                p.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // option메뉴 생성
        super.onCreateOptionsMenu(menu);
        MenuInflater minFlater = getMenuInflater();
        minFlater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemReg:
                OnDialog();
                return true;
            case R.id.itemGreen:
                txtName.setTextColor(Color.GREEN);
                txtTel.setTextColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                txtName.setTextColor(Color.BLUE);
                txtTel.setTextColor(Color.BLUE);
                return true;
            case R.id.itemDefault:
                txtName.setTextColor(Color.BLACK);
                txtTel.setTextColor(Color.BLACK);

        }
        return super.onOptionsItemSelected(item);
    }

    private void OnDialog(){
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("전화 번호 등록");
            dlg.setIcon(R.mipmap.ic_launcher_round);
            final View dlgView = (View)View.inflate(MainActivity.this, R.layout.dialog, null);
            dlg.setView(dlgView);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    EditText edtName = dlgView.findViewById(R.id.edtName);
                    EditText edtTel = dlgView.findViewById(R.id.edtTel);
                    txtName.append(edtName.getText().toString()+"\n");
                    txtTel.append(edtTel.getText().toString()+"\n");
                }
            });
            dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), "창 닫음", Toast.LENGTH_SHORT).show();
                }
            });
            dlg.show();
        }
    }
