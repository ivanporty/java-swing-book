// SimpleTablesLook.java
// Небольшое изменение внешнего вида таблиц
import javax.swing.*;
import java.awt.*;

public class SimpleTablesLook extends JFrame {
  // данные и заголовки для таблицы
  private Object[][] data = new String[][] {
      { "Мощная", "Синий", "Спортивный" },
      { "Экономичная", "Красный", "Классика" }
  };
  private Object[] columns = new String[] {
      "Модель", "Цвет", "Дизайн"
  };
  public SimpleTablesLook() {
    super("SimpleTablesLook");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // таблица с разными расстояниями между ячейками
    JTable table1 = new JTable(data, columns);
    // настройка расстояний и цветов
    table1.setRowHeight(40);
    table1.setIntercellSpacing(new Dimension(10, 10));
    table1.setGridColor(Color.green);
    table1.setShowVerticalLines(false);
    // таблица с разными цветами
    JTable table2 = new JTable(data, columns);
    table2.setForeground(Color.red);
    table2.setSelectionForeground(Color.yellow);
    table2.setSelectionBackground(Color.blue);
    table2.setShowGrid(false);
    // добавляем таблицы в панель из двух ячеек
    setLayout(new GridLayout(1, 2, 5, 5));
    add(new JScrollPane(table1));
    add(new JScrollPane(table2));
    // выводим окно на экран
    setSize(600, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTablesLook(); } });
  }
}