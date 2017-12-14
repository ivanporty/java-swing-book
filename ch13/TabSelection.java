// TabSelection.java
// Работа с активными вкладками и обработка событий
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class TabSelection extends JFrame {
  public TabSelection() {
    super("TabSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем нашу панель с вкладками
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("Вкладка", new JPanel());
    tabs.addTab("Еще вкладка", new JPanel());
    // добавляем слушателя событий
    tabs.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // добавляем на вкладку новый компонент
        JPanel panel = (JPanel)
            ((JTabbedPane)e.getSource()).
                getSelectedComponent();
        panel.add(new JButton("Кнопка"));
      }
    });
    // работа с низкоуровневыми событиями
    tabs.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // узнаем, на какой вкладке был щелчок
        int idx = ((JTabbedPane)e.getSource()).
            indexAtLocation(e.getX(), e.getY());
        JOptionPane.showMessageDialog(
            null, "Index: " + idx);
      }
    });
    // выводим окно на экран
    add(tabs);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TabSelection(); } });
  }
}