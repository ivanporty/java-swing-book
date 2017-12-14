// SimpleComboBoxes.java
// Создание простых раскрывающихся списков
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleComboBoxes extends JFrame {
  // массив с элементами списка
  public String[] elements = new String[] {
      "Обаятельный", "Умный", "Нежный", "Сильный"
  };
  public SimpleComboBoxes() {
    super("SimpleComboBoxes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создадим пару раскрывающихся списков
    JComboBox combo1 = new JComboBox(elements);
    // задаем прототип элемента списка
    combo1.setPrototypeDisplayValue("Длинный элемент");
    // второй раскрывающийся список
    Vector<String> data = new Vector<String>();
    for (int i=0; i<10; i++)
      data.add("Элемент №: " + i);
    JComboBox combo2 = new JComboBox(data);
    // сделаем его редактируемым
    combo2.setEditable(true);
    combo2.setMaximumRowCount(6);
    // добавим списки и выведем окно на экран
    setLayout(new FlowLayout());
    add(combo1);
    add(combo2);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleComboBoxes(); } });
  }
}
