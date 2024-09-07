package com.ecommerce.shemooi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.shemooi.clickListener.OnClickListenerSelectColor;
import com.ecommerce.shemooi.R;

import java.util.ArrayList;
import java.util.List;

public class SelectColorAdapter extends RecyclerView.Adapter<SelectColorAdapter.SelectColorViewHolder> {

    private int selectedPos;
    private List<Double> list;
    private Context context;
    private OnClickListenerSelectColor onClickListenerSelectColor;

    public SelectColorAdapter(ArrayList<Double> list, Context context, OnClickListenerSelectColor onClickListenerSelectColor) {
        this.list = list;
        this.context = context;
        this.onClickListenerSelectColor = onClickListenerSelectColor;
    }

    @Override
    public SelectColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.custom_select_color_item_view, parent, false);
        SelectColorViewHolder selectColorViewHolder = new SelectColorViewHolder(itemView);
        return selectColorViewHolder;
    }

    @Override
    public void onBindViewHolder(SelectColorViewHolder holder, int position) {
        if (position == 0) {
            holder.color_imageview.setImageDrawable(context.getDrawable(R.drawable.image_20));
        }
        if (position == 1) {
            holder.color_imageview.setImageDrawable(context.getDrawable(R.drawable.image_21));
        }
        if (position == 2) {
            holder.color_imageview.setImageDrawable(context.getDrawable(R.drawable.image_22));
        }
        if (position == 3) {
            holder.color_imageview.setImageDrawable(context.getDrawable(R.drawable.image_23));
        }
        if (position == 4) {
            holder.color_imageview.setImageDrawable(context.getDrawable(R.drawable.image_24));
        }
        if (position == 5) {
            holder.color_imageview.setImageDrawable(context.getDrawable(R.drawable.image_21));
        }
        if (position == 6) {
            holder.color_imageview.setImageDrawable(context.getDrawable(R.drawable.image_22));
        }

        holder.changeToSelect(selectedPos == position ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SelectColorViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageview;
        private ImageView color_imageview;

        SelectColorViewHolder(final View viewItem) {
            super(viewItem);
            this.color_imageview = (ImageView) itemView.findViewById(R.id.color_imageview);
            this.imageview = (ImageView) itemView.findViewById(R.id.imageview);

            color_imageview.setOnClickListener(v -> {
                // Triggers click upwards to the adapter on click
                if (onClickListenerSelectColor != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        onClickListenerSelectColor.clickOnBottleSize(viewItem, position);
                        notifyItemChanged(selectedPos);
                        selectedPos = getAdapterPosition();
                        notifyItemChanged(selectedPos);
                    }
                }
            });
        }

        public void changeToSelect(int visibility) {
            imageview.setVisibility(visibility);
        }
    }
}
//Top Rated Product

//