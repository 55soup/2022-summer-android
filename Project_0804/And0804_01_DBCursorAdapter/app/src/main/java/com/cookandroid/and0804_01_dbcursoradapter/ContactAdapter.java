package com.cookandroid.and0804_01_dbcursoradapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ContactAdapter extends CursorAdapter {

    //생성자 정의 필수(부모 클래스의 기본생성자 없음)
    public ContactAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v =  View.inflate(context, R.layout.list, null); //list.xml을 객체화
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtTel = view.findViewById(R.id.txtTel);
        txtName.setText(cursor.getString(1));
        txtTel.setText(cursor.getString(2));
    }
}
