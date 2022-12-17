package dev.wocampo.learn;

public class Calculator {
    private final CalculatorOnAzure calculatorOnAzure;

    public Calculator(CalculatorOnAzure calculatorOnAzure) {
        this.calculatorOnAzure = calculatorOnAzure;
    }

    public double add(double a, double b) { return a + b; }

    public double subtract(double a, double b) { return a - b; }

    public double multiply(double a, double b) { return a * b; }

    public double split(double a, double b) { return a / b; }

    public double addOnAzure(double... numbers) {
        return calculatorOnAzure.add(numbers);
    }
}
