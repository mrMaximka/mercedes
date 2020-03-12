package com.mrmaximka.mersedestest.ui.home;

import android.content.Context;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mrmaximka.mersedestest.R;
import com.mrmaximka.mersedestest.model.CryptoAnalyserRestModel;

public class DataViewHolder extends RecyclerView.ViewHolder {

    private CryptoAnalyserRestModel model;
    ConstraintLayout container = itemView.findViewById(R.id.containerData);
    private TextView pair;
    private TextView price;
    private TextView day1;
    private TextView day7;
    private TextView day30;
    private Context context;


    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(CryptoAnalyserRestModel cryptoAnalyserRestModel, Context context){
        this.model = cryptoAnalyserRestModel;
        this.context = context;

        initView();
        setViewSettings();

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showPopupMenu(view);
                return true;
            }
        });

        itemView.setOnTouchListener(new OnSwipeTouchListener(){
            @Override
            public boolean onSwipeLeft() {
                showPopupMenu(itemView);
                return true;
            }
        });

    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu( context, view);
        popupMenu.inflate(R.menu.popup_menu);

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                Toast.makeText(context,
                                        "Edit",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu2:
                                Toast.makeText(context,
                                        "Delete",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return true;
                        }
                    }
                });
        popupMenu.show();
    }

    private void initView() {
        pair = itemView.findViewById(R.id.item_pair);
        price = itemView.findViewById(R.id.item_price);
        day1 = itemView.findViewById(R.id.day_1);
        day7 = itemView.findViewById(R.id.day_7);
        day30 = itemView.findViewById(R.id.day_30);

    }

    private void setViewSettings() {
        setPair();
        setPrice();
        setDay1();
        setDay7();
        setDay30();
    }

    private void setPair() {
        pair.setText(String.format("%s\n%s\n%s", model.fsym, model.tsym, model.exchange));
    }

    private void setPrice() {
        price.setText(model.current_price);
    }

    private void setDay1() {
        day1.setText(String.format("%s\n%s%%", model.day1, model.dayProc1));
    }

    private void setDay7() {
        day7.setText(String.format("%s\n%s%%", model.day7, model.dayProc7));
    }

    private void setDay30() {
        day30.setText(String.format("%s\n%s%%", model.day30, model.dayProc30));
    }
}
