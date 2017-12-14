// GoodMenu.java
// Клавиатурные комбинации и мнемоники для меню Swing
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GoodMenu extends JFrame {
  public GoodMenu() {
    super("GoodMenu");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // создаем строку главного меню
    JMenuBar menuBar = new JMenuBar();
    // некоторые весьма часто встречающиеся
    // выпадающие меню
    menuBar.add(createFileMenu());
    menuBar.add(createEditMenu());
    // поместим меню в наше окно
    setJMenuBar(menuBar);
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  // создает меню "Файл"
  private JMenu createFileMenu() {
    // выпадающее меню
    JMenu file = new JMenu("Файл");
    file.setMnemonic('Ф');
    // пункт меню "Открыть"
    JMenuItem open = new JMenuItem("Открыть");
    open.setMnemonic('О'); // русская буква
    // установим клавишу быстрого доступа (латинская буква)
    open.setAccelerator(
      KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
    // пункт меню "Сохранить"
    JMenuItem save = new JMenuItem("Сохранить");
    save.setMnemonic('С');
    save.setAccelerator(
      KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
    // добавим все в меню
    file.add(open);
    file.add(save);
    return file;
  }
  // создает меню "Правка"
  private JMenu createEditMenu() {
    // выпадающее меню
    JMenu edit = new JMenu("Правка");
    edit.setMnemonic('П');
    // пункт меню "Вырезать"
    JMenuItem cut = new JMenuItem("Вырезать");
    cut.setMnemonic('В');
    cut.setAccelerator(
      KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK));
    // пункт меню "Копировать"
    JMenuItem copy = new JMenuItem("Копировать");
    copy.setMnemonic('К');
    // клавишу быстрого доступа можно создать и так
    copy.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
    // готово
    edit.add(cut);
    edit.add(copy);
    return edit;
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new GoodMenu(); } });
  }
}
