package com.nnxy.litianfu.day1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nnxy.application.MyApplication;
import com.nnxy.dbmanager.CommomUtils;
import com.nnxy.entity.User;

public class Register_Activity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText pwd,rpwd;
    private User zc_user;
    private CommomUtils registerUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        registerUser=MyApplication.getCommomUtils();
        //Log.i("MainActivity","context is _______>>>> "+Register_Activity.this);
        button=findViewById(R.id.btn_Register_1);
        pwd=findViewById(R.id.Reg_mima);
        rpwd=findViewById(R.id.Reg_querenmima);
        textView=findViewById(R.id.Reg_usernama);




    }
    public void Register_NewUser(View view){
        zc_user=new User();
        zc_user.setUsername(textView.getText().toString());
        zc_user.setPassword(pwd.getText().toString());
        String username = textView.getText().toString();
        if (!(pwd.getText().toString().equals(rpwd.getText().toString()))){
            Toast.makeText(getApplicationContext(), "两次密码不一致，请重新输入！", Toast.LENGTH_LONG).show();

        }else if(textView.getText().toString()==null||textView.getText().toString().equals(""))   {
            Toast.makeText(getApplicationContext(), "用户名不能为空！", Toast.LENGTH_LONG).show();
        } else if(pwd.getText().toString()==null||pwd.getText().toString().equals(""))   {
            Toast.makeText(getApplicationContext(), "密码不能为空！", Toast.LENGTH_LONG).show();
        } else {
            if (registerUser.queryUser(username).isEmpty()) {//避免重复注册
                registerUser.insertUser(zc_user);
                Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Register_Activity.this, MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(), "注册失败,用户名已存在！", Toast.LENGTH_LONG).show();
            }

        }
    }






}
