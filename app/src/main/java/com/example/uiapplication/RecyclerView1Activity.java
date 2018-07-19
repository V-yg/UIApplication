package com.example.uiapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView1Activity extends AppCompatActivity {

    private List<Week> weekList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview1_layout);
        initWeek();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        WeekAdapter1 adapter = new WeekAdapter1(weekList);
        recyclerView.setAdapter(adapter);
    }

    private void initWeek(){

        Week yi = new Week("星期一",R.mipmap.image_yi);
        weekList.add(yi);
        Week er = new Week("星期二",R.mipmap.image_er);
        weekList.add(er);
        Week san = new Week("星期三",R.mipmap.image_san);
        weekList.add(san);
        Week si = new Week("星期四",R.mipmap.image_si);
        weekList.add(si);
        Week wu = new Week("星期五",R.mipmap.image_wu);
        weekList.add(wu);
        Week liu = new Week("星期六",R.mipmap.image_liu);
        weekList.add(liu);
        Week qi = new Week("星期日",R.mipmap.image_qi);
        weekList.add(qi);

    }
}
