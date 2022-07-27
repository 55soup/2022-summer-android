package com.cookandroid.and0727_05_tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLay;
    ViewPager viewPager;
    FragementAdapter fragAdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("tabLayout 박선주");
        tabLay = findViewById(R.id.tabLay);
        viewPager = findViewById(R.id.viewPager);
        fragAdt = new FragementAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragAdt);
        tabLay.setupWithViewPager(viewPager);
        tabLay.getTabAt(0).setText("잔액");
        tabLay.getTabAt(1).setText("입금");
        tabLay.getTabAt(2).setText("출금");

    }
}