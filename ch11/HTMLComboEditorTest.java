// HTMLComboEditorTest.java
// Пример использование специального объекта для
// редактирования
import javax.swing.*;
import com.porty.swing.HTMLComboBoxEditor;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HTMLComboEditorTest
    extends JFrame {
  // данные для раскрывающегося списка
  private String[] data = {
      "<html><font color=yellow>Желтый",
      "<html><strike>Зачеркнутый",
      "<html><font color=green>Зеленый",
      "<html><em>С наклоном" };
  public HTMLComboEditorTest() {
    super("HTMLComboEditorTest");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем список
    final JComboBox combo = new JComboBox(data);
    combo.setPrototypeDisplayValue("11223344556677");
    combo.setEditable(true);
    combo.setEditor(new HTMLComboBoxEditor());
    // добавляем список в окно
    setLayout(new FlowLayout());
    add(combo);
    // кнопка для добавления нового элемента в список
    JButton addButton = new JButton("Добавить");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        combo.addItem(combo.getSelectedItem());
      }
    });
    add(addButton);
    // выводим окно на экран
    setSize(330, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HTMLComboEditorTest(); } });
  }
}
