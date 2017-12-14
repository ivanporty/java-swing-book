// SimpleButtonTest.java
// Обработка события нового компонента

import javax.swing.*;

import com.porty.swing.*;
import com.porty.swing.event.*;

import java.awt.*;

public class SimpleButtonTest extends JFrame {
  public SimpleButtonTest() {
    super("SimpleButtonTest");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем кнопку и присоединим слушателей
    SimpleButton button = new SimpleButton();
    // анонимный класс
    button.addButtonPressListener(
        new ButtonPressListener() {
          public void buttonPressed(ButtonPressEvent e) {
            System.out.println("1!");
          }
        });
    // внутренний класс
    button.addButtonPressListener(new ButtonL());
    // добавим кнопку в окно
    JPanel contents = new JPanel();
    contents.add(button);
    setContentPane(contents);
    // выведем окно на экран
    setSize(400, 300);
    setVisible(true);
  }

  class ButtonL implements ButtonPressListener {
    public void buttonPressed(ButtonPressEvent e) {
      System.out.println("2!");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new SimpleButtonTest();
          }
        });
  }
}
