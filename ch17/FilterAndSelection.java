// FilterAndSelection.java
// Настройка фильтрации таблицы и выделенные строки
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class FilterAndSelection extends JFrame {
  public FilterAndSelection() {
    super("FilterAndSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем таблицу на основе модели по умолчанию
    SimpleSorting.SortModel sm = new SimpleSorting.SortModel();
    sm.setColumnCount(4);
    // добавляем сто строк случайных чисел
    for ( int i = 0; i < 100; i++ ) {
      sm.addRow(new Integer[] { i,
          (int)(5*Math.random()),
          (int)(5*Math.random()),
          (int)(5*Math.random())} );
    }
    final JTable table = new JTable(sm);
    // автоматическое включение сортировки
    table.setAutoCreateRowSorter(true);
    // присоединим фильтрующий объект
    ((TableRowSorter)table.getRowSorter()).
        setRowFilter(new RowFilter() {
          public boolean include(Entry entry) {
            // включаем только четные строки
            return ((Integer)entry.getValue(0)) % 2 == 0;
          }
        });
    add(new JScrollPane(table));
    // поле для вывода номеров выбранных строк
    final JTextArea out = new JTextArea(3, 10);
    add(new JScrollPane(out), "South");
    // следим за выделением в таблице
    table.getSelectionModel().addListSelectionListener(
        new ListSelectionListener() {
          public void valueChanged(ListSelectionEvent e) {
            if ( table.getSelectedRow() != -1) {
              out.append("Строка:" + table.getSelectedRow() + "\n");
              out.append("Столбец:" + table.getSelectedColumn() + "\n");
              out.append("Строка модели:" +
                  table.convertRowIndexToModel(
                      table.getSelectedRow()) + "\n");
            }
          }
        });
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FilterAndSelection(); } });
  }
}