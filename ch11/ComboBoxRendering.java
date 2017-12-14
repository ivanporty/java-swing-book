// ComboBoxRendering.java
// Отображение элементов раскрывающегося списка
import javax.swing.*;
import com.porty.swing.*;

import java.awt.*;

public class ComboBoxRendering extends JFrame {
  // данные для первого списка
  private String[] textData = { "<html><code>Первый",
      "<html><b>Жирный", "<html><font color=red>Красный",
      "<html><em>Выразительный" };
  // значки
  private ImageIcon bullet1 =
      new ImageIcon("Server16.gif");
  private ImageIcon bullet2 =
      new ImageIcon("Host16.gif");
  // данные для второго списка со значками
  private ImageListElement[] iconData = {
      new ImageListElement(bullet1, "Основной Сервер"),
      new ImageListElement(bullet1, "Дополнительный"),
      new ImageListElement(bullet2,
          "<html><b><em>Машина директора")
  };
  public ComboBoxRendering() {
    super("ComboBoxRendering");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем пару раскрывающихся списков
    JComboBox combo1 = new JComboBox(textData);
    JComboBox combo2 = new JComboBox(iconData);
    // наш специальный отображающий объект
    combo2.setRenderer(new ImageListCellRenderer());
    // добавляем списки в окно
    setLayout(new FlowLayout());
    add(combo1);
    add(combo2);
    // выводим окно на экран
    setSize(350, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ComboBoxRendering(); } });
  }
}
