package dev.wocampo.learn;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
    private Calculator calculator;
    @Mock
    private CalculatorOnAzure calculatorOnAzure;

    @BeforeAll
    public static void setUp() {
        System.out.println("CalculatorTest has been initialized...");
    }

    @BeforeEach
    public void init() {
        // calculator = new Calculator(UtilMock.calculatorOnAzure());
        calculator = new Calculator(calculatorOnAzure);
    }

    @Test
    @DisplayName(value = "This method test if two numbers are added correctly")
    public void add() {
        assertEquals(100.00, calculator.add(50, 50));
    }

    @Test
    public void subtract() {
        assertEquals(10.00, calculator.subtract(60, 50));
    }

    @Test
    public void multiply() {
        assertEquals(100.00, calculator.multiply(10.00, 10.00));
    }

    @Test
    @Disabled(value = "This [split] test was ignored because isn't done yet")
    public void split() {
        assertEquals(12.00, calculator.split(60, 5.0));
    }

    @Test
    @DisplayName(value = "This test handle an exception expected")
    public void handle_exception_thrown() {
        assertThrows(ArithmeticException.class, () -> {
            var result = 100 / 0;
        });
    }

    @Test
    @DisplayName(value = "This test handle multiple assertions")
    public void handle_multiple_assertions() {
        // if only single assertion fail then the test fail
        final int[] numbers = {1, 2, 3, 4, 5};
        assertAll("Handle multiple assertions",
                () -> { assertEquals(5, calculator.multiply(5, numbers[0])); },
                () -> { assertEquals(10, calculator.multiply(5, numbers[1])); },
                () -> { assertEquals(15, calculator.multiply(5, numbers[2])); },
                () -> { assertEquals(20, calculator.multiply(5, numbers[3])); },
                () -> { assertEquals(25, calculator.multiply(5, numbers[4])); }
        );
    }

    @Test
    @DisplayName(value = "This test is handle with other inner dependency")
    public void handle_test_with_dependency() {
        when(calculator.addOnAzure(33, 33)).thenReturn(66.0);
        assertEquals(66, calculator.addOnAzure(33, 33));
    }
}
