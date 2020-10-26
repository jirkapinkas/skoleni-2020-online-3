package com.test.fun;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class Main_7_DoubleTrouble {

    public static void main(String[] args) {
        {
            double sum = DoubleStream.of(0.1, 0.2)
                    .sum();
            System.out.println(sum); // 0.30000000000000004
        }

        {
            List<BigDecimal> bigDecimals = List.of(new BigDecimal("0.1"), new BigDecimal("0.2"));
            Optional<BigDecimal> optionalSum = bigDecimals.stream()
                    .reduce((sum, e) -> sum.add(e));
//                 .reduce(BigDecimal::add);
            System.out.println(optionalSum);
        }

    }

}
