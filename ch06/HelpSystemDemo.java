// HelpSystemDemo.java
// Как прозрачная панель может помочь в создании
// системы помощи
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelpSystemDemo extends JFrame {
  // необходимые нам поля
  private JButton button1, button2, help;
  private HelpSystem hs = new HelpSystem();
  private InterceptPane ip = new InterceptPane();
  private ImageIcon helpIcon = new ImageIcon("Help.gif");

  public HelpSystemDemo() {
    super("HelpSystemDemo");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем нащ интерфейс
    button1 = new JButton("Что-то делает");
    button2 = new JButton("Тоже что-то делает");
    JPanel contents = new JPanel();
    contents.add(button1);
    contents.add(button2);
    // кнопка вызова помощи
    help = new JButton(helpIcon);
    help.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // при нажатии включаем прозрачную панель
        ip.setVisible(true);
        // и специальный указатель мыши
        getRootPane().setCursor(getToolkit().
            createCustomCursor(helpIcon.getImage(),
            new Point(0, 0), ""));
      }
    });
    contents.add(help);
    // настраиваем наш интерфейс и прозрачную панель
    setContentPane(contents);
    setGlassPane(ip);
    // выводим окно на экран
    setSize(200, 200);
    setVisible(true);
  }
  // компонент, перехватывающий события
  class InterceptPane extends JComponent {
    InterceptPane() {
      // надо включить события от мыши
      enableEvents(MouseEvent.MOUSE_EVENT_MASK);
      enableEvents(KeyEvent.KEY_EVENT_MASK);
      // по умолчанию невидим и прозрачен
      setVisible(false);
      setOpaque(false);
    }
    // перехватываем события от мыши
    public void processMouseEvent(MouseEvent e) {
      // отслеживаем нажатия мыши
      if ( e.getID() == MouseEvent.MOUSE_PRESSED) {
        // определяем, какой компонент был выбран
        Component contentPane = getContentPane();
        MouseEvent ne =
            SwingUtilities.convertMouseEvent(
                this, e, contentPane);
        // видимый компонент в указанных координатах
        Component visibleComp =
            SwingUtilities.getDeepestComponentAt(
                contentPane, ne.getX(), ne.getY());
        // показываем справочную информацию
        JOptionPane.showMessageDialog(
            null, hs.getHelpFor(visibleComp));
        // отключаемся
        setVisible(false);
        // возвращаем на место обычный указатель мыши
        getRootPane().setCursor(
            Cursor.getDefaultCursor());
      }
    }
  }
  // прототип системы помощи
  class HelpSystem {
    // получает помощь для компонентов
    public String getHelpFor(Component comp) {
      if ( comp == button1)
        return "Останавливает реактор. Лучше не жмите";
      else if ( comp == button2 )
        return "Хотите лимонада? Тогда жмите смело!";
      return "Даже и не знаю, что это такое";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HelpSystemDemo(); } });
  }
}