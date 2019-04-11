package com.nnxy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nnxy.entity.Account;
import com.nnxy.litianfu.day1.R;

import java.util.List;

public class AccountAdapter extends ArrayAdapter {
    private final int resourceId;

    public AccountAdapter(Context context, int textViewId, List<Account> obj){
        super(context,textViewId,obj);
        this.resourceId = textViewId;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //1.获取Account实例，实例化view对象
        Account account = (Account) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);

        //2.通过id，获取textView
        TextView shiJianTv = view.findViewById(R.id.shijian);
        TextView diDianTv = view.findViewById(R.id.didian);
        TextView jinETv = view.findViewById(R.id.jine);
        TextView shouZhiLeiXingTv = view.findViewById(R.id.shouzhileixing);
        TextView leiXingTv = view.findViewById(R.id.leixing);
        TextView beiZhuTv = view.findViewById(R.id.beizhu);

        //3.设置你要填入的信息
        shiJianTv.setText(account.getDate());
        diDianTv.setText(account.getAddress());
        jinETv.setText(Double.toString(account.getMoney()));
        shouZhiLeiXingTv.setText(account.getZw_leibie());
        leiXingTv.setText(account.getLeibie());
        beiZhuTv.setText(account.getNote());
        return view;
    }
}
