import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {
    Calculator calculator;

    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("test start");
    }

    @BeforeEach
    public void beforeEachMethod() {
        calculator = new Calculator();
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("test is over");
    }

    @Test
    public void testPlus() {
        int a = 1, b = 2, expected = 3;

        int result = calculator.plus.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMinus() {
        int a = 3, b = 2, expected = 1;
        int result = calculator.minus.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDevideThrow() {
        int a = 5, b = 0;
        Assertions.assertDoesNotThrow(() -> calculator.devide.apply(a, b));
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 32, 1})
    public void testMultiple(int a) {
        int b = 1;
        int result = calculator.multiply.apply(a, b);
        int expected = a;
        assertEquals(expected, result);
    }
}