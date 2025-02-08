package com.pay.tools_challange.utils;

import java.util.Random;

public class IndentifyGenerator {

    public static String sequencialCodeGenerator() {
        Random random = new Random();
        long numero = 1_000_000_000L + (long) (random.nextDouble() * 9_000_000_000L);
        return String.valueOf(numero);
    }

}
