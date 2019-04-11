package com.nnxy.funactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.nnxy.adapter.AccountAdapter;
import com.nnxy.application.MyApplication;
import com.nnxy.dbmanager.CommomUtils;
import com.nnxy.entity.Account;
import com.nnxy.litianfu.day1.R;

import java.util.List;

public class SelectAccount_Activity extends AppCompatActivity {
    private CommomUtils commomUtils;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account_);
        listView=findViewById(R.id.select_listview);
        commomUtils = MyApplication.getCommomUtils();
        List<Account> accounts = commomUtils.queryAllAccount(MyApplication.getUserId());
        AccountAdapter adapter = new AccountAdapter(this,R.layout.select_account_layout,accounts);
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.select_account_layout,str);
        listView.setAdapter(adapter);
    }
}
