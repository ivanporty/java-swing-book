// StyledText.java
// Ѕогатые возможности редактора JTextPane
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class StyledText extends JFrame {
  public StyledText() {
    super("StyledText");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создадим редактор
    JTextPane textPane = new JTextPane();
    // создание документа и стилей
    createDocument(textPane);
    // добавим редактор в окно
    add(new JScrollPane(textPane));
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  private void createDocument(JTextPane tp) {
    // настройка стилей
    // стиль основного текста
    Style normal = tp.addStyle("Normal", null);
    StyleConstants.setFontFamily(normal, "Verdana");
    StyleConstants.setFontSize(normal, 13);
    // заголовок
    Style heading = tp.addStyle("Heading", normal);
    StyleConstants.setFontSize(heading, 20);
    StyleConstants.setBold(heading, true);
    // наполн€ем документ содержимым, использу€ стили
    insertString("Ќезамысловатый «аголовок", tp, heading);
    insertString("ƒалее идет обычное содержимое,", tp, normal);
    insertString("помеченное стилем Normal.", tp, normal);
    insertString("≈ще ќдин «аголовок", tp, heading);
    // мен€ем произольную часть текста
    SimpleAttributeSet red = new SimpleAttributeSet();
    StyleConstants.setForeground(red, Color.red);
    StyledDocument doc = tp.getStyledDocument();
    doc.setCharacterAttributes(5, 5, red, false);
    // добавим компонент в конец текста
    tp.setCaretPosition(doc.getLength());
    JCheckBox check = new JCheckBox("¬се возможно!");
    check.setOpaque(false);
    tp.insertComponent(check);
  }
  // вставл€ет строку в конец документа с переносом,
  // использу€ заданный стиль оформлени€
  private void insertString(String s, JTextPane tp, Style style) {
    try {
      Document doc = tp.getDocument();
      doc.insertString(doc.getLength(), s + "\n", style);
    } catch (BadLocationException ex) {
      ex.printStackTrace();
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new StyledText(); } });
  }
}