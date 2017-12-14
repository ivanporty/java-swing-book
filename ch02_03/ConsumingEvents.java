// ConsumingEvents.java
// Поглощение событий

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsumingEvents extends JFrame {
  public ConsumingEvents() {
    super("ConsumingEvents");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // слушатель, поглощающий печатание символов
    KeyListener kl = new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    };
    // добавляем текстовые поля
    setLayout(new FlowLayout());
    JTextField swingField = new JTextField(10);
    swingField.addKeyListener(kl);
    add(swingField);
    TextField awtField = new TextField(10);
    add(awtField);
    awtField.addKeyListener(kl);
    // кнопка
    JButton button = new JButton("Жмите!");
    add(button);
    // слушатель пытается поглотить события от мыши
    button.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        e.consume();
      }
    });
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new ConsumingEvents();
          }
        });
  }
}
