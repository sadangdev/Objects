package com.objects.example.chapter02;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal amount = BigDecimal.valueOf(10000);
        Money money = new Money(amount);
        System.out.println(money);

        System.out.println();
    }
}
