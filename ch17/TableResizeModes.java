// TableResizeModes.java
// Режимы перераспределения пространства таблицы
// при изменении размеров столбцов
import javax.swing.*;
import java.awt.*;

public class TableResizeModes extends JFrame {
  // названия столбцов таблицы
  private String[] columnNames = {
      "Название", "Вкус", "Цвет"
  };
  // данные для таблицы
  private String[][] data = {
      { "Апельсин", "Кисло-сладкий", "Оранжевый"},
      { "Лимон", "Кислый", "Желтый"}
  };
  // массив таблиц
  private JTable[] tables = new JTable[5];
  public TableResizeModes() {
    super("TableResizeModes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // окно делим на пять ячеек
    setLayout(new GridLayout(5, 1));
    // создаем массив таблиц
    for (int i=0; i<tables.length; i++) {
      tables[i] =
          new JTable(data, columnNames);
      add(new JScrollPane(tables[i]));
    }
    // меняем режимы распределения пространства
    tables[1].setAutoResizeMode(
        JTable.AUTO_RESIZE_OFF);
    tables[2].setAutoResizeMode(
        JTable.AUTO_RESIZE_NEXT_COLUMN);
    tables[3].setAutoResizeMode(
        JTable.AUTO_RESIZE_LAST_COLUMN);
    tables[4].setAutoResizeMode(
        JTable.AUTO_RESIZE_ALL_COLUMNS);
    // придаем окну оптимальный размер и
    // выводим его на экран
    pack();
    setVisible(true);

  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TableResizeModes(); } });
  }
}
