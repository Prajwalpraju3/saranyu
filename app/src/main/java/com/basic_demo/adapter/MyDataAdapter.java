package com.basic_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.basic_demo.Activity.MainActivity;
import com.basic_demo.R;
import com.basic_demo.databinding.RvItemBinding;
import com.basic_demo.models.DataList;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.CutomViewHolder> {

    private ArrayList<DataList> mDataList;
    private Context mContext;


    public MyDataAdapter(ArrayList<DataList> list, MainActivity context) {
        mDataList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public MyDataAdapter.CutomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        RvItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.rv_item, parent, false);
        return new CutomViewHolder(mContext, binding.getRoot());

    }

    @Override
    public void onBindViewHolder(@NonNull MyDataAdapter.CutomViewHolder holder, int position) {

        DataList item = mDataList.get(position);
        RvItemBinding binding = (RvItemBinding) holder.getBinding();
        binding.setVariable(BR.dataitem, item);
        binding.executePendingBindings();


    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
    class CutomViewHolder extends RecyclerView.ViewHolder {

        RvItemBinding binding;

        CutomViewHolder(Context mContext, @NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        RvItemBinding getBinding() {
            return binding;
        }
}

}
