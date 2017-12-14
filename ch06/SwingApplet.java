// SwingApplet.java
// Простой апплет с использованием Swing
import javax.swing.*;
import java.awt.*;

public class SwingApplet extends JApplet {
  // этот метод вызывается при создании апплета
  @Override
  public void init() {
    // создание интерфейса
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            JPanel contents = new JPanel();
            contents.add(new JTextField(10));
            contents.add(new JButton("Ввод"));
            setContentPane(contents);
        }});
  }
}