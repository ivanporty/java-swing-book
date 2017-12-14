// HeadersAndCorners.java
// Заголовки и "уголки" панели прокрутки JScrollPane
import javax.swing.*;
import java.awt.*;

public class HeadersAndCorners extends JFrame {
  // надпись с большим изображением
  private JLabel label = new JLabel(
      new ImageIcon("image.jpg"));
  public HeadersAndCorners() {
    super("HeadersAndCorners");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем панель прокрутки
    JScrollPane scroll = new JScrollPane(label);
    // устанавливаем заголовки
    scroll.setColumnHeaderView(new XHeader());
    scroll.setRowHeaderView(new YHeader());
    // устанавливаем левый верхний "уголок"
    scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER,
        new JButton(new ImageIcon("Print16.gif")));
    // выводим окно на экран
    add(scroll);
    setSize(400, 300);
    setVisible(true);
  }
  // заголовок по оси X
  class XHeader extends JPanel {
    // размер заголовка
    public Dimension getPreferredSize() {
      return new Dimension(
          label.getPreferredSize().width, 20);
    }
    // прорисовываем линейку
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int width = getWidth();
      for (int i=0; i<width; i+=50) {
        g.drawString("" + i, i, 15);
      }
    }
  }
  // заголовок по оси Y
  class YHeader extends JPanel {
    // размер заголовка
    public Dimension getPreferredSize() {
      return new Dimension(
          20, label.getPreferredSize().height);
    }
    // прорисовываем линейку
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int height = getHeight();
      for (int i=0; i<height; i+=50) {
        g.drawString("" + i, 0, i);
      }
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HeadersAndCorners(); } });
  }
}
