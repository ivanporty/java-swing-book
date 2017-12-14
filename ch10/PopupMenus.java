// PopupMenus.java
// Работа с всплывающими меню
import javax.swing.*;
import java.awt.*;

public class PopupMenus extends JFrame {
  public PopupMenus() {
    super("PopupMenus");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // получаем всплывающее меню
    JPopupMenu popup = createPopupMenu();
    // и привязываем к нашей панели содержимого
    ((JComponent)getContentPane()).
        setComponentPopupMenu(popup);
    // "прозрачная" для меню кнопка
    JButton button = new JButton("Проба пера");
    button.setInheritsPopupMenu(true);
    add(button, "South");
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  // создаем наше всплывающее меню
  private JPopupMenu createPopupMenu() {
    // создаем само всплывающее меню
    JPopupMenu pm = new JPopupMenu();
    // создаем его пункты
    JMenuItem good = new JMenuItem("Отлично");
    JMenuItem excellent = new JMenuItem("Замечательно");
    // и добавдяем все тем же методом add()
    pm.add(good);
    pm.add(excellent);
    return pm;
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new PopupMenus(); } });
  }
}
