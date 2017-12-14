// RegisteringTableRenderer.java
// Регистрация в таблице собственного
// объекта для отображения
import javax.swing.*;
import javax.swing.table.*;
import com.porty.swing.*;
import java.awt.*;

public class RegisteringTableRenderer extends JFrame {
  public RegisteringTableRenderer() {
    super("RegisteringTableRenderer");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем таблицы на основе нашей модели
    JTable table = new JTable(new SpecialModel());
    // регистрируем объект для прорисовки новых данных
    table.setDefaultRenderer(ImageListElement.class,
        new ImageTableCellRenderer());
    // выводим окно на экран
    add(new JScrollPane(table));
    pack();
    setVisible(true);
  }
  // модель таблицы
  class SpecialModel extends AbstractTableModel {
    // значки
    private Icon
        image1 = new ImageIcon("clip1.gif"),
        image2 = new ImageIcon("clip2.gif");
    // названия столбцов
    private String[] columnNames = {
        "Компания", "Адрес"
    };
    // данные таблицы
    private Object[][] data = {
        { new ImageListElement(image1, "MegaWorks"),
            "<html><font color=\"red\">Париж" },
        { new ImageListElement(image2, "TerraMedia"),
            "<html><b>С.-Петербург" }
    };
    // количество столбцов
    public int getColumnCount() {
      return columnNames.length;
    }
    // названия столбцов
    public String getColumnName(int column) {
      return columnNames[column];
    }
    // количество строк
    public int getRowCount() {
      return data.length;
    }
    // тип данных столбца
    public Class getColumnClass(int column) {
      return data[0][column].getClass();
    }
    // значение в ячейке
    public Object getValueAt(int row, int column) {
      return data[row][column];
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new RegisteringTableRenderer(); } });
  }
}