package com.test.fun;

import java.util.Objects;
import java.util.stream.Stream;

public class Main_5_MethodReference {

    public static void main(String[] args) {
        Integer[] pole = new Integer[] { 1, 2, 3, 4, 5 };
        Stream.of(pole)
//                .map(Integer::toString) // toto fungovat NEBUDE!!!
                // TOHLE VSECHNO FUNGOVAT BUDE:
//                .map(i -> i.toString())
//                .map(i -> Integer.toString(i))
//                .map(Objects::toString)
//                .map(Object::toString)
                .map(String::valueOf)
                .forEach(System.out::println);
    }

}
