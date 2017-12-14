// UsingTableColumnModel.java
// Использование стандартной модели столбцов
// таблицы и объектов TableColumn
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Enumeration;

public class UsingTableColumnModel extends JFrame {
  // модель столбцов
  private TableColumnModel columnModel;
  // названия столбцов таблицы
  private String[] columnNames = {
      "Имя", "Любимый цвет", "Напиток"
  };
  // данные для таблицы
  private String[][] data = {
      { "Иван", "Зеленый", "Апельсиновый сок"},
      { "Александр", "Бежевый", "Зеленый чай"}
  };
  public UsingTableColumnModel() {
    super("UsingTableColumnModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // наша таблица
    JTable table = new JTable(data, columnNames);
    // получаем стандартную модель
    columnModel = table.getColumnModel();
    // меняем размеры столбцов
    Enumeration e = columnModel.getColumns();
    while ( e.hasMoreElements() ) {
      TableColumn column =
          (TableColumn)e.nextElement();
      column.setMinWidth(30);
      column.setMaxWidth(90);
    }
    // создадим пару кнопок
    JPanel buttons = new JPanel();
    JButton move = new JButton("Поменять местами");
    move.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // меняем местами первые два столбца
        columnModel.moveColumn(0, 1);
      }
    });
    buttons.add(move);
    JButton add = new JButton("Добавить");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // добавляем столбец
        TableColumn newColumn =
            new TableColumn(1, 100);
        newColumn.setHeaderValue("<html><b>Новый!");
        columnModel.addColumn(newColumn);
      }
    });
    buttons.add(add);
    // выводим окно на экран
    add(new JScrollPane(table));
    add(buttons, "South");
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTableColumnModel(); } });
  }
}
