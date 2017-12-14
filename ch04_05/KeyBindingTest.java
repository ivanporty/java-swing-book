// KeyBindingTest.java
// Пример использования клавитурных сокращений

import javax.swing.*;
import java.awt.event.*;

public class KeyBindingTest extends JFrame {
  public KeyBindingTest() {
    super("KeyBindingTest");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // настраиваем карты команд и входных событий для
    // корневой панели приложения
    InputMap im = getRootPane().getInputMap();
    ActionMap am = getRootPane().getActionMap();
    // срабатывает при отпускании сочетания Ctrl+A
    im.put(KeyStroke.getKeyStroke(
        KeyEvent.VK_A,
        KeyEvent.CTRL_MASK, true), "Action");
    // срабатывает при печати буквы 'Я'
    im.put(KeyStroke.getKeyStroke('Я'), "Action");
    am.put("Action", new AnAction());
    // выводим окно на экран
    setSize(200, 200);
    setVisible(true);
  }

  // класс нашей команды
  class AnAction extends AbstractAction {
    public void actionPerformed(ActionEvent e) {
      System.out.println("OK");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new KeyBindingTest(); } });
  }
}
