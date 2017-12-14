// Checkboxes.java
// Использование флажков JCheckBox
import javax.swing.*;
import java.awt.*;

public class Checkboxes extends JFrame {
  public Checkboxes() {
    super("Checkboxes");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // используем последовательное расположение
    setLayout(new FlowLayout());
    // отдельный флажок
    JCheckBox ch = new JCheckBox("Я люблю JFC", true);
    // группа связанных флажков в своей
    // собственной панели
    JPanel panel = new JPanel(new GridLayout(0, 1, 0, 5));
    panel.setBorder(
        BorderFactory.createTitledBorder("Мороженое"));
    String[] names = { "Крем-брюле",
        "Ром с изюмом", "Шоколадное" };
    for (String name : names) {
      JCheckBox check = new JCheckBox(name);
      panel.add(check);
    }
    // добавляем все в контейнер
    add(ch);
    add(panel);
    // выводим окно на экран
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new Checkboxes(); } });
  }
}
