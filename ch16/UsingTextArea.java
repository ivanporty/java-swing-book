// UsingTextArea.java
// »спользование многострочных полей
import javax.swing.*;
import java.awt.*;

public class UsingTextArea extends JFrame {
  public UsingTextArea() {
    super("UsingTextArea");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем пару многострочных полей
    JTextArea area1 = new JTextArea(
        "ћногострочное поле", 5, 10);
    // нестандартный шрифт и табул€ци€
    area1.setFont(new Font("Dialog", Font.PLAIN, 14));
    area1.setTabSize(10);
    JTextArea area2 = new JTextArea(15, 10);
    // параметры переноса слов
    area2.setLineWrap(true);
    area2.setWrapStyleWord(true);
    // добавим пол€ в окно
    setLayout(new FlowLayout());
    add(new JScrollPane(area1));
    add(new JScrollPane(area2));
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTextArea(); } });
  }
}