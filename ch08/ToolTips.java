// ToolTips.java
// Подсказки в Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolTips extends JFrame {
  public ToolTips() {
    super("ToolTips");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим несколько кнопок с подсказками
    JButton b1 = new JButton("Один");
    b1.setToolTipText("Это первая кнопка");
    JButton b2 = new JButton() {
      public Point getToolTipLocation(MouseEvent e) {
        return new Point(10, 10);
      }
      public String getToolTipText(MouseEvent e) {
        if ( e.getY() > 10 ) {
          return "Нижняя часть кнопки!";
        }
        return super.getToolTipText(e);
      }
    };
    b2.setText("Два");
    b2.setToolTipText("<html><h3>Это вторая кнопка.<ul>" +
        "Она:<li>Ничего не делает<li>Но ее можно нажать!");
    JPanel contents = new JPanel();
    contents.add(b1);
    contents.add(b2);
    // выводим окно на экран
    add(contents);
    setSize(400, 150);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ToolTips(); } });
  }
}