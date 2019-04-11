package com.nnxy.funactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.nnxy.adapter.AccountAdapter;
import com.nnxy.application.MyApplication;
import com.nnxy.dbmanager.CommomUtils;
import com.nnxy.entity.Account;
import com.nnxy.litianfu.day1.R;

import java.util.List;

public class deleteAccount_Activity extends AppCompatActivity {
    private CommomUtils commomUtils;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account_);
        listView=findViewById(R.id.select_delete_listview1);


        commomUtils = MyApplication.getCommomUtils();
        List<Account> accounts = commomUtils.queryAllAccount(MyApplication.getUserId());
        AccountAdapter adapter = new AccountAdapter(this,R.layout.delete_account_layout,accounts);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.select_account_layout,str);
        listView.setAdapter(adapter);




    }

    public void btu_quxiao(View view){
        Toast.makeText(getApplicationContext(),"取消操作",Toast.LENGTH_LONG).show();

    }

    public void btu_shanchuzhangwu(View view){
        Toast.makeText(getApplicationContext(),"删除操作",Toast.LENGTH_LONG).show();

    }

}
