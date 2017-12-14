// PaintingWithBorders.java
// Рисование компонента с учетом рамки
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class PaintingWithBorders extends JFrame {
  public PaintingWithBorders() {
    super("PaintingWithBorders");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим к нашему компоненту рамку
    CustomComponent cc = new CustomComponent();
    cc.setBorder(BorderFactory.
        createTitledBorder("Рамка!"));
    // добавим компонент в окно
    getContentPane().add(cc);
    setSize(400, 300);
    setVisible(true);
  }
  // компонент со своей собственной процедурой прорисовки
  class CustomComponent extends JComponent {
    public void paintComponent(Graphics g) {
      // получаем подходящий прямоугольник
      Rectangle rect = AbstractBorder.
          getInteriorRectangle(this, getBorder(),
              0, 0, getWidth(), getHeight());
      // рисуем в нем
      g.setColor(Color.white);
      g.fillRect(
          rect.x, rect.y, rect.width, rect.height);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new PaintingWithBorders(); } });
  }
}
