// CombiningToolbars.java
// Создание комбинированных панелей
// инструментов
import javax.swing.*;
import com.porty.swing.*;
import java.awt.event.*;

public class CombiningToolbars extends JFrame {
  public CombiningToolbars() {
    super("CombiningToolbars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // несколько панелей инструментов
    JToolBar toolbar1 = new JToolBar();
    toolbar1.add(new OpenAction());
    toolbar1.add(new SaveAction());
    toolbar1.addSeparator();
    toolbar1.add(new JButton("Стиль"));
    JToolBar toolbar2 = new JToolBar();
    toolbar2.add(new JButton("Формат"));
    toolbar2.add(new JComboBox(new String[] {
        "Красный", "Зеленый"}));
    JToolBar toolbar3 = new JToolBar();
    toolbar3.add(new JButton("Обычный"));
    toolbar3.add(new JButton("Полужирный"));
    toolbar3.add(new JButton("Подчеркнутый"));
    // выравнивание содержимого
    toolbar2.add(Box.createGlue());
    // добавим две панели инструментов сюда
    JPanel first =
        BoxLayoutUtils.createHorizontalPanel();
    first.add(toolbar1);
    first.add(Box.createHorizontalStrut(5));
    first.add(toolbar2);
    // комбинируем полученные панели
    JPanel all =
        BoxLayoutUtils.createVerticalPanel();
    all.add(first);
    all.add(toolbar3);
    // выравнивание содержимого
    BoxLayoutUtils.setGroupAlignmentX(
        JComponent.LEFT_ALIGNMENT, first, toolbar3);
    // добавим полученное на север окна
    add(all, "North");
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  // несколько команд для панелей инструментов
  class OpenAction extends AbstractAction {
    public OpenAction() {
      // настроим значок команды
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("images/Open16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      // ничего не делаем
    }
  }
  class SaveAction extends AbstractAction {
    public SaveAction() {
      // настроим значок команды
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("images/Save16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      // ничего не делаем
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CombiningToolbars(); } });
  }
}