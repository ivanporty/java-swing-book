// SwingPainting.java
// Работа рисующих механизмов Swing

import javax.swing.*;
import java.awt.*;

public class SwingPainting extends JFrame {

  public SwingPainting() {
    super("SwingPainting");
    // при закрытии окна завершаем работу
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавляем в панель содержимого наш компонент
    getContentPane().add(new SwingComponent());
    // выводим окно на экран
    setSize(200, 200);
    setVisible(true);
  }

  // компонент, использующий возможности Swing
  class SwingComponent extends JComponent {
    // прорисовка компонента
    public void paintComponent(Graphics g) {
      System.out.println("paintComponent");
      super.paintComponent(g);
      g.setColor(Color.red);
      g.fillOval(10, 10, 50, 50);
    }

    // прорисовка рамки
    public void paintBorder(Graphics g) {
      System.out.println("paintBorder");
      super.paintBorder(g);
    }

    // прорисовка потомков
    public void paintChildren(Graphics g) {
      System.out.println("paintChildren");
      super.paintChildren(g);
    }
  }

  public static void main(String[] args) {
    new SwingPainting();
  }
}
