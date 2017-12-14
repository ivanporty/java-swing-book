// MaskingEvents.java
// Маскирование событий

import java.awt.*;
import javax.swing.*;

public class MaskingEvents extends JFrame {
  public MaskingEvents() {
    super("MaskingEvents");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // отключим события от окна
    disableEvents(AWTEvent.WINDOW_EVENT_MASK);
    // добавим особую кнопку
    JPanel contents = new JPanel();
    contents.add(new CustomButton("Привет!"));
    setContentPane(contents);
    // выведем окно на экран
    setSize(400, 300);
    setVisible(true);
  }

  // особая кнопка
  class CustomButton extends JButton {
    public CustomButton(String label) {
      super(label);
      // отключаем события с клавиатуры и от мыши
      disableEvents(AWTEvent.KEY_EVENT_MASK);
      disableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new MaskingEvents();
          }
        });
  }
}
