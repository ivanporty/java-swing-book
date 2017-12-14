// ChoosingDates.java
// Выбор дат с помощью SpinnerDateModel
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class ChoosingDates extends JFrame {
  public ChoosingDates() {
    super("ChoosingDates");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // настраиваем модель для выбора дня месяца
    SpinnerModel monthDay = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    JSpinner spinner1 = new JSpinner(monthDay);
    // модель для выбора месяца, с ограничениями
    SpinnerModel month = new SpinnerDateModel(
        new Date(), new MinDate(), new MaxDate(), Calendar.MONTH);
    JSpinner spinner2 = new JSpinner(month);
    // добавляем списки в панель
    setLayout(new FlowLayout());
    add(spinner1);
    add(spinner2);
    // выводим окно на экран
    setSize(350, 300);
    setVisible(true);
  }
  // вспомогательный объект для проверок дат
  private Calendar calendar = Calendar.getInstance();
  // проверяет минимальную дату (по году)
  class MinDate extends Date implements Comparable<Date> {
    public int compareTo(Date d) {
      calendar.setTime(d);
      int year = calendar.get(Calendar.YEAR);
      // год не меньше 2005
      return (year < 2005) ? 1 : -1;
    }
  }
  // проверяет максимальную дату (по году)
  class MaxDate extends Date implements Comparable<Date> {
    public int compareTo(Date d) {
      calendar.setTime(d);
      calendar.get(Calendar.YEAR);
      int year = calendar.get(Calendar.YEAR);
      // год не больше 2011
      if ( year > 2011 ) return -1;
      else return 1;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ChoosingDates(); } });
  }
}
