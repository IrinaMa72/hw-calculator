package com.example.hwcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;


import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceImplParametrizedTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();


    public static Stream<Arguments> plusParams() {
        return Stream.of(
                Arguments.of(2, 2, TestUtils.stringResult(2, 2, "4", "+")),
                Arguments.of(0, 8, TestUtils.stringResult(0, 8, "8", "+")),
                Arguments.of(1, 1, TestUtils.stringResult(1, 1, "2", "+"))
        );
    }

    @ParameterizedTest
    @MethodSource("plusParams")
    void plus(int num1, int num2, String expectedResult) {
        String actualResult = calculatorService.plus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }
    public static Stream<Arguments> minusParams() {
        return Stream.of(
                Arguments.of(2, 2, TestUtils.stringResult(2, 2, "0", "-")),
                Arguments.of(0, 8, TestUtils.stringResult(0, 8, "-8", "-")),
                Arguments.of(1, 1, TestUtils.stringResult(1, 1, "0", "-"))
        );
    }

    @ParameterizedTest
    @MethodSource("minusParams")
    void minus(int num1, int num2, String expectedResult) {
        String actualResult = calculatorService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }
    public static Stream<Arguments> multiplyParams() {
        return Stream.of(
                Arguments.of(2, 2, TestUtils.stringResult(2, 2, "4", "*")),
                Arguments.of(0, 8, TestUtils.stringResult(0, 8, "0", "*")),
                Arguments.of(1, 1, TestUtils.stringResult(1, 1, "1", "*"))
        );
    }

    @ParameterizedTest
    @MethodSource("multiplyParams")
    void multiply(int num1, int num2, String expectedResult) {
        String actualResult = calculatorService.multiply(num1, num2);
        assertEquals(expectedResult, actualResult);
    }
    public static Stream<Arguments> divideParams() {
        return Stream.of(
                Arguments.of(2, 2, TestUtils.stringResult(2, 2, "1.0", ":")),
                Arguments.of(0, 8, TestUtils.stringResult(0, 8, "0.0", ":")),
                Arguments.of(4, 8, TestUtils.stringResult(4, 8, "0.5", ":"))
        );
    }

    @ParameterizedTest
    @MethodSource("divideParams")
    void divide(int num1, int num2, String expectedResult) {
        String actualResult = calculatorService.divide(num1, num2);
        assertEquals(expectedResult, actualResult);
    }
}
