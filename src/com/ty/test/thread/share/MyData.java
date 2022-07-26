package com.ty.test.thread.share;

import com.sun.source.tree.TryTree;

import java.io.IOException;

/**
 * @author sm2886
 */
public class MyData {
    private int j = 0;

    public synchronized void add() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        j++;
        System.out.println("线程" + Thread.currentThread().getName() + "的值为" + getJ());
    }

    public synchronized void dec() {
        j--;
        System.out.println("线程" + Thread.currentThread().getName() + "的值为" + getJ());
    }

    public int getJ() {
        return j;
    }


    public synchronized void fun1() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1+");
    }

    public synchronized void fun2() {
        System.out.println("2+");
    }
}
