// IndeterminateProgressBars.java
// Индикаторы в состоянии "неопределенности"
import javax.swing.*;
import java.awt.*;

public class IndeterminateProgressBars extends JFrame {
  public IndeterminateProgressBars() {
    super("IndeterminateProgressBars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // неопределенный индикатор
    JProgressBar progress = new JProgressBar(0, 100);
    progress.setIndeterminate(true);
    progress.setStringPainted(true);
    // добавляем его в окно и выводим на экран
    setLayout(new FlowLayout());
    add(new JLabel("Соединение:"));
    add(progress);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new IndeterminateProgressBars(); } });
  }
}
