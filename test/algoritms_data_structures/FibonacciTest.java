package algoritms_data_structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jyodroid on 1/14/17.
 */
public class FibonacciTest {

    @Test
    public void fibonacciTest() {
        //Arrange
        int n = 35;
        long startTime = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci();

        //Act
        long number = fibonacci.fibonacci(n);
        System.out.printf("Recursive fibonacci time: %d\n", System.currentTimeMillis() - startTime);

        //Assert
        assertEquals(14930352L, number);
    }

    @Test
    public void memoriedFibonacciTest() {
        //Arrange
        int n = 170;
        long startTime = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci();

        //Act
        long number = fibonacci.memoriedFibonacci(n, new long[n]);
        System.out.printf("Recursive memoried fibonacci time: %d\n", System.currentTimeMillis() - startTime);

        //Assert
        assertEquals(1812812405337582786L, number);
    }

    @Test
    public void fibonacciDPTest() {
        //Arrange
        int n = 170;
        long startTime = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci();

        //Act
        long number = fibonacci.fibonacciDP(n);
        System.out.printf("DP fibonacci time: %d\n", System.currentTimeMillis() - startTime);

        //Assert
        assertEquals(1812812405337582786L, number);
    }
}
