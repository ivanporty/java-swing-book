// SimpleLists.java
// Простейший способ создания списков
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleLists extends JFrame {
  // данные для списков
  private String[] data1 = { "Один", "Два",
      "Три", "Четыре", "Пять"};
  private String[] data2 = { "Просто", "Легко",
      "Элементарно", "Как дважды два"};
  public SimpleLists() {
    super("SimpleLists");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем списки
    JList list1 = new JList(data1);
    // для второго списка используем вектор
    Vector<String> data = new Vector<String>();
    data.addAll(Arrays.asList(data2));
    JList list2 = new JList(data);
    // динамически наполним вектор
    Vector<String> big = new Vector<String>();
    for (int i=0; i<50; i++) {
      big.add("# " + i);
    }
    JList bigList = new JList(big);
    bigList.setPrototypeCellValue("12345");
    // добавим списки в панель
    setLayout(new FlowLayout());
    add(list1);
    add(list2);
    add(new JScrollPane(bigList));
    // выведем окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleLists(); } });
  }
}