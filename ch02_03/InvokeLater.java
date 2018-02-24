// InvokeLater.java
// Метод invokeLater() и работа с потоком рассылки событий

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InvokeLater extends JFrame {
  public InvokeLater() {
    super("InvokeLater");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим кнопку со слушателем
    button = new JButton("Выполнить сложную работу");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // запустим отдельный поток
        new ComplexJobThread().start();
        button.setText("Подождите...");
      }
    });
    // настроим панель содержимого и выведем окно на экран
    setLayout(new FlowLayout());
    add(new JTextField(20));
    add(button);
    setSize(300, 200);
    setVisible(true);
  }

  private JButton button;

  // поток, выполняющий "сложную работу"
  class ComplexJobThread extends Thread {
    public void run() {
      try {
        // изобразим задержку
        sleep(3000);
        // работа закончена, нужно изменить интерфейс
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            button.setText("Работа завершена");
          }
        });
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    new InvokeLater();
  }
}
