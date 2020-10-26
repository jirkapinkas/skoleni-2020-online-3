package com.test.fun;

import com.test.fun.pojo.Dog;

import java.util.ArrayList;
import java.util.List;

public class Main_6_ParallelStream {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(List.of(
                new Dog("Jarda", "Kokrspanel", 11),
                new Dog("Honza", "Pitbul", 8),
                new Dog("Martin", "Civava", 12),
                new Dog("Prymula", "Jezevcik", 15),
                new Dog("Jirka", "Stafford", 2),
                new Dog("Likvidator", "Vlcak", 16),
                new Dog("Hafik", "Smeska", 22)
        ));

        // NEPOUZIVAT (POKUD NEVITE CO DELATE)!!!
        dogs.parallelStream()
                .map(Dog::getName)
                .forEach(System.out::println);

        // https://stackoverflow.com/questions/21163108/custom-thread-pool-in-java-8-parallel-stream

    }

}
