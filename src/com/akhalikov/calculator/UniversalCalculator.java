package com.akhalikov.calculator;

import java.util.Scanner;

public class UniversalCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input);
        checkInput(input);
        String[] values = input.split(" ");
        System.out.println(values);
        if (values.length != 3) {
            System.out.println("Неверное количество аргументов");
        }
        String operator = values[1];

    }

    private static void checkInput(String input) {
        if (input.isEmpty()) {
            System.out.println("Строка пустая");
        } else {
            System.out.println("Строка не пустая");
        }
    }

    private static void checkOperator(String operator) {
        if (operator.equals("+")) {
            System.out.println("Сложение");
        } else if (operator.equals("-")) {
            System.out.println("Вычитание");
        } else if (operator.equals("*")) {
            System.out.println("Умножение");
        } else if (operator.equals("/")) {
            System.out.println("Деление");
        } else {
            System.out.println("Неверное выражение");
        }
    }
}
