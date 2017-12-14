// TabAdditionalFeatures.java
// Дополнительные возможности панелей с вкладками
import javax.swing.*;
import java.awt.*;

public class TabAdditionalFeatures extends JFrame {
  public TabAdditionalFeatures() {
    super("TabAdditionalFeatures");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // панель с вкладками
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("Первая вкладка", new JPanel());
    tabs.addTab("Вторая вкладка (S)", new JPanel());
    tabs.addTab("Интересная вкладка", new JPanel());
    // зададаем мнемоники
    tabs.setMnemonicAt(0, 'П');
    tabs.setMnemonicAt(1, 'S');
    tabs.setMnemonicAt(2, 'И');
    // активизируем последнюю вкладку
    tabs.setEnabledAt(2, false);
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