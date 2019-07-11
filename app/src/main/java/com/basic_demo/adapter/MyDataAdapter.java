package com.basic_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.basic_demo.R;
import com.basic_demo.models.ExampleOld;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.CutomViewHolder> {

    private List<ExampleOld> mDataList;
    private Context mContext;


    public MyDataAdapter(List<ExampleOld> dataList, Context context) {
        mDataList = dataList;
        mContext = context;
    }

    @NonNull
    @Override
    public MyDataAdapter.CutomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(mContext).inflate(R.layout.item,null);
        return new CutomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDataAdapter.CutomViewHolder holder, int position) {

        ExampleOld exampleOld = mDataList.get(position);

        holder.tv_head.setText(exampleOld.getTitle());
        holder.tv_dis.setText(exampleOld.getDescription());

            holder.tv_id.setText("News Ids -"+ exampleOld.getId());
            holder.tv_id.setVisibility(View.GONE);
            holder.tv_head.setTextSize(26);

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
    class CutomViewHolder extends RecyclerView.ViewHolder {

        TextView tv_head,tv_dis,tv_id;

        CutomViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_head = (TextView)itemView.findViewById(R.id.tv_head);
            tv_dis = (TextView)itemView.findViewById(R.id.tv_dis);
            tv_id = (TextView)itemView.findViewById(R.id.tv_id);

        }
}

}
