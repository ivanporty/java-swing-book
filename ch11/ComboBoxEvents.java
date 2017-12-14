// ComboBoxEvents.java
// События раскрывающихся списков
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ComboBoxEvents extends JFrame {
  // данные для списков
  private String[] data = { "США", "Италия",
      "Швейцария", "Таиланд" };
  public ComboBoxEvents() {
    super("ComboBoxEvents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // первый список
    JComboBox combo1 = new JComboBox(data);
    // слушатель смены выбранного элемента
    combo1.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        // выясняем, что случилось
        if ( e.getStateChange() ==
            ItemEvent.SELECTED ) {
          // покажем выбранный элемент
          Object item = e.getItem();
          JOptionPane.showMessageDialog(
              ComboBoxEvents.this, item);
        }
      }
    });
    // список, позволяющий редактирование
    final JComboBox combo2 = new JComboBox(data);
    combo2.setEditable(true);
    // слушатель окончания редактирования
    combo2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // покажем выбор пользователя
        Object item = combo2.getModel().
            getSelectedItem();
        JOptionPane.showMessageDialog(
            ComboBoxEvents.this, item);
      }
    });
    // добавим списки в окно
    setLayout(new FlowLayout());
    add(combo1);
    add(combo2);
    // выведем окно на экран
    setSize(350, 250);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ComboBoxEvents(); } });
  }
}
