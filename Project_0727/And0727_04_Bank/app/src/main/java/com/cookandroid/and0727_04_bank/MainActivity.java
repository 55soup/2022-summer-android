package com.cookandroid.and0727_04_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button[] btns = new Button[3];
    Integer[] btnsIds = {R.id.btn1, R.id.btn2, R.id.btn3};
    LinearLayout[] lins = new LinearLayout[3];
    Integer[] linsIds = {R.id.lin1, R.id.lin2, R.id.lin3};

    TextView txtBal;
    EditText edtInput, edtOutput;
    Button btnInput, btnOutput;
    int total = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("은행 박선주");
        txtBal = findViewById(R.id.txtBal);
        edtInput = findViewById(R.id.edtInput);
        edtOutput = findViewById(R.id.edtOutput);
        btnInput = findViewById(R.id.btnInput);
        btnOutput = findViewById(R.id.btnOutput);

        for(int i=0; i<btns.length; i++){
            btns[i] = findViewById(btnsIds[i]);
            lins[i] = findViewById(linsIds[i]);
        }
        lins[0].setVisibility(View.INVISIBLE);
        lins[1].setVisibility(View.INVISIBLE);
        lins[2].setVisibility(View.INVISIBLE);

        for(int i=0; i<btns.length; i++){
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.btn1:
                            lins[0].setVisibility(View.VISIBLE);
                            lins[1].setVisibility(View.INVISIBLE);
                            lins[2].setVisibility(View.INVISIBLE);
                            btns[0].setBackgroundColor(Color.rgb(203,173,255));
                            btns[1].setBackgroundColor(Color.rgb(195,195,195));
                            btns[2].setBackgroundColor(Color.rgb(195,195,195));
                            break;
                        case R.id.btn2:
                            lins[0].setVisibility(View.INVISIBLE);
                            lins[1].setVisibility(View.VISIBLE);
                            lins[2].setVisibility(View.INVISIBLE);
                            btns[0].setBackgroundColor(Color.rgb(195,195,195));
                            btns[1].setBackgroundColor(Color.rgb(255,202,202));
                            btns[2].setBackgroundColor(Color.rgb(195,195,195));
                            break;
                        case R.id.btn3:
                            lins[0].setVisibility(View.INVISIBLE);
                            lins[1].setVisibility(View.INVISIBLE);
                            lins[2].setVisibility(View.VISIBLE);
                            btns[0].setBackgroundColor(Color.rgb(195,195,195));
                            btns[1].setBackgroundColor(Color.rgb(195,195,195));
                            btns[2].setBackgroundColor(Color.rgb(144,220,155));
                            break;
                    }
                }
            });
        }

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total += Integer.parseInt(edtInput.getText().toString());
                txtBal.setText("잔액: "+total);
                Toast.makeText(getApplicationContext(), edtInput.getText().toString()+"원 입금되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btnOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(total >= Integer.parseInt(edtOutput.getText().toString())){
                    total -= Integer.parseInt(edtOutput.getText().toString());
                    txtBal.setText("잔액: "+ total);
                    Toast.makeText(getApplicationContext(), edtOutput.getText().toString()+"원 출금되었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext()," 출금이 불가능합니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}