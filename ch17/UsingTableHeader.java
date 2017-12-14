// UsingTableHeader.java
// Настройка заголовка таблицы JTableHeader
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.*;

public class UsingTableHeader extends JFrame {
  // данные для таблицы
  private String[][] data = {
      { "Июнь", "+18 С" },
      { "Июль", "+22 С" },
      { "Август", "+19 С" }
  };
  // названия столбцов
  private String[] columnNames = {
      "Месяц", "Средняя температура"
  };
  public UsingTableHeader() {
    super("UsingTableHeader");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем таблицу
    JTable table = new JTable(data, columnNames);
    table.setAutoCreateRowSorter(true);
    // настраиваем заголовок таблицы
    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);
    header.setResizingAllowed(false);
    // присоединяем отображающий объект
    header.setDefaultRenderer(new HeaderRenderer());
    // добавляем таблицы в панель прокрутки
    add(new JScrollPane(table));
    setSize(400, 300);
    setVisible(true);
  }
  // специальный отображающий объект для заголовка
  class HeaderRenderer
      extends DefaultTableCellRenderer {
    // метод возвращает компонент для прорисовки
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
      // получаем настроенную надпись от базового класса
      JLabel label = (JLabel)super.
          getTableCellRendererComponent(table,
              value, isSelected, hasFocus,
              row, column);
      // настраиваем особую рамку и цвет фона
      label.setBackground(Color.gray);
      label.setBorder(border);
      return label;
    }
    private Border border = BorderFactory.
        createMatteBorder(16, 16, 16, 16,
            new ImageIcon("bullet.png"));
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTableHeader(); } });
  }
}
