// UsingEventQueue.java
// Использование очереди событий

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsingEventQueue extends JFrame {
  public UsingEventQueue() {
    super("UsingEventQueue");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // кнопка и ее слушатель
    JButton button = new JButton("Генерировать событие");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // генерируем событие закрытия окна
        getToolkit().getSystemEventQueue().postEvent(
            new WindowEvent(UsingEventQueue.this,
                WindowEvent.WINDOW_CLOSING));
      }
    });
    // добавим кнопку в панель содержимого
    setLayout(new FlowLayout());
    add(button);
    // выведем окно на экран
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new UsingEventQueue();
          }
        });
  }
}
