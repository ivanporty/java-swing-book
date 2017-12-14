// FocusPolicyTest.java
// Различные алгоритмы передачи фокуса ввода
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusPolicyTest extends JFrame {
  public FocusPolicyTest() {
    super("FocusPolicyTest");
    // при закрытии окна выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавляем три кнопки
    add(new JButton("Левая"), "West");
    // добавляем эту кнопку второй, но она будет ниже
    // двух других кнопок
    JButton button = new JButton("Сменить");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // при нажатии сменим алгоритм для окна
        setFocusTraversalPolicy(
            new ContainerOrderFocusTraversalPolicy());
      }
    });
    add(button, "South");
    add(new JButton("Правая"), "East");
    // выводим окно на экран
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FocusPolicyTest(); } });
  }
}
