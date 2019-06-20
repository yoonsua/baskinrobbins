package com.example.baskinrobbins;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    ArrayList<String> icecream = new ArrayList<>();

    @Override
    public int getCount() {
        return icecream.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      final int POS = position;
      final Context CONTEXT = parent.getContext();

      if(convertView == null) {
        LayoutInflater inflater = (LayoutInflater) CONTEXT.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.iceitem, parent, false);
      }
      return convertView;
    }
}
