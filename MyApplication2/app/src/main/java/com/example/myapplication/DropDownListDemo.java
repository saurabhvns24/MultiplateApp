package com.example.myapplication;

import static java.util.Arrays.*;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DropDownListDemo extends Activity {
    private PopupWindow pw;
    public static boolean[] checkSelected;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initialize();
    }

    private void initialize() {
        final ArrayList<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        items.add("Item 5");

        checkSelected = new boolean[items.size()];
        fill(checkSelected, false);
        final TextView tv = findViewById(R.id.SelectBox);
        tv.setOnClickListener(v -> initiatePopUp(items, tv));
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initiatePopUp(ArrayList<String> items, TextView tv) {
        LayoutInflater inflater = (LayoutInflater) DropDownListDemo.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.pop_up_window, findViewById(R.id.PopUpView));
        RelativeLayout layout1 = findViewById(R.id.relativeLayout1);
        pw = new PopupWindow(layout, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
        pw.setTouchable(true);
        pw.setOutsideTouchable(true);
        pw.setHeight(LayoutParams.WRAP_CONTENT);
        pw.setTouchInterceptor((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                pw.dismiss();
                return true;
            }
            return false;
        });
        pw.setContentView(layout);
        pw.showAsDropDown(layout1);
        final ListView list;
        list = layout.findViewById(R.id.dropDownList);
        DropDownListAdapter adapter;
        adapter = new DropDownListAdapter(this, items, tv);
        list.setAdapter(adapter);
    }
}