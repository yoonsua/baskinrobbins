package com.example.baskinrobbins;

import android.os.Handler;
import android.os.Message;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownThread extends Thread {
  Handler handler;
  private String strurl = "http://m.baskinrobbins.co.kr/menu/list.php?top=A";
  private String starname;

  public DownThread(Handler handler) {
    this.handler = handler;
  }

  public void run() {
    boolean flag = true;
    while (flag) {
      try {
        Document doc = Jsoup.connect(strurl).get();
        Elements figures = doc.getElementsByTag("figure");
        Elements divs = doc.getElementsByTag("div");
        flag = false;
        for (Element figure : figures) {
          Elements figcaptions = doc.getElementsByTag("figcaption");
          if (figure.className().equals("img")) {
            Elements imgs = doc.getElementsByTag("img");
            for (Element img : imgs) {
              String imgtxt = img.text();
              String imgsrc = imgtxt.replace("img src = alt", "");
              Message msg = new Message();
              msg.what = 1;
              msg.obj = imgsrc;
              handler.sendMessage(msg);
              flag = true;
            }
          }
          for (Element figcaption : figcaptions) {
            Elements spans = doc.getElementsByTag("span");
            for (Element span : spans) {
              Message msg = new Message();
              msg.what = 1;
              msg.obj = span.text();
              handler.sendMessage(msg);
              flag = true;
            }
          }
        }
        for(Element div : divs) {
          if(div.className().equals("hashtag")) {
            Elements as = doc.getElementsByTag("a");
            for(Element a : as) {
              Message msg = new Message();
              msg.what = 1;
              msg.obj = a.text();
              handler.sendMessage(msg);
              flag = true;
            }
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
