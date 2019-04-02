package com.nnxy.dbmanager;

import android.content.Context;


import com.nnxy.dao.UserDao;
import com.nnxy.entity.Account;
import com.nnxy.entity.User;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

public class CommomUtils {
    private  DaoManager manager;


    public CommomUtils(Context context){
        this.manager=DaoManager.getInstance();
        this.manager.init(context);
    }

    /***
     * 关闭数据库
     */
    public void close(){
        manager.claoseConnection();
    }

    /**
     * 增加用户
     * */
    public  boolean insertUser(User user){
        boolean flag = false;
       flag = manager.getDaoSession().insert(user) != -1 ? true : false;

        return flag;

    }
    /**
     * 增加账务
     * */
    public  boolean insertAccount(Account account){
        boolean flag = false;
        flag = manager.getDaoSession().insert(account) != -1 ? true : false;

        return flag;

    }

    /***
     * 查询
     * @return
     */
    public List<User> queryAllUser(){//查询全部
        return manager.getDaoSession().loadAll(User.class);
    }
    public List<User> queryUser(String username){
        return  manager.getDaoSession().queryBuilder(User.class).where(UserDao.Properties.Username.eq(username)).list();
    }
    public List<User> queryUserId(String username){

        return  manager.getDaoSession().queryBuilder(User.class).where(UserDao.Properties.Username.eq(username)).list();
    }
    public List<User> queryUser(String username,String password){
        QueryBuilder queryBuilder=manager.getDaoSession().queryBuilder(User.class);
        queryBuilder.where(UserDao.Properties.Username.eq(username),UserDao.Properties.Password.eq(password));
        return  queryBuilder.list();
    }
}