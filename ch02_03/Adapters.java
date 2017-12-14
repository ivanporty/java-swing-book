// Adapters.java
// Использование адаптеров вместо интерфейсов

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Adapters extends JFrame {
  public Adapters() {
    super("Adapters");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // регистрируем слушателя
    addMouseListener(new MouseL());
    // выводим окно на экран
    setSize(200, 200);
    setVisible(true);
  }

  // наследуем от адаптера
  class MouseL extends MouseAdapter {
    // следим за щелчками мыши в окне
    @Override
    public void mouseClicked(MouseEvent e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new Adapters();
          }
        });
  }
}
