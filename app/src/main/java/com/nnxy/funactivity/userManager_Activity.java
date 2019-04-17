package com.nnxy.funactivity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.nnxy.adapter.AccountAdapter;
import com.nnxy.adapter.UserAdapter;
import com.nnxy.application.MyApplication;
import com.nnxy.dbmanager.CommomUtils;
import com.nnxy.entity.Account;
import com.nnxy.entity.User;
import com.nnxy.litianfu.day1.R;

import java.util.List;

public class userManager_Activity extends AppCompatActivity {
    private CommomUtils commomUtils;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager_);
        listView=findViewById(R.id.userManager_listview);
        commomUtils = MyApplication.getCommomUtils();
        List<User> users = commomUtils.queryAllUser();
        UserAdapter adapter = new UserAdapter(this,R.layout.usermannager_layout,users);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.select_account_layout,str);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(userManager_Activity.this).
                        setTitle("您确定删除吗？").
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                User user = (User) listView.getItemAtPosition(position);
                                long id1 = user.getUser_id();
                                commomUtils.deleteUser(id1);
                                Toast.makeText(getApplicationContext(),"删除成功",Toast.LENGTH_SHORT).show();
                            }
                        }).
                        setNegativeButton("取消",null).show();
            }
        });
    }

    public void deleteUser(View view){
        EditText editText = findViewById(R.id.yonghuID);
        String id = editText.getText().toString();

        commomUtils.deleteUser(Long.parseLong(id));
        Toast.makeText(getApplicationContext(),"删除成功  "+id,Toast.LENGTH_LONG).show();
    }
}
