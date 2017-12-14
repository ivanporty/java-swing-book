// SimpleTabbedPanes.java
// Использование панелей с вкладками
import javax.swing.*;
import java.awt.*;

public class SimpleTabbedPanes extends JFrame {
  public SimpleTabbedPanes() {
    super("SimpleTabbedPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // первая панель с вкладками
    JTabbedPane tabsOne = new JTabbedPane(
        JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
    // добавляем вкладки
    for (int i=1; i<8; i++) {
      JPanel tab = new JPanel();
      tab.add(new JButton("Просто кнопка " + i));
      tabsOne.addTab("Вкладка №: " + i, tab);
    }
    // вторая панель с вкладками
    JTabbedPane tabsTwo = new
        JTabbedPane(JTabbedPane.TOP);
    // добавляем вкладки
    for (int i=1; i<8; i++) {
      JPanel tab = new JPanel();
      tab.add(new JButton("Снова кнопка " + i));
      tabsTwo.addTab("<html><i>Вкладка №: " + i,
          new ImageIcon("icon.gif"),
          tab, "Нажмите " + i + "!");
    }
    // добавляем вкладки в панель содержимого
    setLayout(new GridLayout());
    add(tabsOne);
    add(tabsTwo);
    // выводим окно на экран
    setSize(600, 250);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTabbedPanes(); } });
  }
}