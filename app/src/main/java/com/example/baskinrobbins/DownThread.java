package com.example.baskinrobbins;

import android.os.Handler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownThread {
    Handler handler;
    private String strurl = "https://www.baskinrobbins.co.kr/menu/list.php?top=A&sub=A01";

    public DownThread(Handler handler) {
        this.handler = handler;
    }

    public void run() {
        try {
            Document doc = Jsoup.connect(strurl).get();
            Elements es1 = doc.getElementsByTag("figure");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
