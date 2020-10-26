package com.test.fun;

interface I1 {
    // neresitelny problem i pred Java 8
//    int test();

    // neresitelny problem od Java 8
//    default int test() {
//        return 0;
//    }

    // resitelny problem od Java 8
    default int test() {
        return 1;
    }

    // neresitelny problem od Java 8!!! (problem by nebyl, kdyby byla metoda test() private a nikoli default)!!!
    default void callTest() {
        int stuff = test();
        System.out.println("this should return 1: " + stuff);
    }
}

interface I2 {
    // neresitelny problem i pred Java 8
//    void test();

    // neresitelny problem od Java 8
//    default void test() {
//    }

    // resitelny problem od Java 8
    default int test() {
        return 2;
    }
}

interface I3 extends I1, I2 {

    // reseni problemu: @Override
    @Override
    default int test() {
        return 0;
//        return I1.super.test();
    }
}

class C implements I3 {

}

public class Main_1_Default {

    public static void main(String[] args) {
        C c = new C();
        c.callTest();
    }

}
