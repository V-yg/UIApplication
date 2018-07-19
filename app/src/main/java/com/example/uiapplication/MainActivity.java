package com.example.uiapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1;
    private Button button1,button2,button3,button10;
    private ImageView imageView1;
    private CheckBox checkBox;
    private int[] images ={R.mipmap.image_1,R.mipmap.image_2,R.mipmap.image_3,R.mipmap.image_yi
            ,R.mipmap.image_er,R.mipmap.image_san,R.mipmap.image_si,R.mipmap.image_wu,R.mipmap.image_liu
            ,R.mipmap.image_qi,R.mipmap.image_ba,R.mipmap.image_jiu};
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.editText1);
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button10 = (Button)findViewById(R.id.button10);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button10.setOnClickListener(this);
        checkBox.setOnClickListener(this);
        editText1.setCursorVisible(false);//设置光标不可见
        //针对editText的输入进行监听
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            //文本发生变化前调用的方法
            //start :开始的位置  count :被改变的原来内容的个数   after:改变后内容的个数
            //s:改变之前的内容，通常start和count组合，可以在s中读取本次改变字段中被改变的内容after表示改变后内容的个数
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //文本发生变化时调用的方法
            //count:新增加的数量
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //文本发生变化后调用的方法
            //s:表示最终内容
            @Override
            public void afterTextChanged(Editable s) {
                if(editText1.length() == 3){
                    Toast.makeText(MainActivity.this,"输入了3位",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                String input = editText1.getText().toString();
                Toast.makeText(MainActivity.this,input,Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent1);
                break;
           case R.id.button2:
               position++;
               if(position >= images.length){
                   position = 0;
               }
               imageView1.setImageResource(images[position]);
               break;
            case R.id.button3:
                Intent intent2 = new Intent(MainActivity.this,ChoiceActivity.class);
                startActivity(intent2);
                break;
            case R.id.button10:
                Intent intent3 = new Intent(MainActivity.this,SpinnerActivity.class);
                startActivity(intent3);
                break;
            case R.id.checkBox:
                if(checkBox.isChecked()){
                    //显示明文
                    editText1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    //显示密文
                    editText1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                //使光标置于字符末尾
                editText1.setSelection(editText1.getText().length());
                break;

        }

    }
}
