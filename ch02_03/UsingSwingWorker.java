// UsingSwingWorker.java
// Класс SwingWorker для отзывчивости интерфейса

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class UsingSwingWorker extends JFrame {
  private JButton button;

  public UsingSwingWorker() {
    super("UsingSwingWorker");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим кнопку со слушателем
    button = new JButton("Выполнить сложную работу");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // запустим отдельную долгую работу
        new ComplexJob().execute();
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

  // класс, выполняющий "сложную работу"
  class ComplexJob extends SwingWorker<String, String> {
    // здесь выполняется работа, это отдельный поток!
    public String doInBackground() throws Exception {
      Thread.sleep(2000);
      // публикуем промежуточные результаты
      publish("Половина работы закончена...");
      Thread.sleep(2000);
      return "";
    }

    // обработка промежуточных результатов
    // это поток рассылки событий!
    public void process(List<String> chunks) {
      button.setText(chunks.get(0));
    }

    // окончание работы - и вновь это поток рассылки
    public void done() {
      button.setText("Работа завершена");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new UsingSwingWorker();
          }
        });
  }
}