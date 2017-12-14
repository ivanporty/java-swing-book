// SimpleTables.java
// Простые таблицы с помощью удобных конструкторов
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleTables extends JFrame {
  // данные для таблиц
  private Object[][] colors = new String[][] {
      { "Красный", "Зеленый", "Синий" },
      { "Желтый", "Оранжевый", "Белый" },
  };
  // названия заголовков столбцов
  private Object[] colorsHeader = new String[] {
      "Цвет", "Еще цвет", "Тоже цвет"
  };
  public SimpleTables() {
    super("SimpleTables");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // несколько простых таблиц
    JTable table1 = new JTable(colors, colorsHeader);
    JTable table2 = new JTable(5, 5);
    // таблица на основе вектора, состоящего из векторов
    Vector<Vector<String>> data =
        new Vector<Vector<String>>();
    Vector<String> row1 = new Vector<String>();
    Vector<String> row2 = new Vector<String>();
    // вектор с заголовками столбцов
    Vector<String> columnNames = new Vector<String>();
    // наполнение данными
    for (int i=0; i<3; i++) {
      row1.add("Ячейка 1." + i);
      row2.add("Ячейка 2." + i);
      columnNames.add("Столбец #" + i);
    }
    data.add(row1);
    data.add(row2);
    JTable table3 = new JTable(data, columnNames);
    // добавляем таблицы в панель с тремя рядами
    setLayout(new GridLayout(3, 1));
    add(new JScrollPane(table1));
    add(new JScrollPane(table2));
    add(table3);
    // выводим окно на экран
    setSize(350, 400);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTables(); } });
  }
}