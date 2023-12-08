package com.akhalikov.calculator;


import java.util.*;
import java.util.stream.IntStream;

public class UniversalCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение: ");

        String input = scanner.nextLine();

        String calc = calc(input);
        System.out.println(calc);
    }

    public static String calc(String input) {

        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException("Некорректный формат выражения");
        }

        String strNum1 = tokens[0];
        String strNum2 = tokens[2];
        String operation = tokens[1];

        int num1, num2;

        if (isRomanNumeral(strNum1) && isRomanNumeral(strNum2)) {
            num1 = convertRomanToDecimal(strNum1);
            num2 = convertRomanToDecimal(strNum2);

        } else if (isArabicNumeral(strNum1) && isArabicNumeral(strNum2)) {
            num1 = Integer.parseInt(strNum1);
            num2 = Integer.parseInt(strNum2);

        } else {
            throw new RuntimeException("Оба числа не Арабские и не Римские");

        }
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }
        int result = calculate(num1, num2, operation);
        if (isRomanNumeral(strNum1) && isRomanNumeral(strNum2)) {

            if (result > 0) {
                return convertDecimalToRoman(result);
            }
            throw new IllegalArgumentException("Римские числа не могут быть отрицательными");

        } else {

            return String.valueOf(result);
        }

    }

    private static boolean isRomanNumeral(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != 'I' && c != 'V' && c != 'X' && c != 'L' && c != 'C' && c != 'D' && c != 'M') {
                return false;
            }
        }
        return true;
    }

    private static boolean isArabicNumeral(String input) {

        for (int i = 0; i < input.length(); i++) {
            int b = input.charAt(i);
            if (b != '1' && b != '2' && b != '3' && b != '4' && b != '5' && b != '6' && b != '7' && b != '8' && b != '9' && b != '0')
                return false;
        }
        return true;
    }

    private static int convertRomanToDecimal(String input) {
        int result = 0;
        String[] romanSymbols = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < romanSymbols.length; i++) {
            if (romanSymbols[i].equals(input)) {
                result = i + 1;
            }
        }
        if (result == 0)
            throw new RuntimeException("Некорректное римское число");

        return result;
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

    private static String convertDecimalToRoman(int decimal) {

        String[] romanSymbols = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        return romanSymbols[decimal];

    }
}












