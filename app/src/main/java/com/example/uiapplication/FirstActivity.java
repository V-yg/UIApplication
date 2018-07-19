package com.example.uiapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar progressBar1,progressBar2;
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);
        progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);
        progressBar2 = (ProgressBar)findViewById(R.id.progressBar2);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button   )findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                if(progressBar1.getVisibility() == View.GONE){
                    progressBar1.setVisibility(View.VISIBLE);
                }
                else {
                  progressBar1.setVisibility(View.GONE);
                }
                int pro = progressBar2.getProgress();
                pro = pro + 10;
                progressBar2.setProgress(pro);
                break;
            case R.id.button2:
                AlertDialog.Builder dialog1 = new AlertDialog.Builder(FirstActivity.this);
                dialog1.setTitle("提示！");
                dialog1.setMessage("确定选择102区吗！");
                dialog1.setCancelable(true);
                dialog1.setPositiveButton("确定", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog1,int which){

                }
            });
                dialog1.setNegativeButton("取消",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog1,int which){

                }
            });
                dialog1.show();
                break;
            case R.id.button3:
                ProgressDialog progressDialog1 = new ProgressDialog(FirstActivity.this);
                progressDialog1.setTitle("正在获取数据...");
                progressDialog1.setMessage("Loading...");
                progressDialog1.setCancelable(true);
                progressDialog1.show();
                break;
            case R.id.button4:
                Intent intent = new Intent(FirstActivity.this,ListView1Activity.class);
                startActivity(intent);
                break;
            case R.id.button5:
                Intent intent2 = new Intent(FirstActivity.this,ListView2Activity.class);
                startActivity(intent2);
                break;
            case R.id.button6:
                Intent intent3 = new Intent(FirstActivity.this,RecyclerView1Activity.class);
                startActivity(intent3);
                break;
            case R.id.button7:
                Intent intent4 = new Intent(FirstActivity.this,RecyclerView2Activity.class);
                startActivity(intent4);
                break;
            case R.id.button8:
                Intent intent5 = new Intent(FirstActivity.this,RecyclerView3Activity.class);
                startActivity(intent5);
                break;
            case R.id.button9:
                break;
        }
    }

}
