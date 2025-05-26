package exampleclass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CarInfoTest {

    @Test
    void testConstructorAndGetters() {
        CarInfo car = new CarInfo(2020, "Toyota");
        assertEquals(2020, car.getYear());
        assertEquals("Toyota", car.getBrand());
    }

    @Test
    void testSetYear() {
        CarInfo car = new CarInfo(2010, "Honda");
        car.setYear(2022);
        assertEquals(2022, car.getYear());
    }

    @Test
    void testSetBrand() {
        CarInfo car = new CarInfo(2015, "Ford");
        car.setBrand("BMW");
        assertEquals("BMW", car.getBrand());
    }

    @Test
    void testPrintInfo() {
        CarInfo car = new CarInfo(2018, "Audi");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        car.print_info();
        System.setOut(originalOut);
        assertTrue(outContent.toString().contains("year: 2018, brand: Audi."));
    }

    @Test
    void testSettersAndGettersTogether() {
        CarInfo car = new CarInfo(2000, "Mazda");
        car.setYear(2023);
        car.setBrand("Tesla");
        assertEquals(2023, car.getYear());
        assertEquals("Tesla", car.getBrand());
    }

    @Test
    void testPrintInfoWithDifferentValues() {
        CarInfo car = new CarInfo(1999, "Nissan");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        car.print_info();
        System.setOut(originalOut);
        assertEquals("year: 1999, brand: Nissan." + System.lineSeparator(), outContent.toString());
    }
}
