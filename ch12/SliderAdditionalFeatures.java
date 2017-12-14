// SliderAdditionalFeatures.java
// Дополнительные возможности ползунков
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SliderAdditionalFeatures extends JFrame {
  public SliderAdditionalFeatures() {
    super("SliderAdditionalFeatures");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // используем стандартную модель
    BoundedRangeModel model =
        new DefaultBoundedRangeModel(10, 0, 0, 60);
    // таблица с надписями
    Dictionary labels = new Hashtable();
    labels.put(0, new JLabel(
        "<html><font color=red size=4>Ноль"));
    labels.put(10, new JLabel(
        "<html><font color=green size=3>Двадцать"));
    labels.put(50, new JLabel(
        "<html><font color=yellow size=5>Много"));
    labels.put(60, new JLabel(
        new ImageIcon("caution.gif")));
    // настройка первого ползунка
    JSlider slider1 = new JSlider(JSlider.VERTICAL);
    slider1.setModel(model);
    slider1.setLabelTable(labels);
    slider1.setPaintLabels(true);
    // "наполняемый" инвертированный ползунок
    JSlider slider2 = new JSlider(model);
    slider2.putClientProperty(
        "JSlider.isFilled", Boolean.TRUE);
    slider2.setInverted(true);
    slider2.setPaintTicks(true);
    slider2.setMajorTickSpacing(10);
    // добавляем компоненты в окно
    setLayout(new FlowLayout());
    add(slider1);
    add(slider2);
    // выводим окно на экран
    setSize(300, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SliderAdditionalFeatures(); } });
  }
}