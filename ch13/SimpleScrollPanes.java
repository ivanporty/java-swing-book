// SimpleScrollPanes.java
// Настройка некоторых простых свойств панелей прокрутки
import javax.swing.*;
import java.awt.*;

public class SimpleScrollPanes extends JFrame {
  public SimpleScrollPanes() {
    super("SimpleScrollPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // надпись
    JLabel label = new JLabel(new ImageIcon("image.jpg"));
    // особый конструктор панели прокрутки
    JScrollPane scrollPane = new JScrollPane(label,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    // некоторые свойства
    scrollPane.setViewportBorder(
        BorderFactory.createLineBorder(Color.BLUE));
    scrollPane.setWheelScrollingEnabled(false);
    // выводим окно на экран
    add(scrollPane);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleScrollPanes(); } });
  }
}