// FrameClosing.java
// Использование окна с рамкой
import javax.swing.*;

public class FrameClosing extends JFrame {
  public FrameClosing() {
    super("Заголовок Окна");
    // операция при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // значок для окна
    setIconImage(getToolkit().getImage("icon.gif"));
    // вывод на экран
    setSize(300, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new FrameClosing(); } });
  }
}