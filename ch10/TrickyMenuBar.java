// TrickyMenuBar.java
// Полоска меню JMenuBar может многое
import javax.swing.*;
import java.awt.*;

public class TrickyMenuBar extends JFrame {
  public TrickyMenuBar() {
    super("TrickyMenuBar");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // создаем главную полоску меню
    JMenuBar menuBar = new JMenuBar();
    // добавляем в нее выпадающие меню
    menuBar.add(new JMenu("Файл"));
    menuBar.add(new JMenu("Правка"));
    // мы знаем, что используется блочное
    // расположение, так что заполнитель
    // вполне уместен
    menuBar.add(Box.createHorizontalGlue());
    // теперь поместим в полоску меню
    // не выпадающее меню, а надпись со значком
    JLabel icon = new JLabel(
        new ImageIcon("images/download.gif"));
    icon.setBorder(
        BorderFactory.createLoweredBevelBorder());
    menuBar.add(icon);
    // помещаем меню в наше окно
    setJMenuBar(menuBar);
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new TrickyMenuBar(); } });
  }
}
