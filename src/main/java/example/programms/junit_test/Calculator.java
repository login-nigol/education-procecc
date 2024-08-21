package example.programms.junit_test;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        return a / b;
    }
    public int factorial(int n) {
        if (n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
}
