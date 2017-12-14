// PreProcessMouse.java
// Перехват событий от мыши до их поступления к слушателям

import javax.swing.*;
import java.awt.event.*;

public class PreProcessMouse extends JFrame {
  PreProcessMouse() {
    super("PreProcessMouse");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим слушателя событий от мыши
    addMouseListener(new MouseL());
    // выводим окно на экран
    setSize(200, 200);
    setVisible(true);
  }

  // перехват событий от мыши
  public void processMouseEvent(MouseEvent e) {
    if (e.getClickCount() == 1) {
      // один щелчок не пропускаем к слушателям
      return;
    }
    // иначе вызываем метод базового класса
    else super.processMouseEvent(e);
  }

  // в этом слушателе будем следить за щелчками мыши
  class MouseL extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
      System.out.println(
          "ClickCount: " + e.getClickCount());
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new PreProcessMouse();
          }
        });
  }
}
