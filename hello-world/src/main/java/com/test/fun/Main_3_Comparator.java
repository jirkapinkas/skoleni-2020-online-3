package com.test.fun;

import com.test.fun.pojo.Dog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_3_Comparator {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(List.of(
                new Dog("Jarda", "Civava", 11),
                new Dog("Honza", "Pitbul", 8),
                new Dog("Martin", "Civava", 12),
                new Dog("Prymula", "Civava", 15),
                new Dog("Jirka", "Vlcak", 2),
                new Dog("Likvidator", "Vlcak", 16),
                new Dog("Hafik", "Vlcak", 22)
        ));

        // do Java 8
//        Collections.sort(dogs, comparator);
        // od Java 8
//        dogs.sort(comparator);

        dogs.stream()
                .sorted(Comparator.comparing(Dog::getRace).thenComparing(Dog::getName))
                .forEach(System.out::println);
    }

}
