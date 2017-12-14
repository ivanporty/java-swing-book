// MigLayoutStart.java
// «накомство с MigLayout
import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class MigLayoutStart extends JFrame {
  public MigLayoutStart() {
    super("MigLayoutStart");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // устанавливаем менеджер расположени€
    setLayout(new MigLayout());
    // добавл€ем компоненты с описанием €чеек
    add(new JLabel("»м€:"), "gap, sg 1");
    add(new JTextField(10), "wrap");
    add(new JLabel("‘амили€:"), "gap, sg 1");
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