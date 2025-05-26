package exampleclass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorsTest {

    @Test
    void testToString() {
        // 编写测试用例来验证toString方法的输出
        Calculators calc = new Calculators();
        String expected = "This is a calculator class made by KE";
        Assertions.assertEquals(expected,calc.toString(),"toString method should return the expected string");
    }

    @Test
    void testAdd() {
        Calculators calc2 = new Calculators();
        int expected = 10;
        int actual = calc2.add(2,2,2,2,2);
        Assertions.assertEquals(expected, actual, "The add method should return the sum of the numbers");
    }

    @Test
    void testSubMultiDiV() {
        Calculators calc3 = new Calculators();
        int expectedSub = 2;
        int expectedMulti = 6;
        Assertions.assertAll("Multi Check",
        () -> Assertions.assertEquals(expectedSub,calc3.sub(5,3),"Should return 2"),
        () -> Assertions.assertEquals(expectedMulti,calc3.multi(2,3),"Should return 6"),
        () -> Assertions.assertThrows(ArithmeticException.class,() -> calc3.div(5,0),"Should throw ArithmeticException when dividing by zero")
        );
    }

}