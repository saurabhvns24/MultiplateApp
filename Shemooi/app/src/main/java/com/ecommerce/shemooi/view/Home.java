package com.ecommerce.shemooi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ecommerce.shemooi.Model.Category;
import com.ecommerce.shemooi.Model.FeatureBrandProduct;
import com.ecommerce.shemooi.Model.MegaSaleProduct;
import com.ecommerce.shemooi.R;
import com.ecommerce.shemooi.adapter.CategoryAdapter;
import com.ecommerce.shemooi.adapter.FeatureProductAdapter;
import com.ecommerce.shemooi.adapter.MegaSaleAdapter;
import com.ecommerce.shemooi.adapter.TopSellersAdapter;
import com.ecommerce.shemooi.clickListener.OnClickListener;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements OnClickListener {

    private MegaSaleAdapter megaSaleAdapter;
    private TopSellersAdapter topSellersAdapter;
    private FeatureProductAdapter featureProductAdapter;
    private CategoryAdapter categoryAdapter;
    private RecyclerView mega_sale_recycler_view, feature_brand_recycler_view, category_recycler_view, mega_sale_recycler_view_new;
    private ArrayList<FeatureBrandProduct> featureBrandProductArrayList;
    private ArrayList<MegaSaleProduct> megaSaleProductArrayList;
    private ArrayList<Category> categoryArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Context context = Home.this;
        mega_sale_recycler_view_new = findViewById(R.id.mega_sale_recycler_view_new);
        mega_sale_recycler_view = findViewById(R.id.mega_sale_recycler_view);
        feature_brand_recycler_view = findViewById(R.id.feature_brand_recycler_view);
        category_recycler_view = findViewById(R.id.category_recycler_view);
        FeatureBrandProduct featureBrandProduct1 = new FeatureBrandProduct("", "", "");
        FeatureBrandProduct featureBrandProduct2 = new FeatureBrandProduct("", "", "");
        FeatureBrandProduct featureBrandProduct3 = new FeatureBrandProduct("", "", "");
        featureBrandProductArrayList = new ArrayList<>();
        featureBrandProductArrayList.add(featureBrandProduct1);
        featureBrandProductArrayList.add(featureBrandProduct2);
        featureBrandProductArrayList.add(featureBrandProduct3);
        featureProductAdapter = new FeatureProductAdapter(featureBrandProductArrayList, context);
        feature_brand_recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
        linearLayoutManager1.setReverseLayout(false);
        linearLayoutManager1.setStackFromEnd(false);
        feature_brand_recycler_view.setLayoutManager(linearLayoutManager1);
        feature_brand_recycler_view.setAdapter(featureProductAdapter);

        MegaSaleProduct megaSaleProduct1 = new MegaSaleProduct("", "Glowing Foundation", "Rs 299,43", "24% Off");
        MegaSaleProduct megaSaleProduct2 = new MegaSaleProduct("", "Glowing Foundation", "Rs 299,43", "24% Off");
        MegaSaleProduct megaSaleProduct3 = new MegaSaleProduct("", "Glowing Foundation", "Rs 299,43", "24% Off");
        MegaSaleProduct megaSaleProduct4 = new MegaSaleProduct("", "Glowing Foundation", "Rs 299,43", "24% Off");
        megaSaleProductArrayList = new ArrayList<>();
        megaSaleProductArrayList.add(megaSaleProduct1);
        megaSaleProductArrayList.add(megaSaleProduct2);
        megaSaleProductArrayList.add(megaSaleProduct3);
        megaSaleProductArrayList.add(megaSaleProduct4);
        megaSaleAdapter = new MegaSaleAdapter(megaSaleProductArrayList, context, Home.this);
        mega_sale_recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
        linearLayoutManager2.setReverseLayout(false);
        linearLayoutManager2.setStackFromEnd(false);
        mega_sale_recycler_view.setLayoutManager(linearLayoutManager2);
        mega_sale_recycler_view.setAdapter(megaSaleAdapter);

        Category category1 = new Category("Essentials");
        Category category2 = new Category("Skin Care");
        Category category3 = new Category("Makeup");
        Category category4 = new Category("Essentials");
        Category category5 = new Category("Care");
        categoryArrayList = new ArrayList<>();
        categoryArrayList.add(category1);
        categoryArrayList.add(category2);
        categoryArrayList.add(category3);
        categoryArrayList.add(category4);
        categoryArrayList.add(category5);
        categoryAdapter = new CategoryAdapter(categoryArrayList, context);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
        linearLayoutManager3.setReverseLayout(false);
        linearLayoutManager3.setStackFromEnd(false);
        category_recycler_view.setLayoutManager(linearLayoutManager3);
        category_recycler_view.setAdapter(categoryAdapter);
        topSellersAdapter = new TopSellersAdapter(megaSaleProductArrayList, context, Home.this);
        mega_sale_recycler_view_new.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        mega_sale_recycler_view_new.setLayoutManager(layoutManager);
        mega_sale_recycler_view_new.setAdapter(topSellersAdapter);
    }

    @Override
    public void clickOnItem(int position) {
        startActivity(new Intent(Home.this, Product.class));
    }
}