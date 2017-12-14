// DebugPainting.java
// Демонстрация возможностей отладки графики в Swing
import java.awt.*;
import javax.swing.*;

public class DebugPainting extends JFrame {
  public DebugPainting() {
    super("DebugPainting");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавляем рисующий компонент
    PaintingComponent pc = new PaintingComponent();
    add(pc);
    // включаем для него отладку графики
    RepaintManager.currentManager(pc).
        setDoubleBufferingEnabled(false);
    pc.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION
        | DebugGraphics.FLASH_OPTION);
    DebugGraphics.setFlashTime(50);
    DebugGraphics.setFlashCount(3);
    // выводим окно на экран
    setSize(200, 200);
    setVisible(true);
  }

  // компонент, который что-то рисует
  class PaintingComponent extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // три простые фигуры
      g.setColor(Color.orange);
      g.fillRect(10, 10, 100, 100);
      g.setColor(Color.green);
      g.drawOval(50, 50, 50, 50);
      g.setColor(Color.blue);
      g.fillOval(100, 20, 50, 50);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new DebugPainting(); } });
  }
}
