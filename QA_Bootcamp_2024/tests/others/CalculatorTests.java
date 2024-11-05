package others;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

    Calculator c;

    @BeforeAll
    public static void classSetup() {
        System.out.println("Preparing all the tests from the class.");
    }

    @BeforeEach
    public void testSetup() {
        System.out.println("The method runs before each test!");
        c = new Calculator();
    }

    @Test
    public void testAddition01() {
        double result = c.compute(3,4 , "+");
        assertEquals(7, result,"Addition fail");
    }

    @Test
    public void testAddition02() {
        Assertions.assertEquals(14.5, c.compute(10, 4.5, "+") , "Addition fail");
    }

    @Test
    public void testInvalidOperator() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            c.compute(5, 7, "ABC");
        }, "Operator not valid!");
    }

    @Test
    public void testDivisionByZero() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            c.compute(5, 0, "/");
        }, "Operator not valid!");
    }

    @Test
    public void testSubtraction01() {
        Assertions.assertEquals(10, c.compute(5, -5, "-"), "Subtraction failed.");
    }

    @Test
    public void testMultiplication01() {
        Assertions.assertEquals(14, c.compute(7, 2,"*"), "Multiplication failed.");
    }

    @Test
    public void testSquareRoot01() {
        Assertions.assertEquals(8, c.compute(64, 0, "SQRT"), "SQRT failed.");
    }

    @Test
    public void testSquareRoot02(){
        Assertions.assertEquals(Math.sqrt(2), c.compute(2, 0, "SQRT"), "SQRT failed.");
    }

    @Test
    public void testLargeNumberAddition() {
        double largeNum = Double.MAX_VALUE;
        double result = c.compute(largeNum, 1, "+");
        assertEquals(Double.POSITIVE_INFINITY, result, "Addition of large numbers failed.");
    }

    @Test
    public void testNegativeAddition() {
        double result = c.compute(-5, -10, "+");
        assertEquals(-15, result, "Negative addition failed.");
    }

    @Test
    public void testNegativeSubtraction() {
        double result = c.compute(-5, -10, "-");
        assertEquals(5, result, "Negative subtraction failed.");
    }

    @Test
    public void testNegativeMultiplication() {
        double result = c.compute(-5, 10, "*");
        assertEquals(-50, result, "Negative multiplication failed.");
    }

    @Test
    public void testNegativeSquareRoot() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.compute(-9, 0, "SQRT");
        }, "Expected an IllegalArgumentException for square root of a negative number.");
    }
    @AfterEach
    public void cleanTest() {
        System.out.println("Cleanup after the test.");
    }

    @AfterAll
    public static void cleanClass(){
        System.out.println("Cleanup at the end.");
    }

}
