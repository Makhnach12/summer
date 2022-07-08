import org.junit.jupiter.api.Test;
import ru.ac.uniyar.mf.makhno.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {
    @Test
    void createNode(){
        Node node = new Node("Корень");
        assertEquals("Корень", node.getName());
    }

    @Test
    void addNode(){
        Node root = new Node("Корень");
        Node child = new Node("Лист");
        root.add(child);
        assertEquals(1, root.getChildren().size());
        assertEquals("Лист", root.getChildren().get(0).getName());
    }

    @Test
    void deleteNode(){
        Node root1 = new Node("Корень");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        Node child3 = new Node("Лист3");
        root1.add(child1);
        root1.add(child2);
        root1.add(child3);

        Node root2 = new Node("Корень");
        root2.add(child1);
        root2.add(child2);

        root1.deleteNode(child3.id);
        assertEquals(root1.children, root2.children);
    }

    @Test
    void write_tree(){
        Node root1 = new Node("Корень");
        Node child1 = new Node("Лист1");
        root1.add(child1);
        String actual = root1.toString();
        String expected = "Корень\n\tЛист1\n";
        assertEquals(expected, actual);
    }

    @Test
    void write_tree_to_file() throws IOException {
        Node root1 = new Node("Корень");
        Node child1 = new Node("Лист1");
        root1.add(child1);
        String actual = root1.toString();
        String path = "/home/user/Рабочий стол/gg/yy.txt";
        Files.write(Paths.get(path), actual.getBytes());
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        String expected = new String (bytes);
        assertEquals(expected, actual);
    }
}

//home/user/Рабочий стол/gg/yy.txt