// RotatedUI.java
// Кручение и верчение стандартных компонентов
import javax.swing.*;
import java.awt.*;

public class RotatedUI extends JFrame {
  public RotatedUI() {
    super("RotatedUI");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавляем особую панель
    RotatingPanel rp = new RotatingPanel();
    add(rp);
    // добавляем в панель компоненты
    rp.add(new JButton("Привет!"));
    rp.add(new JTextField(20));
    // устанавливаем свой RepaintManager
    RepaintManager.setCurrentManager(
        new RotatingRepaintManager());
    // выводим окно на экран
    setSize(200, 300);
    setVisible(true);
  }
  // компонент, который поворачивает всех потомков
  class RotatingPanel extends JPanel {
    // отвечает за прорисовку потомков
    protected void paintChildren(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.translate(50, 200);
      // поворот на 45 градусов
      g2.rotate(-Math.PI/4);
      // небольшое растяжение
      g2.shear(-0.1, -0.1);
      // обычное рисование предков
      super.paintChildren(g);
    }
  }
  // особый тип RepaintManager
  class RotatingRepaintManager extends RepaintManager {
    // все запросы на перерисовку попадают сюда
    public void addDirtyRegion(JComponent c,
        int x, int y, int w, int h) {
      // ищем нужного предка
      Container parent = c;
      while (! (parent instanceof RotatingPanel)) {
        parent = parent.getParent();
        if ( parent == null ) {
          // мы не нашли нашего предка, сброс
          parent = c;
          break;
        }
      }
      // перерисовываем весь компонент полностью
      super.addDirtyRegion((JComponent) parent,
          0, 0, parent.getWidth(), parent.getHeight());
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new RotatedUI(); } });
  }
}