package dev.wocampo.learn;

import java.util.Arrays;

public final class UtilMock {
    private UtilMock() {}

    public static CalculatorOnAzure calculatorOnAzure() {
        // Stub or mock manual
        return (double... numbers) -> Arrays.stream(numbers).sum();
    }
}
