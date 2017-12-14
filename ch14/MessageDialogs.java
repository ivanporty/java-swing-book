// MessageDialogs.java
// Методы JOptionPane для вывода соообщений
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MessageDialogs extends JFrame {
  // этот значок выведем в одном из сообщений
  private ImageIcon icon = new ImageIcon("question.gif");
  public MessageDialogs() {
    super("MessageDialogs");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // кнопки, после щелчков на которых
    // выводятся сообщения
    JButton message1 = new JButton("2 параметра");
    message1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            MessageDialogs.this,
            "<html><h2>Привет!<br>HTML есть и здесь!");
      }
    });
    JButton message2 = new JButton("4 параметра");
    message2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            MessageDialogs.this,new String[] {
            "Сообщение может быть",
            "записано массивом!" }, "Свой заголовок",
            JOptionPane.ERROR_MESSAGE);
      }
    });
    JButton message3 = new JButton("5 параметров");
    message3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            MessageDialogs.this,
            "Настроено все что можно", "Свой заголовок",
            JOptionPane.INFORMATION_MESSAGE, icon);
      }
    });
    // выведем окно на экран
    setLayout(new FlowLayout());
    add(message1);
    add(message2);
    add(message3);
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new MessageDialogs(); } });
  }
}