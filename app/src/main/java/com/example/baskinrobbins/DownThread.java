package com.example.baskinrobbins;

import android.os.Handler;
import android.os.Message;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownThread extends Thread {
  Handler handler;
  private String icearr[];
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
        Elements lis = doc.getElementsByTag("li");
        for (Element li : lis) {
          if(li.className().equals("item")) {
            
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    Message msg = new Message();
    msg.what = 0;
    handler.sendMessage(msg);
  }
}
