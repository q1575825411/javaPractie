package com.ty.test.thread.local;

/**
 * @author sm2886
 */
public class Student {

    Student() {
    }

    private static ThreadLocal<Student> map = new ThreadLocal<Student>();

    public static Student getInstance() {
        if (map.get() == null) {
            map.set(new Student());
        }
        return map.get();
    }

    private String name;
    private String age;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
