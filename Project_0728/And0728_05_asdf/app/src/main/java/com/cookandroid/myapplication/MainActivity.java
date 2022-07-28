package com.cookandroid.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txt;
    EditText edtName, edtTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴실습 박선주");

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("전화번호 등록");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final View dlgView = (View)View.inflate(MainActivity.this, R.layout.dlg, null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edName = dlgView.findViewById(R.id.edtName);
                        EditText edtTel = dlgView.findViewById(R.id.edtTel);
                        String str = "이름 : " + edName.getText().toString() + "\n" +
                                "전화번호 : " + edtTel.getText().toString();
                        txt.setText(str);
                    }
                });
                dlg.show();
            }
        });
    }
}