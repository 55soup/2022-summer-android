package com.cookandroid.and0727_05_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BankOutput  extends Fragment {
    Button btnOutput;
    EditText edtOutput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bank_output, container, false);

        btnOutput = v.findViewById(R.id.btnOutput);
        edtOutput = v.findViewById(R.id.edtOutput);

        btnOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(BankData.data >= Integer.parseInt(edtOutput.getText().toString())){
                    int n = Integer.parseInt(edtOutput.getText().toString());
                    BankData.data -= n;
                    BankData.txtBal.setText("잔액:" + BankData.data + "원");
                }else{
                    Toast.makeText(getContext(), "출금이 불가능합니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return v;
    }
}
