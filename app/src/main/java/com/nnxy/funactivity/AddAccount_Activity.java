package com.nnxy.funactivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nnxy.application.MyApplication;
import com.nnxy.dbmanager.CommomUtils;
import com.nnxy.entity.Account;
import com.nnxy.litianfu.day1.R;

import java.util.Calendar;


public class AddAccount_Activity extends AppCompatActivity {
    private Account account;
    private Calendar calendar;
    private int mYear,mMonth,mDay;


    private Spinner output_LeiBie = null;

    private Spinner leiBie = null;
    private String[][] leiieData = new String[][]{{"工资", "捡钱", "金融", "其他"},
            {"购物", "吃饭", "出行", "其他"}};
    private ArrayAdapter<CharSequence> adapterArea = null;

    private CommomUtils accountUtils;

    private EditText money,date,address,note;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account_);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.output_LeiBie =  super.findViewById(R.id.zhangwu_leibie);
        this.leiBie =  super.findViewById(R.id.leibie);
        this.output_LeiBie.setOnItemSelectedListener(new OnItemSelectedListenerImp());

        accountUtils=MyApplication.getCommomUtils();

        money=findViewById(R.id.acc_money);
        date=findViewById(R.id.acc_date);
        address=findViewById(R.id.acc_address);
        note=findViewById(R.id.acc_note);

        calendar=Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //日历控件
                new DatePickerDialog(AddAccount_Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        mYear = year;
                        mMonth = month;
                        mDay = day;
                        date.setText(new StringBuilder()
                        .append(mYear).append("-").append((mMonth+1) < 10 ? "0"+(mMonth+1):(mMonth+1)).append("-").append((mDay<10)?"0"+mDay:mDay));
                    }
                },calendar.get(Calendar.YEAR)
                  ,calendar.get(Calendar.MONTH)
                ,calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    public void insertAccount(View view) {
        account = new Account();
        account.setUser_id(MyApplication.getUserId());
        account.setMoney(Integer.parseInt(money.getText().toString()));
        account.setDate(date.getText().toString());
        account.setAddress(address.getText().toString());
        account.setZw_leibie(output_LeiBie.getSelectedItem().toString());
        account.setLeibie(leiBie.getSelectedItem().toString());
        account.setNote(note.getText().toString());
        if (money.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"金额不能为空",Toast.LENGTH_LONG).show();
        }else if (date.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"日期不能为空",Toast.LENGTH_LONG).show();
        }else if (address.getText().toString().trim().equals("")){
            Toast.makeText(getApplicationContext(),"地址不能为空",Toast.LENGTH_LONG).show();
        }else {
            if (accountUtils.insertAccount(account)){//插入账务

                Toast.makeText(getApplicationContext(),"插入成功",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(),"插入失败",Toast.LENGTH_LONG).show();
            }
        }




    }

    private class OnItemSelectedListenerImp implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int position, long id) {
            // 得到选择的选项
            AddAccount_Activity.this.adapterArea = new ArrayAdapter<CharSequence>(
                    AddAccount_Activity.this, android.R.layout.simple_spinner_item,
                    AddAccount_Activity.this.leiieData[position]);
            AddAccount_Activity.this.adapterArea
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            AddAccount_Activity.this.leiBie.setAdapter(AddAccount_Activity.this.adapterArea);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }
}
