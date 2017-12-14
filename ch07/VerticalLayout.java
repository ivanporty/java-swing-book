// VerticalLayout.java
// ѕростой менеджер расположени€, располагает
// компоненты в вертикальный р€д с отступами
import java.awt.*;
import javax.swing.*;

public class VerticalLayout implements LayoutManager {
  // отступ между компонентами
  public int GAP = 5;
  // сигнал расположить компоненты в контейнере
  public void layoutContainer(Container c) {
    Component comps[] = c.getComponents();
    int currentY = GAP;
    for (Component comp : comps) {
      // предпочтительный размер компонента
      Dimension pref = comp.getPreferredSize();
      // указываем положение компонента на экране
      comp.setBounds(GAP, currentY,
          pref.width, pref.height);
      // промежуток между компонентами
      currentY += GAP;
      currentY += pref.height;
    }
  }
  // эти два метода нам не понадоб€тс€
  public void addLayoutComponent(
      String name, Component comp) {
  }
  public void removeLayoutComponent(
      Component comp) {
  }
  // минимальный размер дл€ контейнера
  public Dimension minimumLayoutSize(Container c) {
    return calculateBestSize(c);
  }
  // предпочтительный размер дл€ контейнера
  public Dimension preferredLayoutSize(Container c) {
    return calculateBestSize(c);
  }

  private Dimension size = new Dimension();
  // вычисл€ет оптимальный размер контейнера
  private Dimension calculateBestSize(Container c) {
    // сначала вычислим длину контейнера
    Component[] comps = c.getComponents();
    int maxWidth = 0;
    for (Component comp : comps) {
      int width = comp.getWidth();
      // поиск компонента с максимальной длиной
      if (width > maxWidth) maxWidth = width;
    }
    // длина контейнера с учетом левого отступа
    size.width = maxWidth + GAP;
    // вычисл€ем высоту контейнера
    int height = 0;
    for (Component comp : comps) {
      height += GAP;
      height += comp.getHeight();
    }
    size.height = height;
    return size;
  }

  // проверим работу нового менеджера
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            JFrame frame = new JFrame("VerticalLayout");
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
            // панель будет использовать новое расположение
            JPanel contents = new JPanel(
                new VerticalLayout());
            // добавим пару кнопок и текстовое поле
            contents.add(new JButton("ќдин"));
            contents.add(new JButton("ƒва"));
            contents.add(new JTextField(30));
            frame.add(contents);
            frame.setVisible(true);
            frame.pack();
          } });
  }
}