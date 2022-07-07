import org.testng.annotations.Test;
import ru.ac.uniyar.mf.makhno.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TreeTest {

    @Test
    void createNode(){
        Node node = new Node("Корень");
        assertEquals("Корень", node.getName());
    }


}
