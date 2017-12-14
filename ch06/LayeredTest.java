// LayeredTest.java
// Возможности многослойной панели
import javax.swing.*;
import java.awt.*;

public class LayeredTest extends JFrame {
  public LayeredTest() {
    super("LayeredTest");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // получаем многослойную панель
    JLayeredPane lp = getLayeredPane();
    // три фигуры
    Figure fg1 = new Figure(Color.red, 0, "POPUP");
    Figure fg2 = new Figure(Color.blue, 0, "PALETTE1");
    Figure fg3 = new Figure(Color.green, 1, "PALETTE2");
    // расположение фигур в окне
    fg1.setBounds(10, 10, 120, 120);
    fg2.setBounds(60, 80, 160, 180);
    fg3.setBounds(90, 15, 250, 180);
    // добавляем в различные слои
    lp.add(fg1, JLayeredPane.POPUP_LAYER);
    lp.add(fg2, JLayeredPane.PALETTE_LAYER);
    lp.add(fg3, JLayeredPane.PALETTE_LAYER);
    // смена позиции одной из фигур
    lp.setPosition(fg3, 0);
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  // класс, позволяющий рисовать два типа фигур с текстом
  class Figure extends JComponent {
    private Color color;
    private int type;
    private String text;
    // параметры: цвет и тип фигуры
    Figure(Color color, int type, String text) {
      this.color = color;
      this.type = type;
      this.text = text;
      setOpaque(false);
    }
    public void paintComponent(Graphics g) {
      // прорисовка фигуры
      g.setColor(color);
      switch (type) {
        case 0: g.fillOval(0, 0, 90, 90); break;
        case 1: g.fillRect(0, 0, 130, 80); break;
      }
      g.setColor(Color.white);
      g.drawString(text, 10, 35);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new LayeredTest(); } });
  }
}