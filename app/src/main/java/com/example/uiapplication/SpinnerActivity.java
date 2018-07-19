package com.example.uiapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner spinner,spinner2,spinner3;
    private TextView textView2;
    private String[] first = new String[] {"汉语系","土木系","自动化"};
    private String[][] second = new String[][] {{"大一","大二","大三"},
            {"大一","大二","大三","大四"},{"大一","大二","大三","大四","大五"}};
    private String[][][] third= new String[][][] {{{"1601","1602","1603"},{"1506","1502","1511"},{"1401","1406"}},
            {{"1601","1602"},{"1506","1511"},{"1401","1455","1406"},{"1302","1311"}},
                    {{"1603"},{"1701","1702","1703"},{""},{"1402","1432"},{"1302","1316","1346"}}};

    private ArrayAdapter<String> firstAdapter; //第一列的适配器
    private ArrayAdapter<String> secondtAdapter;//第二列的适配器
    private ArrayAdapter<String> thirdAdapter;//第三列的适配器

    private int position1 = 0,position2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinnerlayout);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        textView2 = (TextView)findViewById(R.id.textView2);

        firstAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,first);
        spinner.setAdapter(firstAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                secondtAdapter = new ArrayAdapter<String>(SpinnerActivity.this,android.R.layout.simple_list_item_1,second[position]);
                spinner2.setAdapter(secondtAdapter);
                position1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                thirdAdapter = new ArrayAdapter<String>(SpinnerActivity.this,android.R.layout.simple_list_item_1,third[position1][position]);
                spinner3.setAdapter(thirdAdapter);
                textView2.setText(first[position1]+" "+second[position1][position]);
                position2 = position;
                if(third[position1][position2][0].length() == 0){
                    spinner3.setVisibility(View.INVISIBLE);
                }else {
                    spinner3.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView2.setText(first[position1]+" "+second[position1][position2]+
                        " "+third[position1][position2][position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
