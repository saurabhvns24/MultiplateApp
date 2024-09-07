package com.ecommerce.shemooi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.shemooi.Model.Category;
import com.ecommerce.shemooi.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<Category> list;
    Context context;

    public CategoryAdapter(ArrayList<Category> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.custom_catagory_view, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CategoryViewHolder viewHolder, final int position) {
        viewHolder.category_name_tv.setText(list.get(position).getCategoryName());
        if (position == 0) {
            viewHolder.imageview_one.setImageDrawable(context.getDrawable(R.drawable.image_4));
        }
        if (position == 1) {
            viewHolder.imageview_one.setImageDrawable(context.getDrawable(R.drawable.image_6));
        }
        if (position == 2) {
            viewHolder.imageview_one.setImageDrawable(context.getDrawable(R.drawable.image_5));
        }
        if (position == 3) {
            viewHolder.imageview_one.setImageDrawable(context.getDrawable(R.drawable.image_4));
        }
        if (position == 4) {
            viewHolder.imageview_one.setImageDrawable(context.getDrawable(R.drawable.image_6));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView category_name_tv;
        private ImageView imageview_one;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            this.category_name_tv = (TextView) itemView.findViewById(R.id.category_name_tv);
            this.imageview_one = (ImageView) itemView.findViewById(R.id.imageview_one);
        }
    }
}
