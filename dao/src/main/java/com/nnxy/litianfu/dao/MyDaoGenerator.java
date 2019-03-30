package com.nnxy.litianfu.dao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
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
        user_Entity.addIdProperty();
        user_Entity.addStringProperty("username").notNull();
        user_Entity.addStringProperty("password").notNull();




    }
}
