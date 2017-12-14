// RadioButtons.java
// Использование переключателей
import javax.swing.*;
import java.awt.*;

public class RadioButtons extends JFrame {
  public RadioButtons() {
    super("RadioButtons");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // используем последовательное расположение
    setLayout(new FlowLayout());
    // отдельный переключатель
    JRadioButton r = new JRadioButton("Сам по себе");
    // группа связанных переключателей в своей
    // собственной панели
    JPanel panel = new JPanel(new GridLayout(0, 1, 0, 5));
    panel.setBorder(
        BorderFactory.createTitledBorder("Внешний вид"));
    ButtonGroup bg = new ButtonGroup();
    String[] names = { "Внешний вид Java",
        "MS Windows", "Aqua (Mac)" };
    for (String name : names) {
      JRadioButton radio = new JRadioButton(name);
      panel.add(radio);
      bg.add(radio);
    }
    // добавляем все в контейнер
    add(r);
    add(panel);
    // выводим окно на экран
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new RadioButtons(); } });
  }
}
