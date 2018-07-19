package com.example.uiapplication;

import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class ChoiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private CheckBox checkBox,checkBox2,checkBox3;
    private RadioButton radioButton,radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choicelayout);
        button = (Button)findViewById(R.id.button);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        radioButton = (RadioButton)findViewById(R.id.radioButton);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                StringBuffer sbf = new StringBuffer();
                if(checkBox.isChecked()){
                    sbf.append(checkBox.getText().toString()+",");
                }
                if(checkBox2.isChecked()){
                    sbf.append(checkBox2.getText().toString()+",");
                }
                if(checkBox3.isChecked()){
                    sbf.append(checkBox3.getText().toString()+",");
                }
                if(radioButton.isChecked()){
                    sbf.append("同意调剂");
                }
                if(radioButton2.isChecked()){
                    sbf.append("不同意调剂");
                }
                Toast.makeText(this,"选择的内容为："+sbf,Toast.LENGTH_SHORT).show();
                break;


        }
    }
}
