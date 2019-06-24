package com.example.baskinrobbins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class icecreamlist extends AppCompatActivity implements View.OnClickListener {
    ImageView openmenu, closemenu, menudown, img_menu;;
    LinearLayout submenu, txt_icecream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icecreamlist);

        setViews();
    }

    private void setViews() {
        openmenu = (ImageView) findViewById(R.id.openmenu);
        closemenu = (ImageView) findViewById(R.id.closemenu);
        submenu = (LinearLayout) findViewById(R.id.submenu);
        menudown = (ImageView) findViewById(R.id.menudown);
        img_menu = (ImageView) findViewById(R.id.img_menu);
        txt_icecream = (LinearLayout) findViewById(R.id.txt_icecream);

        openmenu.setOnClickListener(this);
        closemenu.setOnClickListener(this);
        menudown.setOnClickListener(this);
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
        }
    }
}
