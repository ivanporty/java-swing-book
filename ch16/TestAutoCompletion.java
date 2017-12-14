// TestAutoCompletion.java
// Проверка работы текстового поля с
// автоматическим заполнением
import com.porty.swing.*;
import javax.swing.*;
import java.awt.*;

public class TestAutoCompletion extends JFrame {
  public TestAutoCompletion() {
    super("TestAutoCompletion");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем и настраиваем поле
    JTextField field =
        new JTextField();
    field.setColumns(15);
    // слова для автозаполнения
    AutoCompleteTextDocument doc =
        new AutoCompleteTextDocument(field);
    doc.addWord("прекрасный");
    doc.addWord("великолепный");
    // добавляем поле в окно
    setLayout(new FlowLayout());
    add(field);
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TextHighlights(); } });
  }
}
