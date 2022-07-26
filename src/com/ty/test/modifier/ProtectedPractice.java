package com.ty.test.modifier;

class C_two extends C_one {

}

public class ProtectedPractice {
    public static void main(String[] args) {
        C_two c_two = new C_two();
        c_two.f1();
    }

}
