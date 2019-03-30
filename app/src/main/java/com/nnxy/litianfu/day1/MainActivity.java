package com.nnxy.litianfu.day1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.nnxy.dbmanager.UserUtils;
import com.nnxy.entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //1.声明组件
    private Button btn_Login;
    private Button btn_Register;
    private EditText username;
    private EditText password;
    private UserUtils userUtils;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userUtils=new UserUtils(this);


        //2.找到布局的button控件
        btn_Login = findViewById(R.id.btn_Login);//获得登录按钮
        btn_Register = findViewById(R.id.btn_Register);//获得注册按钮
        username=findViewById(R.id.zhanghu);
        password=findViewById(R.id.mima);

        //3.设置点击监听
        btn_Login.setOnClickListener(new View.OnClickListener() {//new View.OnClickListener()
            @Override
            public void onClick(View v) {

                String user=username.getText().toString().trim();
                String pwd =password.getText().toString().trim();
                if (!(userUtils.queryUser(user).isEmpty())){//先判断用户存在
                    if (!(userUtils.queryUser(user,pwd).isEmpty())){//密码正确
                        Intent intent =new Intent(MainActivity.this,Login_Activity.class);
                        Toast.makeText(getApplicationContext(),"登陆成功！",Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"密码错误，请重新输入！",Toast.LENGTH_LONG).show();

                    }
                }else {
                    Toast.makeText(getApplicationContext(),"用户不存在，请先注册！",Toast.LENGTH_LONG).show();
                }



//                user=new User();
//                user.setUsername(username.getText().toString());
//                user.setPassword(password.getText().toString());



//                List<User> users=userUtils.queryAllUser();
//                Log.i("MainActivity", users.toString());


//                //从MainActivity跳转到Login_Activity
//                Intent intent =new Intent(MainActivity.this,Login_Activity.class);
//                //实例化Bundle对象用来装数据
//                Bundle bundle =new Bundle();
//                //将数据以键值对的形式存入Bundle对象
//                bundle.putString("user",username.getText().toString());
//                bundle.putString("pwd",password.getText().toString());
//                //将Bundle对象传递给Intent
//                intent.putExtras(bundle);
//                //启动另一个Activity页面
//                startActivity(intent);
//                String user = username.getText().toString();
//                String pwd = password.getText().toString();
//                Toast.makeText(getApplicationContext(),"用户名："+user+"密码："+pwd,Toast.LENGTH_LONG).show();


            }
        });
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从MainActivity跳转到Register_Activity
                Intent intent =new Intent(MainActivity.this,Register_Activity.class);
                startActivity(intent);
            }
        });
    }
}
