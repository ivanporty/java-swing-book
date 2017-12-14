// ToolTipsTuning.java
// Настройка подсказок
import javax.swing.*;

public class ToolTipsTuning extends JFrame {
  public ToolTipsTuning() {
    super("ToolTipsTuning");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим кнопки с подсказками
    JPanel contents = new JPanel();
    JButton b1 = new JButton("Первая");
    b1.setToolTipText("Подсказка для первой");
    JButton b2 = new JButton("Вторая");
    b2.setToolTipText("Подсказка для второй");
    contents.add(b1);
    contents.add(b2);
    // настройка подсказок
    ToolTipManager ttm =
        ToolTipManager.sharedInstance();
    ttm.setLightWeightPopupEnabled(false);
    ttm.setInitialDelay(1000);
    ttm.setDismissDelay(500);
    ttm.setReshowDelay(1000);
    // выводим окно на экран
    add(contents);
    setSize(200, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ToolTipsTuning(); } });
  }
}
