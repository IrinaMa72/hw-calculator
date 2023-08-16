package com.example.hwcalculator;

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String plus(int num1, int num2) {
        return stringResult(num1, num2, String.valueOf(num1 + num2), "+");
    }

    @Override
    public String minus(int num1, int num2) {

        return stringResult(num1, num2, String.valueOf(num1 - num2), "-");
    }

    @Override
    public String multiply(int num1, int num2) {
        return stringResult(num1, num2, String.valueOf(num1 * num2), "*");
    }

    @Override
    public String divide(int num1, int num2) {

        if (num2 == 0) {
            throw new IllegalStateException("На ноль делить нельзя!");
        } else {
             double result = (double) num1 / num2;
            return stringResult(num1, num2, String.valueOf(result), ":");

        }
    }

    private String stringResult(int num1, int num2, String result, String action) {
        return String.format("%s %s %s = %s", num1, action, num2, result);
    }
}
