package com.akhalikov.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniversalCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<Character, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);


        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();


        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException("Некорректный формат выражения");
        }

        String strNum1 = tokens[0];
        String strNum2 = tokens[2];
        String operation = tokens[1];


        int num1, num2;
        if (isRomanNumeral(strNum1) && isRomanNumeral(strNum2)) {
            num1 = convertRomanToDecimal(strNum1, romanNumerals);
            num2 = convertRomanToDecimal(strNum2, romanNumerals);
        } else {
            num1 = Integer.parseInt(strNum1);
            num2 = Integer.parseInt(strNum2);


            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10");
            }
        }


        int result = 0;
        try {
            result = Integer.parseInt(String.valueOf(calculate(num1, num2, operation)));
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректная операция");
            return;
        }
        if (isRomanNumeral(strNum1) && isRomanNumeral(strNum2)) {
            String romanResult = convertDecimalToRoman(result, romanNumerals);
            System.out.println("Результат: " + romanResult);
        } else {
            System.out.println("Результат: " + result);


        }
    }


    private static boolean isRomanNumeral(String input) {
        return input.matches("[IVXLCDM]+");
    }


    private static int convertRomanToDecimal(String input, Map<Character, Integer> romanNumerals) {
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentNumeral = input.charAt(i);


            if (!romanNumerals.containsKey(currentNumeral)) {
                throw new IllegalArgumentException("Некорректная римская цифра: " + currentNumeral);
            }

            int currentValue = romanNumerals.get(currentNumeral);


            if (i + 1 < input.length()) {
                char nextNumeral = input.charAt(i + 1);
                int nextValue = romanNumerals.get(nextNumeral);

                if (nextValue > currentValue) {
                    result -= currentValue;
                } else {
                    result += currentValue;
                }
            } else {
                result += currentValue;
            }
        }

        return result;
    }


    private static String convertDecimalToRoman(int input, Map<Character, Integer> romanNumerals) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : romanNumerals.entrySet()) {
            char numeral = entry.getKey();
            int value = entry.getValue();

            while (input >= value) {
                result.append(numeral);
                input -= value;
            }
        }

        return result.toString();
    }

    private static int calculate(int num1, int num2, String operation) {
        int result;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Некорректная операция");
        }

        return result;
    }
}






