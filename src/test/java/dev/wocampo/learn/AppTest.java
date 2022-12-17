package dev.wocampo.learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void dummy_test() {
        // Expected
        final double expected = 100;
        // Execute and get result
        double result = 50 + 50;
        // Comparative: Expected vs Result
        assertEquals(expected, result);
    }
}
