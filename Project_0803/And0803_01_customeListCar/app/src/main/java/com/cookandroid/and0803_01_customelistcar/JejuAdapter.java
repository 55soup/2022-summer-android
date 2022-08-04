package com.cookandroid.and0803_01_customelistcar;

import android.content.Context;
import android.graphics.Movie;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class JejuAdapter extends BaseAdapter {
    Context context;
    ArrayList<Jeju> data; //데이터

    public JejuAdapter(Context context, ArrayList<Jeju> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){//초기화
            view = View.inflate(context, R.layout.listitem, null);
        }
        ImageView img = view.findViewById(R.id.imgJeju);
        TextView txtTitle = view.findViewById(R.id.txt_name);
        img.setImageDrawable(data.get(i).getImage()); //Movie의 image변수값 가져와서 연결
        txtTitle.setText(data.get(i).getSites());
        return view;
    }
}
