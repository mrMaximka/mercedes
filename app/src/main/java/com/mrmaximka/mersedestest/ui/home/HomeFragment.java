package com.mrmaximka.mersedestest.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.mrmaximka.mersedestest.R;

public class HomeFragment extends Fragment {

    private HomeViewModel viewModel;
    private RecyclerView dataList;
    private DataAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        viewModel.isLoad.observe(this, aBoolean -> {
            if (aBoolean){
                adapter.setElements(viewModel.getModel());
                viewModel.clearFlag();
            }
        });


        viewModel.getData();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        setViewSettings();
    }

    private void initView(View view) {
        dataList = view.findViewById(R.id.data_list);
        adapter = new DataAdapter(getContext());
    }

    private void setViewSettings() {
        dataList.setAdapter(adapter);
    }
}
