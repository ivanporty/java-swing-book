// HTMLTester.java
// Позволяет легко просмотреть результат
// использования HTML на компонентах Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HTMLTester extends JFrame {
  public HTMLTester() {
    super("HTMLTester");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // создадим интерфейс и настроим события
    createGUI();
    attachListeners();
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  private JTextArea html;
  private JLabel result;
  private JButton update;
  private void createGUI() {
    // в качестве основы используем таблицу
    JPanel p = new JPanel(new GridLayout(1, 2, 5, 5));
    p.setBorder(
        BorderFactory.createEmptyBorder(12, 12, 12, 12));
    // полярное расположение
    JPanel vertical = new JPanel(new BorderLayout());
    // настройка текстового поля
    JScrollPane scroller = new JScrollPane(
        html = new JTextArea());
    html.setLineWrap(true);
    html.append("<html>");
    // добавляем текстовое поле и надпись
    vertical.add(new JLabel("Код HTML:"), "North");
    vertical.add(scroller);
    // кнопка обновления текста
    update = new JButton("Обновить");
    getContentPane().add(update, "South");
    // надпись с результатом
    JPanel resultPanel = new JPanel(new BorderLayout());
    result = new JLabel();
    resultPanel.add(new JLabel("Результат:"), "North");
    resultPanel.add(new JScrollPane(result));
    // окончательная укладка панелей
    p.add(vertical);
    p.add(resultPanel);
    getContentPane().add(p);
  }
  private void attachListeners() {
    update.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // устанавливаем в надписи новый текст
        result.setText(html.getText());
      }
    });
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HTMLTester(); } });
  }
}
