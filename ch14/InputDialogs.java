// InputDialogs.java
// Стандартные диалоговые окна JOptionPane для ввода данных
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InputDialogs extends JFrame {
  // значок для одного из сообщений
  private ImageIcon icon = new ImageIcon("question.gif");
  // данные для выбора
  private String[] values = {"Белый","Красный","Зеленый" };
  public InputDialogs() {
    super("InputDialogs");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // после щелчков на кнопках выводятся сообщения
    JButton input1 = new JButton("2 и 3 параметра");
    input1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ввод строки в текстовом поле
        String res = JOptionPane.showInputDialog(
            InputDialogs.this,
            "<html><h2>Светит ли солнце?");
        res = JOptionPane.showInputDialog(
            InputDialogs.this,
            "Ваш ответ был таким?", res);
      }
    });
    JButton input2 = new JButton("4 параметра");
    input2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // позволяет задавать тип и заголовок
        String res = JOptionPane.showInputDialog(
            InputDialogs.this, new String[] {
            "Пароль введен неверно!", "Повторите ввод:"},
            "Пароль", JOptionPane.WARNING_MESSAGE);
      }
    });
    JButton input3 = new JButton("7 параметров");
    input3.addActionListener(new ActionListener() {
      // выбор из нескольких альтернатив
      public void actionPerformed(ActionEvent e) {
        Object res = JOptionPane.showInputDialog(
            InputDialogs.this,"Выберите любимый цвет:",
            "Выбор цвета", JOptionPane.QUESTION_MESSAGE,
            icon, values, values[0]);
        JOptionPane.showMessageDialog(
            InputDialogs.this, res);
      }
    });
    // добавляем кнопки в окно
    setLayout(new FlowLayout());
    add(input1);
    add(input2);
    add(input3);
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new InputDialogs(); } });
  }
}
