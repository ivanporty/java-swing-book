// SliderEvents.java
// События ползунков
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderEvents extends JFrame {
  public SliderEvents() {
    super("SliderEvents");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // создаем ползунок и надписи
    JSlider slider = new JSlider(0, 900, 0);
    slider.setMajorTickSpacing(100);
    slider.setPaintTicks(true);
    boost = new JLabel("Ускорение: ");
    // присоединяем слушателя
    slider.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // меняем надпись
        int value =
            ((JSlider)e.getSource()).getValue();
        int percent = value/15;
        boost.setText("Ускорение: " + percent + " %");
      }
    });
    // добавляем компоненты в панель
    JPanel contents = new JPanel();
    contents.add(new JLabel("Размер буфера:"));
    contents.add(slider);
    add(contents);
    add(boost, "South");
    // выводим окно на экран
    setSize(360, 100);
    setVisible(true);
  }
  private JLabel boost;
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SliderEvents(); } });
  }
}