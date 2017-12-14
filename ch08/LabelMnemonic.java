// LabelMnemonic.java
// Использование надписей для вывода мнемоник
import javax.swing.*;
import java.awt.*;

public class LabelMnemonic extends JFrame {
  public LabelMnemonic() {
    super("LabelMnemonic");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим пару текстовых полей
    JPanel contents = new JPanel(new GridLayout(2,2));
    JTextField tf = new JTextField(10);
    JLabel label = new JLabel("Ваше имя:");
    // настройка мнемоники
    label.setLabelFor(tf);
    label.setDisplayedMnemonic('И');
    // добавляем компоненты в таблицу
    contents.add(new JLabel("Ваша фамилия:"));
    contents.add(new JTextField(10));
    contents.add(label);
    contents.add(tf);
    // выведем окно на экран
    setContentPane(contents);
    pack();
    setVisible(true);
  }
  public static void main(String args[]) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new LabelMnemonic(); } });
  }
}
