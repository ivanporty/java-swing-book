// FirstEvents.java
// События - нажатия клавиш на клавиатуре
import javax.swing.*;
import java.awt.event.*;

public class FirstEvents extends JFrame {
  public FirstEvents() {
    super("FirstEvents");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // регистрируем нашего слушателя
    addKeyListener(new KeyL());
    // выводим окно на экран
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new FirstEvents();
          }
        });
  }
}

// этот класс будет получать извещения о событиях
class KeyL implements KeyListener {
  // печать символа
  public void keyTyped(KeyEvent k) {
    System.out.println(k);
  }

  // нажатие клавиши
  public void keyPressed(KeyEvent k) {
    System.out.println(k);
  }

  // отпускание нажатой клавиши
  public void keyReleased(KeyEvent k) {
    System.out.println(k);
  }
}
