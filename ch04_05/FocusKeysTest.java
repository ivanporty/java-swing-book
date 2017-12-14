// FocusKeysTest.java
// Настройка клавиш перехода фокуса ввода
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class FocusKeysTest extends JFrame {
  public FocusKeysTest() {
    super("FocusKeysTest");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавляем пару кнопок
    setLayout(new FlowLayout());
    // особая кнопка
    JButton button = new JButton("Особая");
    add(button);
    add(new JButton("Обычная"));
    // настроим клавиши перехода фокуса
    HashSet<AWTKeyStroke> set = new HashSet<AWTKeyStroke>();
    set.add(AWTKeyStroke.getAWTKeyStroke(
        'Q', KeyEvent.CTRL_MASK));
    button.setFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set);
    // выводим окно на экран
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FocusKeysTest(); } });
  }
}
