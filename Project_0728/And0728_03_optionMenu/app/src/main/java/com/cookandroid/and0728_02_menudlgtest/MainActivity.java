package com.cookandroid.and0728_02_menudlgtest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("option 이미지바꾸기");
        img = findViewById(R.id.img);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minFlater = getMenuInflater();
        minFlater.inflate(R.menu.option_food, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.op_nut:
                img.setImageResource(R.drawable.icon1);
                return true;
            case R.id.op_loll:
                img.setImageResource(R.drawable.icon2);
                return true;
            case R.id.op_star:
                img.setImageResource(R.drawable.btn_star_big_on);
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택안됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}