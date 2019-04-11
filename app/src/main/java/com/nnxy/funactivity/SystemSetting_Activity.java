package com.nnxy.funactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nnxy.application.MyApplication;
import com.nnxy.dbmanager.CommomUtils;
import com.nnxy.entity.User;
import com.nnxy.litianfu.day1.R;

import java.util.List;

public class SystemSetting_Activity extends AppCompatActivity {
    private EditText oldpwd,newpwd,newRpwd;
    private User user;
    private CommomUtils commomUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_setting_);
        oldpwd=findViewById(R.id.old_password);
        newpwd=findViewById(R.id.new_password);
        newRpwd=findViewById(R.id.new_repassword);

        commomUtils=MyApplication.getCommomUtils();
    }
    public void systemSetting_OK(View view){
        String old=oldpwd.getText().toString();
        String newp=newpwd.getText().toString();
        String newrp=newRpwd.getText().toString();

            if (old.equals("")||old == null){
                Toast.makeText(getApplicationContext(), "旧密码不能为空！", Toast.LENGTH_LONG).show();
            }else if (newp.equals("")||newp==null){
                Toast.makeText(getApplicationContext(), "新密码不能为空！", Toast.LENGTH_LONG).show();
            } else if (newrp.equals("")||newrp==null) {
                Toast.makeText(getApplicationContext(), "请确认新密码！", Toast.LENGTH_LONG).show();
            }else if (!(old.equals(commomUtils.queryById4Password(MyApplication.getUserId())))) {//旧密码输入失败
                Toast.makeText(getApplicationContext(),"原密码不一致，请重新输入！",Toast.LENGTH_LONG).show();
            } else if (!(newp.equals(newrp))) {
                    Toast.makeText(getApplicationContext(), "两次新密码不一致，请重新输入！", Toast.LENGTH_LONG).show();
            } else {
                    user=new User();
                    List<User> userList= commomUtils.queryUser(MyApplication.getUserId());
                    user.setUser_id(MyApplication.getUserId());
                    user.setUsername(userList.get(0).getUsername());
                    user.setPassword(newp);
                    commomUtils.updateUser(user);
                    Toast.makeText(getApplicationContext(), "修改密码成功！", Toast.LENGTH_LONG).show();
                    finish();

            }




        }




    public void systemSetting_Cancel(View view){//取消按钮
        finish();


    }
}
