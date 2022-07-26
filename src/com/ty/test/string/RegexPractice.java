package com.ty.test.string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sm2886
 */
public class RegexPractice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            String email = in.nextLine();
            System.out.println(checkEmail(email));
        }
    }


//    public static boolean isMobileNO(String mobiles) {
//        try {
//            Pattern p = Pattern.compile("(13[0-9]|14[57]|15[012356789]|18[02356789])\\d{8}");
//            Matcher m = p.matcher(mobiles);
//            return m.matches();
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public static boolean checkEmail(String email) {
        try {
            String check = "([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            return matcher.matches();
        } catch (Exception e) {
            return false;
        }
    }
}
