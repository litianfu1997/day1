package com.nnxy.litianfu.day1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nnxy.dbmanager.UserUtils;
import com.nnxy.entity.User;

public class Register_Activity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText pwd,rpwd;
    private User zc_user;
    private UserUtils userUtils_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        userUtils_reg =new UserUtils(this);

        button=findViewById(R.id.btn_Register_1);
        pwd=findViewById(R.id.mima);
        rpwd=findViewById(R.id.querenmima);
        textView=findViewById(R.id.zhanghu);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zc_user=new User();
                zc_user.setUsername(textView.getText().toString());
                zc_user.setPassword(pwd.getText().toString());
                if (!(pwd.getText().toString().equals(rpwd.getText().toString()))){
                    Toast.makeText(getApplicationContext(), "两次密码不一致，请重新输入！", Toast.LENGTH_LONG).show();

                }else if(textView.getText().toString()==null||textView.getText().toString().equals(""))   {
                    Toast.makeText(getApplicationContext(), "用户名不能为空！", Toast.LENGTH_LONG).show();
                } else if(pwd.getText().toString()==null||pwd.getText().toString().equals(""))   {
                    Toast.makeText(getApplicationContext(), "密码不能为空！", Toast.LENGTH_LONG).show();
                } else {
                    if (userUtils_reg.insertUser(zc_user)) {
                        Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Register_Activity.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "注册失败", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}
