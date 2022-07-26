package com.ty.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sm2886
 */
public class Practice {
    static Pattern pattern;
    public static void main(String[] args) {
        String str1 = "http://www.mysite.com/category/231";
        pattern = Pattern.compile("^https?://.*$");
        Matcher matcher = pattern.matcher(str1);
        System.out.println("str1 is match with pattern ? " + matcher.matches());
    }

}
