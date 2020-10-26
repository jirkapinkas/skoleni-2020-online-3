package com.test.fun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main_11_Files {

    public static void main(String[] args) throws IOException {
        try(Stream<String> lines = Files.lines(Path.of("pom.xml"))) {
            lines.forEach(System.out::println);
        }
    }

}
