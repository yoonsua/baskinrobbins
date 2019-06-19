package com.example.baskinrobbins;

import android.os.Handler;
import android.os.Message;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownThread extends Thread {
    Handler handler;
    private String strurl = "https://m.baskinrobbins.co.kr/menu/list.php?top=A";
    private String starname;

    public DownThread(Handler handler) {
        this.handler = handler;
    }

    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                Document doc = Jsoup.connect(strurl).get();
                Elements es1 = doc.getElementsByTag("figure");
                System.out.print("안녕하세요");
                for (Element e1 : es1) {
                    System.out.print(e1);
                    if (e1.className().equals("name")) {
                        starname = e1.text();
                        Message msg = new Message();
                        msg.what = 1; // 다음역이 있는 지 확인
                        msg.obj = e1.text(); // 다음역의 이름 저장
                        handler.sendMessage(msg);
                    }
                }
            } catch (Exception e) {
                System.out.println("오류발생");
                System.out.println(e.getMessage());
            }
        }
        Message msg = new Message();
        msg.what = 0;
        handler.sendMessage(msg);
    }
}
