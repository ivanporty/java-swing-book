// TabComponents.java
// Размещение компонентов во вкладках
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TabComponents extends JFrame {
  public TabComponents() {
    super("TabComponents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // панель с вкладками
    final JTabbedPane tabs = new JTabbedPane();
    tabs.addTab(null, new JPanel());
    tabs.addTab(null, new JPanel());
    // флажок во вкладке
    JCheckBox checkBox = new JCheckBox("Флажок!");
    checkBox.setOpaque(false);
    tabs.setTabComponentAt(0, checkBox);
    // вкладка с надписью и кнопкой закрытия
    final JPanel panel = new JPanel();
    JLabel label = new JLabel("Можно закрыть!");
    JButton closeButton = new JButton(new AbstractAction() {
      {
        putValue(SMALL_ICON, new ImageIcon("close.png"));
      }
      public void actionPerformed(ActionEvent e) {
        // нужно определить вкладку, в которой находится кнопка
        tabs.removeTabAt(
            tabs.indexOfTabComponent(panel));
      }
    });
    closeButton.setBorderPainted(false);
    closeButton.setContentAreaFilled(false);
    panel.setOpaque(false);
    panel.add(label);
    panel.add(closeButton);
    tabs.setTabComponentAt(1, panel);
    // выводим окно на экран
    add(tabs);
    setSize(430, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TabComponents(); } });
  }
}