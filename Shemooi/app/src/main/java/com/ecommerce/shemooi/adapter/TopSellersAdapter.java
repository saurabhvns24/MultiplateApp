package com.ecommerce.shemooi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.shemooi.Model.MegaSaleProduct;
import com.ecommerce.shemooi.R;
import com.ecommerce.shemooi.clickListener.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class TopSellersAdapter extends RecyclerView.Adapter<TopSellersAdapter.MegaSaleViewHolder> {

    List<MegaSaleProduct> list;
    OnClickListener onClickListener;
    Context context;

    public TopSellersAdapter(ArrayList<MegaSaleProduct> list, Context context, OnClickListener onClickListener) {
        this.list = list;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @Override
    public MegaSaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View photoView = inflater.inflate(R.layout.custom_mega_sale_item_view_one, parent, false);

        MegaSaleViewHolder viewHolder = new MegaSaleViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MegaSaleViewHolder viewHolder,
                                 final int position) {
        viewHolder.product_name_tv.setText(list.get(position).getProductName());
        viewHolder.product_prize_tv.setText("Rs 299,43");
        if (position == 0) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_13));
            viewHolder.iv_one.setImageDrawable(context.getDrawable(R.drawable.image_14));
        }
        if (position == 1) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_15));
            viewHolder.iv_one.setImageDrawable(context.getDrawable(R.drawable.image_16));
        }
        if (position == 2) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_17));
            viewHolder.iv_one.setImageDrawable(context.getDrawable(R.drawable.image_18));
        }
        if (position == 3) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_12));
            viewHolder.iv_one.setImageDrawable(context.getDrawable(R.drawable.image_13));
        }
        if (position == 4) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_14));
            viewHolder.iv_one.setImageDrawable(context.getDrawable(R.drawable.image_15));
        }
        if (position == 5) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_16));
            viewHolder.iv_one.setImageDrawable(context.getDrawable(R.drawable.image_17));
        }


        viewHolder.iv.setOnClickListener(v -> onClickListener.clickOnItem(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MegaSaleViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv,iv_one;
        public TextView product_name_tv, product_prize_tv;


        public MegaSaleViewHolder(View itemView) {
            super(itemView);
            this.iv = (ImageView) itemView.findViewById(R.id.iv);
            this.iv_one = (ImageView) itemView.findViewById(R.id.iv_one);
            this.product_name_tv = (TextView) itemView.findViewById(R.id.product_prize_tv);
            this.product_prize_tv = (TextView) itemView.findViewById(R.id.product_prize_tv);
        }
    }
}
