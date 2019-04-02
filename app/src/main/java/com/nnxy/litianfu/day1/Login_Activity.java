package com.nnxy.litianfu.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nnxy.funactivity.AddAccount_Activity;
import com.nnxy.funactivity.deleteAccount_Activity;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }
    /***
     * 添加账务按钮
     * @param view
     */
    public void addAccount(View view){
        Intent intent =new Intent(Login_Activity.this,AddAccount_Activity.class);
        startActivity(intent);
    }

    /***
     * 删除账务按钮
     * @param view
     */
    public void deleteAccount(View view){
        Intent intent =new Intent(Login_Activity.this,deleteAccount_Activity.class);
        startActivity(intent);
    }

    /***
     * 更新账务按钮
     * @param view
     */
    public void updateAccount(View view){

    }

    /***
     * 查找账务按钮
     * @param view
     */
    public void selectAccount(View view){

    }

    /***
     * 账务统计按钮
     * @param view
     */
    public void accountStatistics(View view){

    }

    /***
     * 用户管理按钮
     * @param view
     */
    public void userManager(View view){

    }

    /***
     * 系统设置按钮
     * @param view
     */
    public void systemSetting(View view){

    }

    /***
     * 注销按钮
     * @param view
     */
    public void logOut(View view){

    }


}
