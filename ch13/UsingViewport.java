// UsingViewport.java
// Работа с "видоискателем" JViewport
import javax.swing.*;
import java.awt.*;

public class UsingViewport extends JFrame {
  public UsingViewport() {
    super("UsingViewport");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // надпись с текстом большого размера
    JLabel bigLabel = new JLabel(
        "<html><h1>Большая Надпись!<br>Много текста!");
    // "видоискатель"
    JViewport viewport = new JViewport();
    // устанавливаем вид и видимый диапазон
    viewport.setView(bigLabel);
    viewport.setExtentSize(new Dimension(100, 60));
    // точка начала видимой области
    viewport.setViewPosition(new Point(50, 50));
    // ограничим размер "видоискателя"
    viewport.setPreferredSize(new Dimension(100, 60));
    // выводим окно на экран
    setLayout(new FlowLayout());
    add(viewport);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingViewport(); } });
  }
}