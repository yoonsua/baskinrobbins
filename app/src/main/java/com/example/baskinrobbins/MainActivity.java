package com.example.baskinrobbins;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SlideAdapter adapter;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgslide();
    }
    private void imgslide() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        adapter = new SlideAdapter(this);
        viewpager.setAdapter(adapter);
    }

}
