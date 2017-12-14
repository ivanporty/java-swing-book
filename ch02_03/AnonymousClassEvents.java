// AnonymousClassEvents.java
// јнонимные классы дл€ обработки событий

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AnonymousClassEvents extends JFrame {
  public AnonymousClassEvents() {
    super("AnonymousClassEvents");
    // анонимный класс присоедин€етс€ пр€мо на месте
    // выход из приложени€ при закрытии окна
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    // добавим кнопку
    JButton button = new JButton("Ќажмите мен€");
    getContentPane().add(button);
    // слушатель создаетс€ в методе
    button.addActionListener(getButtonL());
    // выводим окно на экран
    pack();
    setVisible(true);
  }

  // этот метод создает слушател€ дл€ кнопки
  public ActionListener getButtonL() {
    return new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("ActionListener");
      }
    };
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new AnonymousClassEvents();
          }
        });
  }
}
