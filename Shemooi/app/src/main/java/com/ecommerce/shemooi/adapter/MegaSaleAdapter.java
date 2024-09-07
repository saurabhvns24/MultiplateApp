package com.ecommerce.shemooi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.shemooi.Model.MegaSaleProduct;
import com.ecommerce.shemooi.clickListener.OnClickListener;
import com.ecommerce.shemooi.R;

import java.util.ArrayList;
import java.util.List;

public class MegaSaleAdapter extends RecyclerView.Adapter<MegaSaleAdapter.MegaSaleViewHolder> {

    List<MegaSaleProduct> list;
    OnClickListener onClickListener;
    Context context;

    public MegaSaleAdapter(ArrayList<MegaSaleProduct> list, Context context, OnClickListener onClickListener) {
        this.list = list;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @Override
    public MegaSaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View photoView = inflater.inflate(R.layout.custom_mega_sale_item_view, parent, false);

        MegaSaleViewHolder viewHolder = new MegaSaleViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MegaSaleViewHolder viewHolder,
                                 final int position) {
        viewHolder.product_name_tv.setText(list.get(position).getProductName());
        viewHolder.product_prize_tv.setText(list.get(position).getProductPrize());
        if (position == 0) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_11));
        }
        if (position == 1) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_12));
        }
        if (position == 2) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_11));
        }
        if (position == 3) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_12));
        }
        if (position == 4) {
            viewHolder.iv.setImageDrawable(context.getDrawable(R.drawable.image_11));
        }

        viewHolder.iv.setOnClickListener(v -> onClickListener.clickOnItem(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MegaSaleViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView product_name_tv, product_prize_tv;


        public MegaSaleViewHolder(View itemView) {
            super(itemView);
            this.iv = (ImageView) itemView.findViewById(R.id.iv);
            this.product_name_tv = (TextView) itemView.findViewById(R.id.product_prize_tv);
            this.product_prize_tv = (TextView) itemView.findViewById(R.id.product_prize_tv);
        }
    }
}
