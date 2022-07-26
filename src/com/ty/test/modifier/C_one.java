package com.ty.test.modifier;

public class C_one {
    protected int a = 0;
    private int b = 0;
    public int c = 0;

    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }

    protected void f1() {
        System.out.println("protected f1 used");
    }
}
