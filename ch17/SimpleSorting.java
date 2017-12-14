// SimpleSorting.java
// Сортировка таблицы по умолчанию
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class SimpleSorting extends JFrame {
  public SimpleSorting() {
    super("SimpleSorting");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем таблицу на основе модели по умолчанию
    SortModel sm = new SortModel();
    sm.setColumnCount(4);
    // добавляем сто строк случайных чисел
    for ( int i = 0; i < 100; i++ ) {
      sm.addRow(new Integer[] { i,
          (int)(5*Math.random()),
          (int)(5*Math.random()),
          (int)(5*Math.random())} );
    }
    JTable table = new JTable();
    // автоматическое включение сортировки
    table.setAutoCreateRowSorter(true);
    // ограничение по количеству столбцов
    ((TableRowSorter)table.getRowSorter()).setMaxSortKeys(2);
    table.setModel(sm);
    add(new JScrollPane(table));
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  // модель для демонстрации сортировки и фильтрации
  static class SortModel extends DefaultTableModel {
    // тип данных, хранимых в столбце
    public Class getColumnClass(int column) {
      return Integer.class;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FilterAndSelection(); } });
  }
}