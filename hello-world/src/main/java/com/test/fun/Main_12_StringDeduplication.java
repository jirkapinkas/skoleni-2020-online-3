package com.test.fun;

public class Main_12_StringDeduplication {

    public static void main(String[] args) {
        String s1 = "test";
        String s2 = new String("test");
        String s3 = "test";
        String s4 = new String("test");

        System.out.println(s1 == s2); // false
        System.out.println(s1 == s3); // true
    }

}
