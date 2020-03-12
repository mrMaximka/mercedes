package com.mrmaximka.mersedestest.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrmaximka.mersedestest.R;
import com.mrmaximka.mersedestest.model.CryptoAnalyserRestModel;

import java.util.Collections;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    private List<CryptoAnalyserRestModel> list = Collections.emptyList();
    private Context context;

    public DataAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        DataViewHolder dataViewHolder = holder;

        dataViewHolder.bind(list.get(position), context);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_fall_down);
        dataViewHolder.container.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setElements(List<CryptoAnalyserRestModel> model) {
        this.list = model;
        notifyDataSetChanged();
    }
}
