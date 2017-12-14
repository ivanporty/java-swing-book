// ProgressBarTricks.java
// Небольшие хитрости индикаторов процесса
import javax.swing.*;
import java.awt.*;

public class ProgressBarTricks extends JFrame {
  // максимальное значение индикатора
  private final int MAX = 100;
  public ProgressBarTricks() {
    super("ProgressBarTricks");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // настроим параметры для UI-представителей
    UIManager.put("ProgressBar.cellSpacing", 2);
    UIManager.put("ProgressBar.cellLength", 6);
    // стандартная модель
    final DefaultBoundedRangeModel model =
        new DefaultBoundedRangeModel(0, 0, 0, MAX);
    // создадим простой индикатор процесса
    // на основе полученной модели
    JProgressBar progress = new JProgressBar(model);
    // добавим его в окно
    setLayout(new FlowLayout());
    add(progress);
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
    // создадим "процесс"
    Thread process = new Thread(new Runnable() {
      public void run() {
        // увеличиваем текущее значение модели до
        // достижения максимального значения
        int value = 0;
        while ( ++value <= MAX ) {
          final int passValue = value;
          SwingUtilities.invokeLater(
              new Runnable() {
                public void run() {
                  model.setValue(passValue); }});
          try {
            Thread.sleep(200);
          } catch (Exception ex) { }
        }
      }
    });
    // запустим поток
    process.start();
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ProgressBarTricks(); } });
  }
}
