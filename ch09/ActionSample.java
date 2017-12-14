// ActionSample.java
// Использование архитектуры Action
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionSample extends JFrame {
  public ActionSample() {
    super("ActionSample");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // используем последовательное расположение
    setLayout(new FlowLayout());
    // создадим пару кнопок, выполняющих
    // одно действие
    Action action = new SimpleAction();
    JButton button1 = new JButton(action);
    JButton button2 = new JButton(action);
    add(button1);
    add(button2);
    // выводим окно на экран
    setSize(300, 100);
    setVisible(true);
  }
  // этот внутренний класс инкапсулирует нашу команду
  class SimpleAction extends AbstractAction {
    SimpleAction() {
      // установим параметры команды
      putValue(NAME, "Привет, Action!");
      putValue(SHORT_DESCRIPTION, "Это подсказка");
      putValue(MNEMONIC_KEY, new Integer('A'));
    }
    // в этом методе обрабатывается событие, как
    // и в прежнем методе ActionListener
    public void actionPerformed(ActionEvent e) {
      // можно выключить команду, не зная, к
      // каким компонентам она присоединена
      setEnabled(false);
      // изменим надпись
      putValue(NAME, "Прощай, Action!");
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ActionSample(); } });
  }
}