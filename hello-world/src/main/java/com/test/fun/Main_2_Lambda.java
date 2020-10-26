package com.test.fun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main_2_Lambda {

    public static void main(String[] args) throws IOException {
        List.of(1,2,3)
                .stream()
                .map(i -> String.valueOf(i))
                .forEach(s -> System.out.println(s));

        Files.walk(Paths.get("."))
                // tohle neeee!!!!
//                .map(path -> {
//                    try {
//                        return Files.size(path);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
                .map(path -> getSize(path)) // vyreseni vyjimky
                .forEach(x -> System.out.println(x));

        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        // pred Java 8 ... zadny problem :-)
        {
            int counter = 0;
            for (Integer integer : integers) {
                if (counter % 1_000 == 0) {
                    System.out.println("processed: " + (counter * 100 / integers.size()) + "%");
                }
                // todo process item
                counter++;
            }
        }
        // od Java 8 ... tohle fungovat nebude
//        {
//            int counter = 0;
//            integers.forEach(integer -> {
//                        if (counter % 1_000 == 0) {
//                            System.out.println("processed: " + (counter * 100 / integers.size()) + "%");
//                        }
//                        // todo process item
//                        counter++;
//                    });
//        }
        // od Java 8 ... fungovat bude, ale IMHO to neni spravne reseni
//        {
//            AtomicInteger counter = new AtomicInteger(0);
//            integers.forEach(integer -> {
//                if (counter.get() % 1_000 == 0) {
//                    System.out.println("processed: " + (counter.get() * 100 / integers.size()) + "%");
//                }
//                // todo process item
//                counter.incrementAndGet();
//            });
//        }
        // od Java 8
        {
            Counter counter = new Counter();
            integers.forEach(integer -> {
                        if (counter.get() % 1_000 == 0) {
                            System.out.println("processed: " + (counter.get() * 100 / integers.size()) + "%");
                        }
                        // todo process item
                        counter.inc();
                    });
        }
    }

    public static class Counter {
        private int count;
        public void inc() {
            count++;
        }
        public int get() {
            return count;
        }
    }

    public static long getSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
