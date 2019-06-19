package com.example.baskinrobbins;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView openmenu, closemenu, menudown, img_menu;
    LinearLayout submenu, txt_icecream, main;
    TextView moveice;
    ViewFlipper v_flipper;

    int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide5, R.drawable.slide6, R.drawable.slide7, R.drawable.slide8};

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if(msg.what == 1) {

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        imgslide();
    }

    private void setViews() {
        openmenu = (ImageView) findViewById(R.id.openmenu);
        closemenu = (ImageView) findViewById(R.id.closemenu);
        menudown = (ImageView) findViewById(R.id.menudown);
        img_menu = (ImageView) findViewById(R.id.img_menu);
        submenu = (LinearLayout) findViewById(R.id.submenu);
        txt_icecream = (LinearLayout) findViewById(R.id.txt_icecream);
        moveice = (TextView) findViewById(R.id.moveice);

        openmenu.setOnClickListener(this);
        closemenu.setOnClickListener(this);
        menudown.setOnClickListener(this);
        moveice.setOnClickListener(this);

        DownThread thread = new DownThread(handler);
        thread.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.openmenu:
                submenu.setVisibility(View.VISIBLE);
                break;
            case R.id.closemenu:
                submenu.setVisibility(View.INVISIBLE);
                break;
            case R.id.menudown:
                txt_icecream.setVisibility(View.VISIBLE);
                menudown.setImageResource(R.drawable.ico_nav_on);
                img_menu.setImageResource(R.drawable.nav_menu_on);
                break;
            case R.id.moveice:
                Intent intent = new Intent(getApplicationContext(), icecreamlist.class);
                startActivity(intent);
                break;
        }
    }

    private void imgslide() {
        v_flipper = (ViewFlipper) findViewById(R.id.image_slide);

        for(int image : images) {
            fllipperImages(image);
        }
    }

    private void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView); // 이미지 추가
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true); // 자동 시작

        v_flipper.setInAnimation(this, android.R.anim.slide_out_right);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
    }

}
