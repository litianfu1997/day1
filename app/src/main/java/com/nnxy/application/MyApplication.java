package com.nnxy.application;

import android.app.Application;

import com.nnxy.dbmanager.CommomUtils;
import com.nnxy.entity.User;

public class MyApplication extends Application {
    private static CommomUtils commomUtils;
    private static User user;
    private static  long userId1;
    @Override
    public void onCreate() {
        super.onCreate();
        commomUtils=new CommomUtils(getApplicationContext());

    }


    public static CommomUtils getCommomUtils() {
        return commomUtils;
    }

    public static void setUserId(long userId){
        userId1=userId;
    }

    public static long getUserId(){
        return userId1;
    }

}
