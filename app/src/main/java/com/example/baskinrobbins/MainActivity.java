package com.example.baskinrobbins;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ListViewAdapter adapter;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            System.out.println("ㅁ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }

    private void setViews() {
        listview = (ListView) findViewById(R.id.listview);

        DownThread down = new DownThread(handler);
        down.start();
    }
}
