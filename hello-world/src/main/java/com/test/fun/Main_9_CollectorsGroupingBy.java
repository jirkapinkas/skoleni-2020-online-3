package com.test.fun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_9_CollectorsGroupingBy {

    public static void main(String[] args) throws IOException {
        try (Stream<Path> stream = Files.walk(Path.of("."))) {
//            Map<Boolean, List<Path>> map = stream.collect(Collectors.groupingBy(Files::isDirectory));
//            System.out.println("adresare: " + map.get(true));
//            System.out.println("soubory:  " + map.get(false));

//            Map<Type, List<Path>> map = stream.collect
//                    (Collectors.groupingBy(path -> Files.isDirectory(path) ? Type.DIRECTORY : Type.FILE));
//            System.out.println("adresare: " + map.get(Type.DIRECTORY));
//            System.out.println("soubory:  " + map.get(Type.FILE));

//            Map<Type, List<String>> map = stream.collect
//                    (Collectors.groupingBy(path -> Files.isDirectory(path) ? Type.DIRECTORY : Type.FILE,
//                            Collectors.mapping(path -> path.toFile().getName(), Collectors.toList())));
//            System.out.println("adresare: " + map.get(Type.DIRECTORY));
//            System.out.println("soubory:  " + map.get(Type.FILE));

//            Map<Type, Long> map = stream.collect
//                    (Collectors.groupingBy(path -> Files.isDirectory(path) ? Type.DIRECTORY : Type.FILE,
//                            Collectors.mapping(path -> path.toFile().getName(), Collectors.counting())));
//            System.out.println("pocet adresaru: " + map.get(Type.DIRECTORY));
//            System.out.println("pocet souboru:  " + map.get(Type.FILE));

//            Map<Type, Long> map = stream.collect
//                    (Collectors.groupingBy(path -> Files.isDirectory(path) ? Type.DIRECTORY : Type.FILE,
//                            Collectors.mapping(path -> getSize(path), Collectors.summingLong(e -> e))));
//            System.out.println("velikost souboru:  " + map.get(Type.FILE));


            Map<Type, String> map = stream.collect
                    (Collectors.groupingBy(path -> Files.isDirectory(path) ? Type.DIRECTORY : Type.FILE,
                            Collectors.mapping(path -> path.toFile().getName(), Collectors.joining(", "))));
            System.out.println("pocet adresaru: " + map.get(Type.DIRECTORY));
            System.out.println("pocet souboru:  " + map.get(Type.FILE));
        }
    }

    enum Type {
        DIRECTORY, FILE
    }


    public static long getSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
