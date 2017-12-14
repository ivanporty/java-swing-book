// ImageList.java
// Список, используюший новый рисующий объект
import javax.swing.*;
import com.porty.swing.*;

import java.awt.*;

public class ImageList {
  // данные списка
  private static Icon bullet = new ImageIcon("bullet.gif");
  private static Object[] data = {
      new ImageListElement(bullet, "Первый"),
      new ImageListElement(bullet, "Второй"),
      new ImageListElement(bullet,
          "<html><h4><font color=green>И третий!")
  };
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // создаем список и настраиваем его
            JList list = new JList(data);
            list.setCellRenderer(new ImageListCellRenderer());
            // добавляем в окно
            JFrame frame = new JFrame("ImageList");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
