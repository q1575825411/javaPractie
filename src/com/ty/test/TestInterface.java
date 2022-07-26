package com.ty.test;

public class TestInterface {
    public static void main(String[] args) {
        Dog dog = new Dog("jam",17);
        dog.eat();
        dog.run();
    }
}

interface Animal {
    public void eat();
    public void run();
    public int getAge();
}

class Dog implements Animal {

    private int age;
    private String name;

    public  Dog(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void eat() {
        System.out.println(name + " eat");
    }

    @Override
    public void run() {
        System.out.println(name + " run");
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
