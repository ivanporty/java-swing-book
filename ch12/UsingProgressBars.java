// UsingProgressBars.java
// Использование основных возможностей 
// компонента JProgressBar
import javax.swing.*;
import java.awt.*;

public class UsingProgressBars extends JFrame {
  // максимальное значение (100%)
  private int MAX = 100;
  // будем использовать общую модель
  private BoundedRangeModel model;
  public UsingProgressBars() {
    super("UsingProgressBars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем стандартную модель
    model = new DefaultBoundedRangeModel(5, 0, 0, MAX);
    // горизонтальный индикатор
    JProgressBar progress1 = new JProgressBar(model);
    progress1.setStringPainted(true);
    // вертикальный индикатор
    JProgressBar progress2 =
        new JProgressBar(JProgressBar.VERTICAL);
    progress2.setModel(model);
    progress2.setStringPainted(true);
    progress2.setString("Немного терпения...");
    // добавляем индикаторы в окно
    setLayout(new FlowLayout());
    add(progress1);
    add(progress2);
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
    // запускаем "процесс"
    new LongProcess().execute();
  }
  // эмуляция долгого процесса
  class LongProcess extends SwingWorker<String,Integer> {
    // работаем до завершения процесса
    protected String doInBackground() throws Exception {
      int current = 5;
      while ( current <= MAX ) {
        // обновляем внешний вид
        publish(current++);
        // случайная задержка
        Thread.sleep((int)(Math.random()*1000));
      }
      return "Готово";
    }
    // выполняется в потоке рассылки событий
    public void process(java.util.List<Integer> chunks) {
      // увеличиваем текущее значение
      model.setValue(chunks.get(0));
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingProgressBars(); } });
  }
}