package com.example.uiapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 一钢 on 2018/7/17.
 */

public class WeekAdapter2 extends RecyclerView.Adapter<WeekAdapter2.ViewHolder> {

    private List<Week> weekList;

    static class ViewHolder extends  RecyclerView.ViewHolder{
        View weekView;
        ImageView weekImage;
        TextView weekName;

        public ViewHolder(View view) {
            super(view);
            weekView = view;
            weekImage = (ImageView) view.findViewById(R.id.weekImage);
            weekName = (TextView) view.findViewById(R.id.weekName);
        }
    }
    public WeekAdapter2(List<Week> weekList) {
        this.weekList = weekList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.week_item2_layout,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.weekView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Week week = weekList.get(position);
                Toast.makeText(v.getContext(),"点击了文本 "+week.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.weekImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Week week = weekList.get(position);
                Toast.makeText(v.getContext(),"点击了图片 "+week.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Week week = weekList.get(position);
        holder.weekImage.setImageResource(week.getImageId());
        holder.weekName.setText(week.getName());
    }

    @Override
    public int getItemCount() {
        return weekList.size();
    }
}
