package com.addressbook.util;

public class CheckUtil {

    public static boolean checkUsername(String username){
        String usernameRegex = "[a-zA-Z]{5,10}";
        String usernameRegex2 = "^[\\u4e00-\\u9fa5]{2,4}$";
        if (username.matches(usernameRegex) || username.matches(usernameRegex2)){
            return true;
        }
        return false;
    }

    public static boolean checkPassword(String password){
        String passwordRegex = "\\w{6,12}";
        if (password.matches(passwordRegex)){
            return true;
        }
        return false;
    }

    public static boolean checkPhone(String phone){
        String phoneRegex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        if (phone.matches(phoneRegex)){
            return true;
        }
        return false;
    }

    public static boolean checkHome(String home){
        String homeRegex = "^0\\d{2,3}-?\\d{7,8}$";
        if (home.matches(homeRegex)){
            return true;
        }
        return false;
    }

    public static boolean checkBirthday(String birthday){
        String birthdayRegex = "^\\d{4}-\\d{1,2}-\\d{1,2}";
        if (birthday.matches(birthdayRegex)){
            return true;
        }
        return false;
    }

    public static boolean checkEmail(String email){
        String emailRegex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        if (email.matches(emailRegex)){
            return true;
        }
        return false;
    }

}
