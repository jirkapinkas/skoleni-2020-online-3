package com.test.fun;

import com.test.fun.pojo.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main_8_Collectors {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(List.of(
                new Dog("Jarda", "Pitbul", 11),
                new Dog("Hafik", "Pitbul", 8),
                new Dog("Martin", "Civava", 12),
                new Dog("Prymula", "Vlcak", 15),
                new Dog("Jirka", "Vlcak", 2),
                new Dog("Likvidator", "Vlcak", 16),
                new Dog("Hafik", "Civava", 22)
        ));

        Map<String, Dog> map1 = dogs.stream()
                .collect(Collectors.toMap(Dog::getName, Function.identity(), (dog1, dog2) -> dog1));
//        Map<String, Dog> map2 = dogs.stream()
//                .collect(Collectors.toMap(Dog::getName, e -> e));

        // POZOR! joining() collector se da aplikovat POUZE NA STRINGY!!!
        String races = dogs.stream()
                .map(Dog::getRace)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(races);
    }

}
