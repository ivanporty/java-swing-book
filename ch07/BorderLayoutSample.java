// BorderLayoutSample.java
// Полярное расположение
import javax.swing.*;
import java.awt.*;

public class BorderLayoutSample extends JFrame {
  public BorderLayoutSample()  {
    super("BorderLayoutSample");
    setSize(400, 300);
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // добавляем компоненты
    // в качестве параметров можно использовать строки
    add(new JButton("Север"), "North");
    add(new JButton("Юг"), "South");
    // … или константы из класса BorderLayout
    add(new JLabel("Запад"), BorderLayout.WEST);
    add(new JLabel("Восток"), BorderLayout.EAST);
    // если параметр не указывать вовсе, компонент
    // автоматически добавится в центр
    add(new JButton("Центр"));
    // выводим окно на экран
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BorderLayoutSample(); } });
  }
}
