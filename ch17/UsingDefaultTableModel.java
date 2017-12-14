// UsingDefaultTableModel.java
// Использование стандартной модели при создании таблицы
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;

public class UsingDefaultTableModel extends JFrame {
  // наша модель
  private DefaultTableModel dtm;
  public UsingDefaultTableModel() {
    super("UsingDefaultTableModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем стандартную модель
    dtm = new DefaultTableModel();
    // задаем названия стоблцов
    dtm.setColumnIdentifiers(
        new String[] {"Номер", "Товар", "Цена"});
    // наполняем модель данными
    dtm.addRow(new String[] {"№1", "Блокнот", "5.5"});
    dtm.addRow(new String[] {"№2", "Телефон", "175"});
    dtm.addRow(new String[] {"№3", "Карандаш", "1.2"});
    // передаем модель в таблицу
    JTable table = new JTable(dtm);
    // данные могут меняться динамически
    JButton add = new JButton("Добавить");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // добавляем новые данные
        dtm.addRow(
            new String[] {"?", "Новинка!", "Супер Цена!"});
      }
    });
    JButton remove = new JButton("Удалить");
    remove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // удаляем последнюю строку (отсчет с нуля)
        dtm.removeRow(dtm.getRowCount() - 1);
      }
    });
    // добавляем кнопки и таблицу
    add(new JScrollPane(table));
    JPanel buttons = new JPanel();
    buttons.add(add);
    buttons.add(remove);
    add(buttons, "South");
    // выводим окно на экран
    setSize(300, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingDefaultTableModel(); } });
  }
}
