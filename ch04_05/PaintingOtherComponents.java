// PaintingOtherComponents.java
// Прорисовка других компонентов как изображений
import javax.swing.*;
import java.awt.*;

public class PaintingOtherComponents extends JFrame {
  public PaintingOtherComponents() {
    super("PaintingOtherComponents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CustomPaintComponent());
    setSize(400, 300);
    setVisible(true);
  }
  class CustomPaintComponent extends JPanel {
    // кнопка для прорисовки
    private JButton button = new JButton("Привет!");
    // метод для рисования в Swing
    protected void paintComponent(Graphics g) {
      // необходимо вызвать для обработки свойства opaque
      super.paintComponent(g);
      // рисуем кнопки
      Graphics2D g2 = (Graphics2D) g;
      button.setSize(80, 30);
      // отключение двойной буферизации - не всегда нужно
      button.setDoubleBuffered(false);
      // переместим позицию рисования
      g2.translate(100, 100);
      for (int i=1; i<=8; i++) {
        // кручение кнопки по кругу
        g2.rotate(2*Math.PI / i);
        button.paint(g);
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new PaintingOtherComponents(); } });
  }
}
