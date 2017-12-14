// MigLayoutStart.java
// Знакомство с MigLayout
import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class MigLayoutStart extends JFrame {
  public MigLayoutStart() {
    super("MigLayoutStart");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // устанавливаем менеджер расположения
    setLayout(new MigLayout());
    // добавляем компоненты с описанием ячеек
    add(new JLabel("Имя:"), "gap, sg 1");
    add(new JTextField(10), "wrap");
    add(new JLabel("Фамилия:"), "gap, sg 1");
    add(new JTextField(10), "wrap");
    // выведем окно на экран
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new MigLayoutStart(); } });
  }
}