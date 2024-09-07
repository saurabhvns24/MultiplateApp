package com.ecommerce.shemooi.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.shemooi.clickListener.OnClickListenerBottleSize;
import com.ecommerce.shemooi.R;

import java.util.ArrayList;
import java.util.List;

public class BottleSizeAdapter extends RecyclerView.Adapter<BottleSizeAdapter.BottleSizeViewHolder> {

    private int selectedPos = 0;
    private List<Double> list;
    private Context context;
    private OnClickListenerBottleSize onClickListenerBottleSize;

    public BottleSizeAdapter(ArrayList<Double> list, Context context, OnClickListenerBottleSize onClickListenerBottleSize) {
        this.list = list;
        this.context = context;
        this.onClickListenerBottleSize = onClickListenerBottleSize;
    }

    @Override
    public BottleSizeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.custom_select_bottle_item_view, parent, false);
        BottleSizeViewHolder bottleSizeViewHolder = new BottleSizeViewHolder(itemView);
        return bottleSizeViewHolder;
    }

    @Override
    public void onBindViewHolder(BottleSizeViewHolder holder, int position) {
        holder.changeToSelect(selectedPos == position ? context.getDrawable(R.drawable.ic_component_selected) : context.getDrawable(R.drawable.ic_component_not_selected));
        TextView filterText = holder.bottle_size_number_text_view;
        filterText.setText(list.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BottleSizeViewHolder extends RecyclerView.ViewHolder {
        public TextView bottle_size_number_text_view;
        private ImageView imageview;

        BottleSizeViewHolder(final View viewItem) {
            super(viewItem);
            this.bottle_size_number_text_view = (TextView) itemView.findViewById(R.id.bottle_size_number_text_view);
            this.imageview = (ImageView) itemView.findViewById(R.id.imageview);

            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (onClickListenerBottleSize != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onClickListenerBottleSize.clickOnBottleSize(viewItem, position);
                            notifyItemChanged(selectedPos);
                            selectedPos = getAdapterPosition();
                            notifyItemChanged(selectedPos);
                        }
                    }
                }
            });
        }

        public void changeToSelect(Drawable drawable) {
            imageview.setBackground(drawable);
        }
    }
}
