package com.nnxy.litianfu.dao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {
    public static void main(String[] args) throws Exception {
        // 这里控制版本号和生成orm java文件的包
        Schema schema = new Schema(1, "com.nnxy.entity");
        addNews(schema);
        schema.setDefaultJavaPackageDao("com.nnxy.dao");
        // 这里指定产生orm java文件所在路径
        new DaoGenerator().generateAll(schema, "/Users/litianfu/AndroidStudioProjects/day1/app/src/main/java");
    }
    private static void addNews(Schema schema) {
        Entity user_Entity = schema.addEntity("User");
        user_Entity.addLongProperty("user_id").primaryKey();
        user_Entity.addStringProperty("username").notNull();
        user_Entity.addStringProperty("password").notNull();


        Entity acc_Entity =schema.addEntity("Account");
        acc_Entity.addLongProperty("acc_id").primaryKey();//主键
        acc_Entity.addStringProperty("address").notNull();//地址
        acc_Entity.addStringProperty("date").notNull();//日期
        acc_Entity.addDoubleProperty("money").notNull();//金额
        acc_Entity.addStringProperty("zw_leibie").notNull();//收入或支出
        acc_Entity.addStringProperty("leibie").notNull();
        acc_Entity.addStringProperty("note").notNull();//备注

//        Property userProperty= user_Entity.addLongProperty("acc_id").getProperty();
//
//        user_Entity.addToOne(acc_Entity,userProperty);

        Property accProperty =acc_Entity.addLongProperty("user_id").getProperty();

        acc_Entity.addToOne(user_Entity,accProperty);




    }
}
