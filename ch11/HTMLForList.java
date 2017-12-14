// HTMLForList.java
// Использование стандартного объекта
// DefaultListCellRenderer
import javax.swing.*;
import java.awt.*;

public class HTMLForList {
  // данные списка
  private static Object[] data = {
      "<html><font size=4 color=red>Первый",
      new ImageIcon("bullet.gif"),
      "<html><h2><font color=yellow>Большой"
  };
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // создаем список
            JList list = new JList(data);
            // помещаем его в окно
            JFrame frame = new JFrame("HTMLForList");
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}