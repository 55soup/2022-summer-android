package com.cookandroid.and0803_01_customelistcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    JejuAdapter jAdapter;
    ArrayList<Jeju> jArray;
    Jeju jItem;
    Integer[] image = {R.drawable.jeju1,R.drawable.jeju2,R.drawable.jeju3,R.drawable.jeju4,R.drawable.jeju5,
            R.drawable.jeju6,R.drawable.jeju7,R.drawable.jeju8,R.drawable.jeju9,R.drawable.jeju10};
    String[] sites = {"돌덩이", "용오름", "꽃밭", "등대", "돌덩이",
            "돌덩이", "돌덩이", "돌덩이", "돌덩이", "등대"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 여행장소 리스트뷰");
        list = findViewById(R.id.list);
        jArray = new ArrayList<>();
        for(int i=0; i<image.length; i++){
            jItem = new Jeju(ContextCompat.getDrawable(this, image[i]), sites[i]);
            jArray.add(jItem);
        }// 무비 객체 배열 초기화(ArrayList에 값으로 생성)
        jAdapter = new JejuAdapter(this, jArray);
        list.setAdapter(jAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Jeju item = (Jeju)list.getItemAtPosition(i);
                //setTitle(item.getSites());
                customToast(item);
            }
        });
    }

    public void customToast(Jeju item){
        View layout = getLayoutInflater().inflate(R.layout.jeju_toast, null);
        ImageView img = layout.findViewById(R.id.toast_img);
        TextView txt = layout.findViewById(R.id.toast_txt);
        img.setImageDrawable(item.getImage());
        txt.setText(item.getSites());
        Toast t = new Toast(getApplicationContext());
        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0); //위치지정
        t.setDuration(Toast.LENGTH_SHORT);
        t.setView(layout);
        t.show();
    }
}