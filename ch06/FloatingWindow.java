// FloatingWindow.java
// ќкно без рамки, всегда остающеес€
// выше основного окна приложени€
import javax.swing.*;

public class FloatingWindow extends JFrame {
  public FloatingWindow() {
    super("FloatingWindow");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // выведем главное окно на экран
    setSize(400, 300);
    setVisible(true);
    // добавим плавающее окно
    JWindow window = new JWindow(this);
    // всегда над другими окнами
    window.setAlwaysOnTop(true);
    window.setType(Type.UTILITY);
    // выведем окно на экран
    window.setSize(100, 300);
    window.setVisible(true);

  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        public void run() { new FloatingWindow(); } });
  }
}