// ConfirmClosing.java
// Подтверждение о выходе из приложения
import javax.swing.*;
import java.awt.event.*;

public class ConfirmClosing extends JFrame {
  public ConfirmClosing() {
    super("Приложение");
    // отключаем операцию закрытия
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    // добавляем слушателя событий от окна
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // потверждение выхода
        int res = JOptionPane.
         showConfirmDialog(null, "Действительно выйти?");
        if ( res == JOptionPane.YES_OPTION )
         System.exit(0);
      }
      });
    // выводим окно на экран
    setSize(200, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new ConfirmClosing(); } });
  }
}
