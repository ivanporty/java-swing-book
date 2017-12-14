// SimpleTrees.java
// Создание самых простых деревьев
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleTrees extends JFrame {
  public SimpleTrees() {
    super("SimpleTrees");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создание дерева на основе массива
    Object[] data = new Object[] { "Первый", "Второй",
        "Третий", new String[] { "Чей-то потомок",
            "Еще потомок" }
    };
    JTree tree1 = new JTree(data);
    // дерево на основе вектора
    Vector<String> vector = new Vector<String>();
    for (int i=0; i<5; i++) vector.add("Лист № " + i);
    JTree tree2 = new JTree(vector);
    // дерево на основе таблицы
    Hashtable<String,String> table =
        new Hashtable<String,String>();
    table.put("Одна", "пара");
    table.put("Еще одна", "тоже пара");
    JTree tree3 = new JTree(table);
    // можно включить показ корня дерева
    tree3.setRootVisible(true);
    // добавим деревья одно за одним
    setLayout(new FlowLayout());
    add(tree1);
    add(tree2);
    add(tree3);
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);

  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTrees(); } });
  }
}