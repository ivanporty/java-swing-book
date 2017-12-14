// ControllingCaret.java
// Управление текстовым курсором
import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.text.*;
import java.awt.*;

public class ControllingCaret extends JFrame {
  public ControllingCaret() {
    super("ControllingCaret");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // многострочное текстовое поле
    final JTextArea textArea = new JTextArea();
    // добавим текст
    textArea.append("Просто какой-то текст");
    // настройка курсора и выделение текста
    Caret caret = textArea.getCaret();
    caret.setBlinkRate(50);
    caret.setDot(5);
    caret.moveDot(10);
    // добавим текстовое поле в окно
    add(new JScrollPane(textArea));
    // надпись для слова у курсора
    final JLabel label = new JLabel();
    add(label, "South");
    // слушатель перемещений курсора
    textArea.addCaretListener(new CaretListener() {
      public void caretUpdate(CaretEvent e) {
        // выведем слово у курсора
        try {
          // начало и конец слова на позиции
          int wordStart =
              Utilities.getWordStart(textArea, e.getDot());
          int wordEnd =
              Utilities.getWordEnd(textArea, e.getDot());
          label.setText(textArea.getText(
              wordStart, wordEnd - wordStart));
        } catch (BadLocationException ex) {
          ex.printStackTrace();
        }
      }
    });
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ControllingCaret(); } });
  }
}
