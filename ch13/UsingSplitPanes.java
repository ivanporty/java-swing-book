// UsingSplitPanes.java
// Использование разделяемых панелей
import javax.swing.*;
import java.awt.*;

public class UsingSplitPanes extends JFrame {
  // этот значок будем использовать в надписях
  private Icon icon = new ImageIcon("image.jpg");
  public UsingSplitPanes() {
    super("UsingSplitPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // первая разделяемая панель
    JSplitPane splitMain = new JSplitPane();
    splitMain.setOneTouchExpandable(true);
    // размер полосы
    splitMain.setDividerSize(20);
    // вертикальная разделяемая панель
    JSplitPane split2 = new JSplitPane(
        JSplitPane.VERTICAL_SPLIT, true);
    // настроим ее компоненты
    split2.setTopComponent(
        new JScrollPane(new JLabel(icon)));
    split2.setBottomComponent(
        new JScrollPane(new JLabel(icon)));
    // настроим компоненты первой панели
    splitMain.setLeftComponent(
        new JScrollPane(new JLabel(icon)));
    splitMain.setRightComponent(split2);
    // добавим панель и выведем окно на экран
    add(splitMain);
    setSize(600, 400);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingSplitPanes(); } });
  }
}