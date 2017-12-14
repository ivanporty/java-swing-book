// SimpleMDI.java
// Демонстрация внутренних окон Swing
import javax.swing.*;

public class SimpleMDI extends JFrame {
  public SimpleMDI() {
    super("SimpleMDI");
    setSize(400, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем рабочий стол Swing
    JDesktopPane desktopPane = new JDesktopPane();
    // добавляем его в центр окна
    add(desktopPane);
    // создаем несколько внутренних окон
    JInternalFrame frame1 =
        new JInternalFrame("Окно 1", true);
    JInternalFrame frame2 =
        new JInternalFrame("Окно 2", true, true, true, true);
    JInternalFrame frame3 =
        new JInternalFrame("Палитра", false, true);
    // смена типа окна на "палитру"
    frame3.putClientProperty("JInternalFrame.isPalette", true);
    // добавляем внутренние окна на рабочий стол
    desktopPane.add(frame1);
    desktopPane.add(frame2);
    desktopPane.add(frame3);
    // задаем размеры и расположения, делаем окна видимыми
    frame1.setSize(200, 100);
    frame1.setLocation(80, 100); frame1.setVisible(true);
    frame2.setSize(200, 60); frame2.setVisible(true);
    frame3.setSize(100, 200); frame3.setVisible(true);
    // выводим окно на экран
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleMDI(); } });
  }
}