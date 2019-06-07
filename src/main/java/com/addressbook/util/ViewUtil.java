package com.addressbook.util;


public class ViewUtil {
    //定义常量

    //
    public static final String CANCEL = "取消";
    
    //数据库连接信息
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/addressbook";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    //Person Information
    public static final String PERSON_ID = "ID";
    public static final String PERSON_NAME = "姓名";
    public static final String PERSON_SEX = "性别";
    public static final String PERSON_PHONE = "手机号";
    public static final String PERSON_HOME = "座机";
    public static final String PERSON_ADDRESS = "地址";
    public static final String PERSON_BIRTHDAY = "生日";
    public static final String PERSON_USER_GROUP = "所属组";
    public static final String PERSON_EMAIL = "邮箱";
    public static final String PERSON_COMPANY = "公司";
    public static final String PERSON_NICKNAME = "昵称";
    public static final String PERSON_NOTE = "备注";

    //Main View
    public static final String MAINVIEW_TITLE = "通讯录";
    public static final String MAINVIEW_PAGENUM_JLABEL_DI = "第 ";
    public static final String MAINVIEW_PAGENUM_JLABEL_PAGE = "/99 页";
    public static final String MAINVIEW_FIND_JLABEL = "查询结果";
    public static final String MAINVIEW_BUTTON_FIRST = "首页";
    public static final String MAINVIEW_BUTTON_PRE = "上一页";
    public static final String MAINVIEW_BUTTON_LAST = "末页";
    public static final String MAINVIEW_BUTTON_NEXT = "下一页";
    public static final String MAINVIEW_FIND_CONDITION = "";
    public static final String MAINVIEW_BUTTON_FIND = "查找";
    public static final String MAINVIEW_BUTTON_ADD = "添加";
    public static final String MAINVIEW_BUTTON_UPDATE = "更新";
    public static final String MAINVIEW_BUTTON_DELETE = "删除";

    //login view, register view
    public static final String LOGINVIEW_TITLE = "登录界面";
    public static final String LOGINVIEW_USERNAME = "用户名";
    public static final String LOGINVIEW_PASSWORD = "密码";
    public static final String LOGINVIEW_BUTTON_LOGIN = "登录";
    public static final String LOGINVIEW_BUTTON_RESET = "重置";
    public static final String LOGINVIEW_BUTTON_REGISTER = "注册";
    public static final String REGISTER_TITLE = "注册界面";
    public static final String REGISTER_USERNAME = "用户名";
    public static final String REGISTER_PASSWORD = "密码";
    public static final String REGISTER_BUTTON_REGISTER = "注册";
    public static final String REGISTER_BUTTON_RESET = "重置";
    
    //update and add
    public static final String FAMILY = "家人";
    public static final String CLASSMATE = "同学";
    public static final String FRIEND = "朋友";
    public static final String OTHER = "其他";
    public static final String IMPORTANT_PERSON = "重要人士";
    public static final String COLLEAGUE = "同事";
    public static final String NAME_TIPS = "5-10个英文字符或2-4个中文汉字，不能重复";
    public static final String PHONE_TIPS = "11位手机号码，不能重复";
    public static final String HOME_TIPS = "格式 XXX-XXXXXXX";
    public static final String BIRTHDAY_TIPS = "格式 XXXX-XX-XX";
    public static final String EMAIL_TIPS = "格式为 XXXX-XX-XX";
    
    
    //Update view 
    
    

//    public static QueryRunner getRunner() {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        try {
//            dataSource.setDriverClass("com.mysql.jdbc.Driver");
//            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/addressbook");
//            dataSource.setUser("root");
//            dataSource.setPassword("root");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return new QueryRunner(dataSource);
//    }
}
