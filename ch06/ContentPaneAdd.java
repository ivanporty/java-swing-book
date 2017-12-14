// ContentPaneAdd.java
// Замена панели содержимого
import javax.swing.*;
import java.awt.*;

public class ContentPaneAdd extends JFrame {
  public ContentPaneAdd() {
    super("ContentPaneAdd");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создадим панель с двумя кнопками
    JPanel contents = new JPanel();
    contents.add(new JButton("Один"));
    contents.add(new JButton("Два"));
    // заменим панель содержимого
    setContentPane(contents);
    // выведем окно на экран
    setSize(200, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ContentPaneAdd(); } });
  }
}
