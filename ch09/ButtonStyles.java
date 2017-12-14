// ButtonStyles.java
// Изменение внешнего вида кнопок JButton
// с помощью значков, цветов, рамок и т. п.
import javax.swing.*;
import java.awt.*;

public class ButtonStyles extends JFrame {
  public ButtonStyles() {
    super("ButtonStyles");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // используем последовательное расположение
    setLayout(
        new FlowLayout( FlowLayout.LEFT, 10, 10));
    // самая простая кнопка
    JButton button = new JButton("Обычная кнопка");
    add(button);
    // кнопка со значками на все случаи жизни
    button = new JButton();
    button.setIcon(new ImageIcon("images/b1.gif"));
    button.setRolloverIcon(
        new ImageIcon("images/b1r.gif"));
    button.setPressedIcon(
        new ImageIcon("images/b1p.gif"));
    button.setDisabledIcon(
        new ImageIcon("images/b1d.gif"));
    // для такой кнопки лучше убрать
    // все ненужные рамки и закраску
    button.setBorderPainted(false);
    button.setFocusPainted(false);
    button.setContentAreaFilled(false);
    add(button);
    // кнопка с измененным цветом и HTML-текстом
    button = new JButton(
        "<html><h2><font color=\"yellow\">Зеленая кнопка");
    button.setBackground(Color.green);
    add(button);
    // изменение выравнивания текста и изображения
    button = new JButton("Изменение выравнивания",
        new ImageIcon("images/button.gif"));
    button.setMargin(new Insets(10, 10, 10, 10));
    button.setVerticalAlignment(SwingConstants.TOP);
    button.setHorizontalAlignment(SwingConstants.RIGHT);
    button.setHorizontalTextPosition(SwingConstants.LEFT);
    button.setVerticalTextPosition(SwingConstants.BOTTOM);
    button.setIconTextGap(10);
    // сделаем кнопку большой, чтобы увидеть выравнивание
    button.setPreferredSize(new Dimension(300, 100));
    add(button);
    // отключенная кнопка
    button = new JButton("Выключено");
    button.setEnabled(false);
    add(button);
    // выводим окно на экран
    setSize(400, 350);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonStyles(); } });
  }
}
