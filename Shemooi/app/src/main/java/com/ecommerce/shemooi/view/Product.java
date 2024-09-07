package com.ecommerce.shemooi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ecommerce.shemooi.Model.MegaSaleProduct;
import com.ecommerce.shemooi.R;
import com.ecommerce.shemooi.adapter.BottleSizeAdapter;
import com.ecommerce.shemooi.adapter.MegaSaleAdapter;
import com.ecommerce.shemooi.adapter.SelectColorAdapter;
import com.ecommerce.shemooi.adapter.ViewPagerAdapter;
import com.ecommerce.shemooi.clickListener.OnClickListener;
import com.ecommerce.shemooi.clickListener.OnClickListenerBottleSize;
import com.ecommerce.shemooi.clickListener.OnClickListenerSelectColor;
import com.noowenz.showmoreless.ShowMoreLess;
import com.skyhope.showmoretextview.ShowMoreTextView;

import java.util.ArrayList;

import ru.embersoft.expandabletextview.ExpandableTextView;

public class Product extends AppCompatActivity implements OnClickListenerBottleSize, OnClickListener, OnClickListenerSelectColor {
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    private RecyclerView select_bottle_size_recycler_view, select_color_lable_recycler_view, mega_sale_recycler_view;
    private ArrayList<Double> bottleSize;
    private BottleSizeAdapter bottleSizeAdapter;
    private Context context;
    private SelectColorAdapter selectColorAdapter;
    private ArrayList<MegaSaleProduct> megaSaleProductArrayList;
    private MegaSaleAdapter megaSaleAdapter;
    private ExpandableTextView textView;
    private  boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        context = Product.this;
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        findViewById(R.id.back_button).setOnClickListener(v -> onBackPressed());
        setupViewPager();
        setupBottleSize();
        setupSelectColor();
        setupSimilarProduct();
        loadUi();
    }

    private void loadUi() {
        textView = findViewById(R.id.text_view_show_more);
//        textView.setText("Read more");

        textView.setOnStateChangeListener(isShrink -> {
            flag = isShrink;
//            textView.setText("air max are always very comfortable fit, clean and just perfect in every way. just the box was too small and scrunched the sneakers up a little bit, not sure if the box was always this small but the 90s are and will always be one of my favorites.");
        });
        textView.setText("air max are always very comfortable fit, clean and just perfect in every way. just the box was too small and scrunched the sneakers up a little bit, not sure if the box was always this small but the 90s are and will always be one of my favorites.");
        textView.resetState(flag);
    }

    private void setupSimilarProduct() {
        MegaSaleProduct megaSaleProduct1 = new MegaSaleProduct("", "Glowing Foundation", "Rs 299,43", "24% Off");
        MegaSaleProduct megaSaleProduct2 = new MegaSaleProduct("", "Glowing Foundation", "Rs 299,43", "24% Off");
        MegaSaleProduct megaSaleProduct3 = new MegaSaleProduct("", "Glowing Foundation", "Rs 299,43", "24% Off");
        megaSaleProductArrayList = new ArrayList<>();
        megaSaleProductArrayList.add(megaSaleProduct1);
        megaSaleProductArrayList.add(megaSaleProduct2);
        megaSaleProductArrayList.add(megaSaleProduct3);
        mega_sale_recycler_view = findViewById(R.id.mega_sale_recycler_view);
        megaSaleAdapter = new MegaSaleAdapter(megaSaleProductArrayList, context, Product.this);
        mega_sale_recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
        linearLayoutManager.setReverseLayout(false);
        linearLayoutManager.setStackFromEnd(false);
        mega_sale_recycler_view.setLayoutManager(linearLayoutManager);
        mega_sale_recycler_view.setAdapter(megaSaleAdapter);
    }

    private void setupSelectColor() {
        select_color_lable_recycler_view = findViewById(R.id.select_color_lable_recycler_view);
        bottleSize = new ArrayList<>();
        for (double size = 6; size <= 10; size += 0.5) {
            bottleSize.add(size);
        }
        selectColorAdapter = new SelectColorAdapter(bottleSize, context, Product.this);
        select_color_lable_recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
        linearLayoutManager.setReverseLayout(false);
        linearLayoutManager.setStackFromEnd(false);
        select_color_lable_recycler_view.setLayoutManager(linearLayoutManager);
        select_color_lable_recycler_view.setAdapter(selectColorAdapter);
    }

    private void setupBottleSize() {
        select_bottle_size_recycler_view = findViewById(R.id.select_bottle_size_recycler_view);
        bottleSize = new ArrayList<>();
        for (double size = 6; size <= 10; size += 0.5) {
            bottleSize.add(size);
        }
        bottleSizeAdapter = new BottleSizeAdapter(bottleSize, context, Product.this);
        select_bottle_size_recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
        linearLayoutManager.setReverseLayout(false);
        linearLayoutManager.setStackFromEnd(false);
        select_bottle_size_recycler_view.setLayoutManager(linearLayoutManager);
        select_bottle_size_recycler_view.setAdapter(bottleSizeAdapter);
    }

    private void setupViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void clickOnItem(int position) {

    }

    @Override
    public void clickOnBottleSize(View view, int position) {

    }


}