// InnerClassEvents.java
// Внутренние классы для обработки событий

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerClassEvents extends JFrame {
  private JTextField text;
  private JButton button;

  public InnerClassEvents() {
    super("InnerClassEvents");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // последовательное расположение
    setLayout(new FlowLayout());
    // добавим текстовое поле
    add(text = new JTextField(10));
    // и кнопку
    add(button = new JButton("Нажмите"));
    // будем следить за нажатиями кнопки
    button.addActionListener(new ButtonL());
    // выводим окно на экран
    pack();
    setVisible(true);
  }

  // класс - слушатель нажатия на кнопку
  class ButtonL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println(text.getText());
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new InnerClassEvents();
          }
        });
  }
}
