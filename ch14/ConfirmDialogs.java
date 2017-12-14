// ConfirmDialogs.java
// Стандартные диалоговые окна для получения от
// пользователя подтверждения совершаемого действия
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ConfirmDialogs extends JFrame {
  // значок для одного из сообщений
  private Icon icon = new ImageIcon("goblet.png");
  public ConfirmDialogs() {
    super("ConfirmDialogs");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // после щелчков на кнопках выводятся сообщения
    JButton confirm1 = new JButton("2 и 4 параметра");
    confirm1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // диалоговое окно c 4-мя параметрами
        int res = JOptionPane.showConfirmDialog(
            ConfirmDialogs.this, "Вы этого хотите?",
            "Вопрос",
            JOptionPane.YES_NO_CANCEL_OPTION);
        // простейшие диалоговые окна
        if ( res == JOptionPane.YES_OPTION )
          JOptionPane.showConfirmDialog(
              ConfirmDialogs.this, "Точно хотите?");
        if ( res == JOptionPane.NO_OPTION )
          JOptionPane.showConfirmDialog(
              ConfirmDialogs.this,
              "Значит, не хотите?");
      }
    });
    JButton confirm2 = new JButton("5 параметров");
    confirm2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(
            ConfirmDialogs.this,
            "Думайте тщательно, итак...",
            "Может произойти ошибка!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE);
      }
    });
    JButton confirm3 = new JButton("6 параметров");
    confirm3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(
            ConfirmDialogs.this, "Вам нравится значок?",
            "Полностью настроенное окно!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE, icon);
      }
    });
    // добавляем кнопки в окно
    setLayout(new FlowLayout());
    add(confirm1);
    add(confirm2);
    add(confirm3);
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ConfirmDialogs(); } });
  }
}
