// SimpleTableModel.java
// Создание простой модели для таблицы
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class SimpleTableModel extends JFrame {
  public SimpleTableModel() {
    super("SimpleTableModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем таблицу на основе нашей модели
    JTable table = new JTable(new SimpleModel());
    table.setRowHeight(32);
    add(new JScrollPane(table));
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  // наша модель
  class SimpleModel extends AbstractTableModel {
    // количество строк
    public int getRowCount() {
      return 100000;
    }
    // количество столбцов
    public int getColumnCount() {
      return 3;
    }
    // тип данных, хранимых в столбце
    public Class getColumnClass(int column) {
      switch (column) {
        case 1: return Boolean.class;
        case 2: return Icon.class;
        default: return Object.class;
      }
    }
    // данные в ячейке
    public Object getValueAt(int row, int column) {
      boolean isEven = (row % 2 == 0);
      // разные данные для разных стобцов
      switch (column) {
        case 0: return "" + row;
        case 1: return isEven;
        case 2: return new ImageIcon("Table.gif");
      }
      return "Пусто";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTableModel(); } });

  }
}