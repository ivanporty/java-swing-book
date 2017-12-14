// TableDefaultEditing.java
// Применение стандартного редактора для таблиц
import javax.swing.*;
import java.awt.*;

public class TableDefaultEditing extends JFrame {
  // название столбцов
  private String[] columns = {
      "Имя", "Любимый Цвет" };
  // данные для таблицы
  private String[][] data = {
      { "Иван", "Зеленый" },
      { "Александр", "Красный"},
      { "Петр", "Синий"}
  };
  public TableDefaultEditing() {
    super("TableDefaultEditing");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем таблицу
    JTable table = new JTable(data, columns);
    // настраиваем стандартный редактор
    JComboBox combo = new JComboBox(
        new String[] { "Зеленый", "Желтый", "Белый"});
    DefaultCellEditor editor =
        new DefaultCellEditor(combo);
    table.getColumnModel().getColumn(1).
        setCellEditor(editor);
    // выводим окно на экран
    add(new JScrollPane(table));
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TableDefaultEditing(); } });
  }
}