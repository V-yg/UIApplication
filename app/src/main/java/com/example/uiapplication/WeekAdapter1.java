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

public class WeekAdapter1 extends RecyclerView.Adapter<WeekAdapter1.ViewHolder> {

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

    public WeekAdapter1(List<Week> weekList) {
        this.weekList = weekList;
    }

    //创建ViewHolder实例
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.week_item1_layout,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        //对子项的文本添加监听器
        holder.weekView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Week week = weekList.get(position);
                Toast.makeText(v.getContext(),"点击了文本 "+week.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        //对子项的图片添加监听器
        holder.weekImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Week week = weekList.get(position);
                Toast.makeText(v.getContext(),"点击了图片 "+week.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    //对RecyclerView子项的数据进行赋值，每个子项滚到屏幕内时执行
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
