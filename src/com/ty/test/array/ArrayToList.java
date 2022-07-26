package com.ty.test.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        ArrayToList arrayToList = new ArrayToList();
        arrayToList.testArrayCastToListError();
    }

    private void testArrayCastToListError() {
        String[] strArray = new String[2];
        List list = Arrays.asList(strArray);//1
        //对转换后的list插入一条数据
        ArrayList<String> list1 = new ArrayList<>(list);//2
        ArrayList<String> list2 = new ArrayList<>(strArray.length);
        Collections.addAll(list2, strArray);//3
        list2.add("1");
        System.out.println(list2);
    }

    private void printAverage(double... num){
        System.out.println(num);
    }
}
