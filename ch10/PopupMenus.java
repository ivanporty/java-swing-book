// PopupMenus.java
// –абота с всплывающими меню
import javax.swing.*;
import java.awt.*;

public class PopupMenus extends JFrame {
  public PopupMenus() {
    super("PopupMenus");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // получаем всплывающее меню
    JPopupMenu popup = createPopupMenu();
    // и прив€зываем к нашей панели содержимого
    ((JComponent)getContentPane()).
        setComponentPopupMenu(popup);
    // "прозрачна€" дл€ меню кнопка
    JButton button = new JButton("ѕроба пера");
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
    JMenuItem good = new JMenuItem("ќтлично");
    JMenuItem excellent = new JMenuItem("«амечательно");
    // и добавд€ем все тем же методом add()
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
