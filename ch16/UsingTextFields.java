// UsingTextFields.java
// Использование текстовых полей Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UsingTextFields extends JFrame {
  // наши поля
  private JTextField smallField, bigField;
  public UsingTextFields() {
    super("UsingTextFields");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем текстовые поля
    smallField = new JTextField(10);
    bigField = new JTextField("Текст поля", 25);
    // дополнительные настройки
    bigField.setFont(new Font("Verdana", Font.PLAIN, 16));
    bigField.setHorizontalAlignment(JTextField.RIGHT);
    // слушатель окончания ввода
    smallField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // показываем введенный текст
        JOptionPane.showMessageDialog(
            UsingTextFields.this,
            "Ваше слово: " +
                smallField.getText());
      }
    });
    // поле с паролем
    JPasswordField password = new JPasswordField(15);
    password.setEchoChar('$');
    // добавляем поля в окно и выводим его на экран
    setLayout(new FlowLayout());
    add(smallField);
    add(bigField);
    add(password);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTextFields(); } });
  }
}
