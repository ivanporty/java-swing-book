// ButtonEvents.java
// Обработка событий от кнопок JButton
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonEvents extends JFrame {
  private JTextArea info;
  public ButtonEvents() {
    super("ButtonEvents");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // создаем кнопку и помещаем ее на север окна
    JButton button = new JButton("Нажмите меня!");
    add(button, "North");
    // поле для вывода сообщений о событиях
    info = new JTextArea("Пока событий не было\n");
    add(new JScrollPane(info));
    // привязываем к нашей кнопке слушателей событий
    // слушатели описаны как внутренние классы
    button.addActionListener(new ActionL());
    button.addChangeListener(new ChangeL());
    // присоединение слушателя прямо на месте
    button.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        info.append("Это вы все равно не увидите");
      }
    });
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  class ActionL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      info.append(
          "Получено сообщение о нажатии кнопки! От - "
              + e.getActionCommand() + "\n");
    }
  }
  class ChangeL implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
      info.append(
          "Получено сообщение о смене состояния кнопки!\n");
      // это источник события
      Object src = e.getSource();
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonEvents(); } });
  }
}