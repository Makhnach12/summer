import org.junit.jupiter.api.Test;
import ru.ac.uniyar.mf.makhno.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void addition(){
        String actual = Main.calculate(1,"1", "+", "1");
        assertEquals("2", actual);
    }

    @Test
    void multiplication(){
        String actual = Main.calculate(1,"1", "*", "1");
        assertEquals("1", actual);
    }

    @Test
    void division(){
        String actual = Main.calculate(1,"1", "/", "0");
        assertEquals("Деление на 0", actual);
    }

    @Test
    void frac_plus(){
        String actual = Main.calculate(2,"1/2", "+", "1/2");
        assertEquals("1/1", actual);
    }

    @Test
    void frac_div_0(){
        String actual = Main.calculate(2,"1/0", "+", "1/2");
        assertEquals("Нет решений", actual);
    }

}
