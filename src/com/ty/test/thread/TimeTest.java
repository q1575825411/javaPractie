package com.ty.test.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sm2886
 */
public class TimeTest {

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(currentTime);
    }
}
