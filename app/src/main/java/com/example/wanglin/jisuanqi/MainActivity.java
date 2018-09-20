package com.example.wanglin.jisuanqi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//声明控件
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_dian;

    private Button btn_jia;
    private Button btn_jian;
    private Button btn_cheng;
    private Button btn_chu;
    private Button btn_deng;

    private EditText et_num1;
    private EditText et_num2;

    private TextView tv_result;
    private String yuSuanFu;
    private EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        setTitle("计算器");

        //初始化控件
        btn_0=findViewById(R.id.btn_0);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_7=findViewById(R.id.btn_7);
        btn_8=findViewById(R.id.btn_8);
        btn_9=findViewById(R.id.btn_9);
        btn_dian=findViewById(R.id.btn_dian);

        btn_jia=findViewById(R.id.btn_jia);
        btn_jian=findViewById(R.id.btn_jian);
        btn_cheng=findViewById(R.id.btn_cheng);
        btn_chu=findViewById(R.id.btn_chu);
        btn_deng=findViewById(R.id.btn_deng);

        et_num1=findViewById(R.id.et_num1);
        et_num2=findViewById(R.id.et_num2);
        tv_result=findViewById(R.id.tv_result);


        //设置事件监听
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_dian.setOnClickListener(this);

        btn_jia.setOnClickListener(this);
        btn_jian.setOnClickListener(this);
        btn_cheng.setOnClickListener(this);
        btn_chu.setOnClickListener(this);
        btn_deng.setOnClickListener(this);


    }


    //按钮单击事件
    @Override
    public void onClick(View v) {
        int id = v.getId();//获得按钮的id
        String s = ((Button) v).getText().toString();//获得按钮上的文本
        num= new EditText(MainActivity.this);
        //判断哪个输入框有焦点,得到它保存在num对象中
        if(et_num1.hasFocus())
        {
            num=et_num1;
        }
        else
        {
            num=et_num2;
        }

        switch (id)
        {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_dian:
                if(".".equals(s))//如果现在按的是点，
                {
                    if (!num.getText().toString().contains(".")) {//判断输入框中是否已经有点
                        num.setText(num.getText().toString() + s);
                    }
                }
                else
                {
                    num.setText(num.getText().toString()+s);
                }
                break;
            case R.id.btn_jia:
            case R.id.btn_jian:
            case R.id.btn_cheng:
            case R.id.btn_chu:
                //判断是减号还是负号
                if(TextUtils.isEmpty(num.getText()) && "-".equals(s))
                {
                    if (!num.getText().toString().contains("-")) {//判断输入框中是否已经有-
                        num.setText("-");
                    }
                }
                else
                {
                    if(!TextUtils.isEmpty(et_num1.getText()))
                    {
                        et_num2.requestFocus();
                    }
                    yuSuanFu=s;
                }


                break;
            case R.id.btn_deng:
                double v1=0;
                double v2=0;
                if(!TextUtils.isEmpty(et_num1.getText()) && !TextUtils.isEmpty(et_num2.getText()))
                {
                    v1 = Double.parseDouble(et_num1.getText().toString());
                    v2 = Double.parseDouble(et_num2.getText().toString());
                }
                else
                {
                    Toast.makeText(this, "请输入操作数", Toast.LENGTH_SHORT).show();
                    return;
                }
                double result=0;
                switch (yuSuanFu)
                {
                    case "+":
                        result=v1+v2;
                        break;
                    case "-":
                        result=v1-v2;
                        break;
                    case "*":
                        result=v1*v2;
                        break;
                    case "/":
                        result=v1/v2;
                        break;
                }
                tv_result.setText(result+"");
                break;

        }

    }
}
