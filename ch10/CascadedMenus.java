// CascadedMenus.java
// Создание вложенных меню любой сложности
import javax.swing.*;
import java.awt.*;

public class CascadedMenus extends JFrame {
  public CascadedMenus() {
    super("CascadedMenus");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // создаем строку главного меню
    JMenuBar menuBar = new JMenuBar();
    // создаем выпадающее меню
    JMenu text = new JMenu("Текст");
    // и несколько вложенных меню
    JMenu style = new JMenu("Стиль");
    JMenuItem bold = new JMenuItem("Жирный");
    JMenuItem italic = new JMenuItem("Курсив");
    JMenu font = new JMenu("Шрифт");
    JMenuItem arial = new JMenuItem("Arial");
    JMenuItem times = new JMenuItem("Times");
    font.add(arial);
    font.add(times);
    // размещаем все в нужном порядке
    style.add(bold);
    style.add(italic);
    style.addSeparator();
    style.add(font);
    text.add(style);
    menuBar.add(text);
    // помещаем меню в окно
    setJMenuBar(menuBar);
    // разделитель может быть полезен не только в меню
    ((JComponent)getContentPane()).setBorder(
      BorderFactory.createEmptyBorder(0, 5, 0, 0));
    add(new JSeparator(SwingConstants.VERTICAL), "West");
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new CascadedMenus(); } });
  }
}