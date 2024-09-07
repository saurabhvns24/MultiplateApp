package com.ecommerce.shemooi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.shemooi.Model.FeatureBrandProduct;
import com.ecommerce.shemooi.Model.MegaSaleProduct;
import com.ecommerce.shemooi.R;

import java.util.ArrayList;
import java.util.List;

public class FeatureProductAdapter extends RecyclerView.Adapter<FeatureProductAdapter.FeatureProductViewHolder> {

    List<FeatureBrandProduct> list;
    Context context;

    public FeatureProductAdapter(ArrayList<FeatureBrandProduct> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public FeatureProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout

        View photoView = inflater.inflate(R.layout.custome_item_view, parent, false);

        FeatureProductViewHolder viewHolder = new FeatureProductViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final FeatureProductViewHolder viewHolder, final int position) {
        if (position == 0) {
            viewHolder.tv.setText("Maybelline");
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_1));
        }
        if (position == 1) {
            viewHolder.tv.setText("Sugar");
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_2));
        }
        if (position == 2) {
            viewHolder.tv.setText("Maybelline");
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_3));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class FeatureProductViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private ImageView iv;

        public FeatureProductViewHolder(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.tv);
            this.iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
