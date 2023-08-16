package com.example.hwcalculator;

import org.springframework.web.bind.annotation.ParameterizedTest;
import org.springframework.web.bind.annotation.Arguments;
import org.springframework.web.bind.annotation.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceImplParametrizedTest {

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
}