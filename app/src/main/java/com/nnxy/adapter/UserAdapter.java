package com.nnxy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nnxy.entity.Account;
import com.nnxy.entity.User;
import com.nnxy.litianfu.day1.R;

import java.util.List;

public class UserAdapter extends ArrayAdapter {
    private final int resourceId;

    public UserAdapter(Context context, int textViewId, List<User> obj){
        super(context,textViewId,obj);
        this.resourceId = textViewId;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
