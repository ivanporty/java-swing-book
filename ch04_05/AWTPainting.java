// AWTPainting.java
// Процесс рисования в AWT очень прост

import java.awt.*;
import java.awt.event.*;

public class AWTPainting extends Frame {

  public AWTPainting() {
    super("AWTPainting");
    // выход при закрытии окна
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setLayout(new FlowLayout());
    // попробуем закрасить часть кнопки
    add(new Button("Перерисуем кнопку!") {
      public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(2, 2, getWidth() - 5, getHeight() - 5);
      }
    });
    setSize(200, 200);
  }

  // в этом методе производится рисование
  public void paint(Graphics g) {
    // заполняем все красным цветом
    g.setColor(Color.RED);
    g.fillRect(0, 0, getWidth(), getHeight());
  }

  public static void main(String[] args) {
    new AWTPainting().setVisible(true);
  }
}
