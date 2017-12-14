// TableSelection.java
// Режимы выделения ячеек таблицы
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class TableSelection extends JFrame {
  // названия столбцов таблицы
  private String[] columnNames = {
      "Название", "Вкус", "Цвет"
  };
  // данные для таблицы
  private String[][] data = {
      { "Апельсин", "Кисло-сладкий", "Оранжевый"},
      { "Арбуз", "Сладкий", "Темно-зеленый"},
      { "Лимон", "Кислый", "Желтый"}
  };
  public TableSelection() {
    super("TableSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем пару таблиц с одинаковыми данными
    // первая таблица - выделение по строкам
    JTable table1 = new JTable(data, columnNames);
    table1.getSelectionModel().setSelectionMode(
        ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    // вторая таблица - выделение по столбцам
    JTable table2 = new JTable(data, columnNames);
    table2.setRowSelectionAllowed(false);
    TableColumnModel cm = table2.getColumnModel();
    cm.setColumnSelectionAllowed(true);
    cm.getSelectionModel().setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    // добавляем таблицы и выводим окно на экран
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(table1));
    add(new JScrollPane(table2));
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TableSelection(); } });
  }
}
