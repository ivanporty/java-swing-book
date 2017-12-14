// TextHighlights.java
// Дополнительное выделение текста
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class TextHighlights extends JFrame {
  public TextHighlights() {
    super("TextHighlights");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем и настраиваем поле
    JTextArea area =
        new JTextArea("Привет мир!");
    try {
      // добавим выделенный фрагмент желтого цвета
      Object reference =
          area.getHighlighter().
              addHighlight(0, 6,
                  new DefaultHighlighter.
                      DefaultHighlightPainter(Color.YELLOW));
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
    // добавляем поле в окно
    add(new JScrollPane(area));
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