package com.nnxy.funactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nnxy.litianfu.day1.R;


public class AddAccount_Activity extends AppCompatActivity {


    // 城市
    private Spinner output_LeiBie = null;
    // 城市下边的子成区
    private Spinner leiBie = null;
    private String[][] leiieData = new String[][] { { "工资", "捡钱", "金融", "其他" },
            { "购物", "吃饭", "出行" ,"其他"} };
    private ArrayAdapter<CharSequence> adapterArea = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account_);
        this.output_LeiBie =  super.findViewById(R.id.zhangwu_leibie);
        this.leiBie =  super.findViewById(R.id.leibie);
        this.output_LeiBie.setOnItemSelectedListener(new OnItemSelectedListenerImp());
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
