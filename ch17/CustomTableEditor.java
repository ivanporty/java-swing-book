// CustomTableEditor.java
// Применение специализированного редактора
// для ячеек таблицы
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;
import com.porty.swing.*;

public class CustomTableEditor extends JFrame {
  // заголовок столбцов таблицы
  private String[] columns = {
      "Операция", "Дата" };
  // данные таблицы
  private Object[][] data = {
      { "Покупка", new Date() },
      { "Продажа", new Date() }
  };
  public CustomTableEditor() {
    super("CustomTableEditor");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем таблицу на основе стандартной модели
    DefaultTableModel model =
        new DefaultTableModel(data, columns) {
          // необходимо указать тип столбца
          public Class getColumnClass(int column) {
            return data[0][column].getClass();
          }
        };
    JTable table = new JTable(model);
    table.setRowHeight(20);
    // указываем редактор для дат
    table.setDefaultEditor(
        Date.class, new DateCellEditor());
    // выводим окно на экран
    getContentPane().add(new JScrollPane(table));
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomTableEditor(); } });
  }
}
