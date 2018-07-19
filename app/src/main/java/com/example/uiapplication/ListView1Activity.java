package com.example.uiapplication;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListView1Activity extends AppCompatActivity {

    private String[] data = {"一月","二月","三月","四月","五月",
            "六月","七月","八月","九月","十月","十一月","十二月"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview1layout);
        //定义适配器 ArrayAdapter  参数一为 当前活动/上下文  参数二为 ListView子项的id
        // 参数三为 传入的数据 （数组类型的）
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                ListView1Activity.this,android.R.layout.simple_list_item_1,data);

        ListView listView = (ListView)findViewById(R.id.list_view);
        //调用ListView的 setAdapte（） 将构建好的适配器对象传递进去
        listView.setAdapter(adapter);

    }

}
