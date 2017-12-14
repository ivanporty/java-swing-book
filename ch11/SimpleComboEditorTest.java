// SimpleComboEditorTest.java
// Пример использование специального объекта для
// редактирования
import javax.swing.*;
import com.porty.swing.*;
import java.awt.*;

public class SimpleComboEditorTest
    extends JFrame {
  // данные для раскрывающегося списка
  private String[] data = {
      "<html><font color=yellow>Желтый",
      "<html><strike>Зачеркнутый",
      "<html><font color=green>Зеленый",
      "<html><em>С наклоном" };
  public SimpleComboEditorTest() {
    super("SimpleComboEditorTest");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем список
    JComboBox combo = new JComboBox(data);
    combo.setEditable(true);
    combo.setEditor(new SimpleHTMLComboBoxEditor());
    // добавляем список в окно
    setLayout(new FlowLayout());
    add(combo);
    // выводим окно на экран
    setSize(330, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleComboEditorTest(); } });
  }
}
