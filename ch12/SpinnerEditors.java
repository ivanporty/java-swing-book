// SpinnerEditors.java
// Стандартные редакторы счетчиков
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SpinnerEditors extends JFrame {
  // данные для первого счетчика
  private String[] data = {
      "Первый", "Второй", "Последний"
  };
  public SpinnerEditors() {
    super("SpinnerEditors");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // счетчик на основе массива
    JSpinner spinner1 = new JSpinner(
        new SpinnerListModel(data));
    // настраиваем редактор
    ((JSpinner.ListEditor)spinner1.getEditor()).
        getTextField().setColumns(15);
    // выбор дат
    SpinnerDateModel dates = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    JSpinner spinner2 = new JSpinner(dates);
    // настраиваем редактор
    ((JSpinner.DateEditor)spinner2.getEditor()).
        getTextField().setEditable(false);
    // добавляем счетчики в панель содержимого
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
          public void run() { new SpinnerEditors(); } });
  }
}
