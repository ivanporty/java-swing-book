// JXLayerTest.java
// Пример использования слоев JXLayer
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.BufferedLayerUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class JXLayerTest extends JFrame {
  public JXLayerTest() {
    super("JXLayerTest");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создадим простое содержимое
    JPanel p = new JPanel();
    p.add(new JTextField(10));
    p.add(new JButton("ОК"));
    // поместим содержимое в слой
    JXLayer<JPanel> layer = new JXLayer<JPanel>(p);
    // создадим слой реагирующий на события
    layer.setUI(new BufferedLayerUI<JPanel>() {
      private int lastX, lastY;
      // прорисовка слоя
      public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        g.setColor(Color.RED);
        g.fillOval(lastX, lastY, 15, 15);
      }
      // получение событий в пределах слоя
      protected void processMouseMotionEvent(MouseEvent e,
               JXLayer<? extends JPanel> layer) {
        lastX = SwingUtilities.convertMouseEvent(
            (Component) e.getSource(), e, layer).getX();
        lastY = SwingUtilities.convertMouseEvent(
            (Component) e.getSource(), e, layer).getY();
        repaint();
      }
    });
    // JXLayer необходимо добавлять в контейнер
    add(layer);
    // выведем окно на экран
    setSize(400, 150);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new JXLayerTest(); } });
  }
}