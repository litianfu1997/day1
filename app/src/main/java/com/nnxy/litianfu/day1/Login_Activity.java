package com.nnxy.litianfu.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity {
    private Button btn_1;
    private TextView txt_1,txt_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        btn_1=findViewById(R.id.button);
        txt_1=findViewById(R.id.textView_1);
        txt_2=findViewById(R.id.textView_2);

        //获得Intent中的Bundle对象
        Bundle bundle = this.getIntent().getExtras();
        //获得Bundle对象中的数据
        String user=bundle.getString("user");
        String pwd=bundle.getString("pwd");
        txt_1.setText(user);
        txt_2.setText(pwd);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
