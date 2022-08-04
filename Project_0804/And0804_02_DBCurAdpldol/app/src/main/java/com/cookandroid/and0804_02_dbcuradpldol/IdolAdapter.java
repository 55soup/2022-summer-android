package com.cookandroid.and0804_02_dbcuradpldol;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.cookandroid.and0804_02_dbcuradpldol.R;

public class IdolAdapter extends CursorAdapter {

    //생성자 정의 필수(부모 클래스의 기본생성자 없음)
    public IdolAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v =  View.inflate(context, R.layout.item, null); //list.xml을 객체화
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtTel = view.findViewById(R.id.txtCount);
        txtName.setText(cursor.getString(1));
        txtTel.setText(cursor.getString(2));
    }
}
