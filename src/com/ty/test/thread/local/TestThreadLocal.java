package com.ty.test.thread.local;

import java.util.Random;

/**
 * @author sm2886
 */
public class TestThreadLocal {

    static ThreadLocal<Student> threadLocal = new ThreadLocal<Student>();
    static final int SIZE = 3;

    public static void main(String[] args) {

        for (int i = 0; i < SIZE; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Student student = new Student();
                    student.setAge(new Random().nextInt() + "");
                    student.setName("曹操");
                    System.out.println("t:\t"+Thread.currentThread().getName() + "\t" + student.getName() + "\t\t" + student.getAge());
                    threadLocal.set(student);
                    new A().get();
                    new B().get();
                }
            }) {
            }.start();

        }
    }

    static class A {
        public void get() {

//            Student st = threadLocal.get();
            Student st=Student.getInstance();

            System.out.println("A:\t"+Thread.currentThread().getName() + "\t" + st.getName() + "\t" + st.getAge());

        }
    }

    static class B {
        public void get() {

            //副本变量保持一致
//            Student st = threadLocal.get();
            //单例模式保证无修改
            Student st=Student.getInstance();
            System.out.println("B:\t"+Thread.currentThread().getName() + "\t" + st.getName() + "\t" + st.getAge());
        }
    }

}
