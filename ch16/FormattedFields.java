// FormattedFields.java
// Применение полей JFormattedTextField
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.util.Date;
import java.awt.*;

public class FormattedFields extends JFrame {
  // поля для форматированного ввода данных
  private JFormattedTextField
      phoneField, dateField, numberField;
  public FormattedFields() {
    super("FormattedFields");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ограниченный ввод на основе маски
    // телефонный номер
    try {
      MaskFormatter phone =
          new MaskFormatter("+#-###-###-##-##");
      phone.setPlaceholderCharacter('0');
      phoneField = new JFormattedTextField(phone);
      phoneField.setColumns(15);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    // редактирование даты
    // формат даты
    DateFormat date =
        new SimpleDateFormat("dd MMMM yyyy, EEEE");
    // настройка форматирующего объекта
    DateFormatter formatter = new DateFormatter(date);
    formatter.setAllowsInvalid(false);
    formatter.setOverwriteMode(true);
    // настройка текстового поля
    dateField = new JFormattedTextField(formatter);
    dateField.setColumns(15);
    dateField.setValue(new Date());
    // редактирование чисел
    // формат числа с экспонентой
    NumberFormat number = new DecimalFormat("##0.##E0");
    numberField = new JFormattedTextField(
        new NumberFormatter(number));
    // настройка поля
    numberField.setColumns(10);
    numberField.setValue(1500);
    // добавляем поля в панель содержимого
    setLayout(new FlowLayout());
    add(new JLabel("Телефон:"));
    add(phoneField);
    add(new JLabel("Дата:"));
    add(dateField);
    add(new JLabel("Число:"));
    add(numberField);
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FormattedFields(); } });
  }
}
