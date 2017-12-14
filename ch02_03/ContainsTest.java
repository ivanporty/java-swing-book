// ContainsTest.java
// »зменение поведени€ мыши и метод contains()

import javax.swing.*;
import java.awt.*;

public class ContainsTest extends JFrame {
  public ContainsTest() {
    super("ContainsTest");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим кнопку и переопределим метод
    JButton button = new JButton("Ќевидима") {
      @Override
      public boolean contains(int x, int y) {
        // не содержим ни одной точки
        return false;
      }
    };
    // настроим панель содержимого и выведем окно на экран
    setLayout(new FlowLayout());
    add(button);
    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new ContainsTest();
          }
        });
  }
}