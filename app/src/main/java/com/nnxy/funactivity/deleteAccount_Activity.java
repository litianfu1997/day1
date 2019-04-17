package com.nnxy.funactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nnxy.adapter.AccountAdapter;
import com.nnxy.application.MyApplication;
import com.nnxy.dbmanager.CommomUtils;
import com.nnxy.entity.Account;
import com.nnxy.litianfu.day1.Login_Activity;
import com.nnxy.litianfu.day1.R;

import java.util.List;

public class deleteAccount_Activity extends AppCompatActivity {
    private CommomUtils commomUtils;
    private ListView listView;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account_);
        listView=findViewById(R.id.select_delete_listview1);

        editText= findViewById(R.id.shanchuZWid);
        commomUtils = MyApplication.getCommomUtils();
        List<Account> accounts = commomUtils.queryAllAccount(MyApplication.getUserId());
        AccountAdapter adapter = new AccountAdapter(this,R.layout.delete_account_layout,accounts);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.select_account_layout,str);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    new AlertDialog.Builder(deleteAccount_Activity.this).
                    setTitle("您确定删除吗？").
                    setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                             Account account = (Account) listView.getItemAtPosition(position);
                             long id1 = account.getAcc_id();
                            commomUtils.deleteAccount(id1);
                            Toast.makeText(getApplicationContext(),"删除成功",Toast.LENGTH_SHORT).show();
                        }
                    }).
                    setNegativeButton("取消",null).show();
            }
        });

    }



    public void btu_quxiao(View view){
        finish();
        Intent intent = new Intent(deleteAccount_Activity.this,Login_Activity.class);
        startActivity(intent);
    }

    public void btu_shanchuzhangwu(View view){
        if (editText.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"编号不能为空",Toast.LENGTH_LONG).show();
        }else {
            commomUtils.deleteAccount(Long.parseLong(editText.getText().toString()));
            Toast.makeText(getApplicationContext(),"删除成功",Toast.LENGTH_LONG).show();
        }

    }

}
