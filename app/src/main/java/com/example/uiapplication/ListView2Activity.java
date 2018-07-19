package com.example.uiapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListView2Activity extends AppCompatActivity {

    private List<Month> monthList;
    private MonthAdapter adapter;
    private ListView listView;
    private Month month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview2layout);
        //初始化适配器View
        listView = (ListView)findViewById(R.id.list_view);
        //数据源的初始化
        monthList = new ArrayList<>();
        initMonth();
        //适配器的初始化
        adapter = new MonthAdapter(ListView2Activity.this,R.layout.month_item_layout,monthList);
        listView.setAdapter(adapter);
        //用户点击任何一个子项时 ，回调onItemClick() 通过position参数判断哪个子项被点击
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                month = monthList.get(position);
                Toast.makeText(ListView2Activity.this,month.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        //长按事件的监听
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            int position1;
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                position1 = position;
                month = monthList.get(position);

                AlertDialog.Builder dialog1 = new AlertDialog.Builder(ListView2Activity.this);
                dialog1.setTitle("提示！");
                dialog1.setMessage("确定删除"+month.getName()+"吗！");
                dialog1.setCancelable(true);
                dialog1.setPositiveButton("确定", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog1,int which){
                        //长按删除
                        monthList.remove(position1);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog1.setNegativeButton("取消",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog1,int which){

                    }
                });
                dialog1.show();
                //返回true则点击不会被监听到
                return true;
            }
        });
    }
    private void initMonth(){

            Month yi = new Month("一月",R.mipmap.image_yi);
            monthList.add(yi);
            Month er = new Month("二月",R.mipmap.image_er);
            monthList.add(er);
            Month san = new Month("三月",R.mipmap.image_san);
            monthList.add(san);
            Month si = new Month("四月",R.mipmap.image_si);
            monthList.add(si);
            Month wu = new Month("五月",R.mipmap.image_wu);
            monthList.add(wu);
            Month liu = new Month("六月",R.mipmap.image_liu);
            monthList.add(liu);
            Month qi = new Month("七月",R.mipmap.image_qi);
            monthList.add(qi);
            Month ba = new Month("八月",R.mipmap.image_ba);
            monthList.add(ba);
            Month jiu = new Month("九月",R.mipmap.image_jiu);
            monthList.add(jiu);
            Month shi = new Month("十月",R.mipmap.image_shi);
            monthList.add(shi);
            Month shiyi = new Month("十一月",R.mipmap.image_shiyi);
            monthList.add(shiyi);
            Month shier = new Month("十二月",R.mipmap.image_shier);
            monthList.add(shier);
    }
}
