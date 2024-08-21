package org.example.programms.junit_test;

import example.programms.junit_test.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() { // метод подготовки (setup), будет выполнен перед каждым тестом, создавая новый объект Calculator.
        calculator = new Calculator();
    }
    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 должно быть равно 5");
    }
    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 должно быть равно 1");
    }
    @Test
    public void testMultiply() {
        assertEquals(4, calculator.multiply(2,2));
    }
    @Test
    public void testDivide() {
        assertEquals(2, calculator.subtract(4,2));
    }
    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0),
                "Деление на ноль должно выбрасывать ArithmeticException");
    }
    @Test
    public void factorial() {
        assertEquals(6, calculator.factorial(3));
    }
    @Test
    public void factorialZero() {
        assertEquals(1, calculator.factorial(0));
    }
}
