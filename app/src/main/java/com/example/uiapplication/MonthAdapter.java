package com.example.uiapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;
/**
 * Created by 一钢 on 2018/7/16.
 */
//自定义适配器
public class MonthAdapter extends ArrayAdapter<Month> {

    private int resourceId;

    //重写父类构造函数
    public MonthAdapter(Context context,int textViewResourceId,List<Month> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    //重写getView() 方法 每个子项滚动到屏幕内是都会被调用
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        Month month = getItem(position);//获取当前事项的Month实例
        //convertView将之前加载好的布局进行缓存 提升性能
        if(convertView == null){
            //使用LayoutInflater为每个子项加载传入的布局
            //false表示只让父布局申明的layout属性生效 不会为View添加父布局
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.monthImage = (ImageView) view.findViewById(R.id.monthImage);
            viewHolder.monthText = (TextView) view.findViewById(R.id.monthText);
            view.setTag(viewHolder);
        } else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.monthImage.setImageResource(month.getImageId());
        viewHolder.monthText.setText(month.getName());
        return view;
    }

    //内部类  对控件的实例进行缓存
    class ViewHolder{
        ImageView monthImage;
        TextView monthText;
    }
}
