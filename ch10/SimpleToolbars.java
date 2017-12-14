// SimpleToolbars.java
// Простые панели инструментов
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleToolbars extends JFrame {
  public SimpleToolbars() {
    super("SimpleToolbars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // первая панель инструментов
    JToolBar toolbar1 = new JToolBar();
    // добавим кнопки
    toolbar1.add(new JButton(
        new ImageIcon("images/New16.gif")));
    toolbar1.add(new JButton(
        new ImageIcon("images/Open16.gif")));
    // разделитель
    toolbar1.addSeparator();
    // добавим команду
    toolbar1.add(new SaveAction());
    // вторая панель инструментов
    JToolBar toolbar2 = new JToolBar();
    // добавим команду
    toolbar2.add(new SaveAction());
    // раскрывающийся список
    toolbar2.add(new JComboBox(new String[] {
        "Жирный", "Обычный" }));
    // добавим панели инструментов в окно
    add(toolbar1, "North");
    add(toolbar2, "South");
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  // команда для панели инструментов
  class SaveAction extends AbstractAction {
    public SaveAction() {
      // настроим значок команды
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("images/Save16.gif"));
      // текст подсказки
      putValue(AbstractAction.SHORT_DESCRIPTION,
          "Сохранить документ...");
    }
    public void actionPerformed(ActionEvent e) {
      // ничего не делаем
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleToolbars(); } });
  }
}