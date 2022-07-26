package com.ty.test.modifiers;

import com.ty.test.modifier.C_one;

class C_three extends C_one {

}

public class ProtectedPractice_two extends C_one {
    public static void main(String[] args) {

        ProtectedPractice_two protectedPractice_two = new ProtectedPractice_two();
        protectedPractice_two.f1();

        C_one c_one = new C_one();
    }
}
