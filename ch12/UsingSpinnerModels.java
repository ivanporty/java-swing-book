// UsingSpinnerModels.java
// Использование стандартных моделей счетчика
import javax.swing.*;
import java.awt.*;

public class UsingSpinnerModels extends JFrame {
  // набор данных для счетчика
  private String[] data = {
    "Холодно", "Прохладно", "Тепло", "Жарко"
  };
  public UsingSpinnerModels() {
    super("UsingSpinnerModels");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // модель счетчика для выбора из набора данных
    SpinnerModel list = new SpinnerListModel(data);
    JSpinner spinner1 = new JSpinner(list);
    // модель счетчика для выбора целых чисел
    SpinnerModel numbers = new SpinnerNumberModel(
      4, 0, 100, 1);
    JSpinner spinner2 = new JSpinner(numbers);
    // добавим счетчики в панель содержимого
    setLayout(new FlowLayout());
    add(spinner1);
    add(spinner2);
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingSpinnerModels(); } });
  }
}
