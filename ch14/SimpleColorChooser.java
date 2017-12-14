// SimpleColorChooser.java
// Выбор цвета с помощью JColorChooser
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleColorChooser extends JFrame {
  public SimpleColorChooser() {
    super("SimpleColorChooser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // кнопка выводит на экран окно выбора цвета
    JButton choose = new JButton("Выбор цвета фона");
    choose.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Color color = JColorChooser.showDialog(
            SimpleColorChooser.this,
            "Выберите цвет фона",
            getContentPane().getBackground());
        // если цвет выбран, используем его
        if ( color != null)
          getContentPane().setBackground(color);
        repaint();
      }
    });
    // выводим окно на экран
    setLayout(new FlowLayout());
    add(choose);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleColorChooser(); } });
  }
}
