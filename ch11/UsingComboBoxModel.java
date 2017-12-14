// UsingComboBoxModel.java
// »спользование стандартной модели раскрывающихс€ списков
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UsingComboBoxModel extends JFrame {
  // наша стандартна€ модель
  private DefaultComboBoxModel cbm;
  public UsingComboBoxModel() {
    super("UsingComboBoxModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем стандартную модель и наполн€ем ее данными
    cbm = new DefaultComboBoxModel();
    for (int i=0; i<10; i++) {
      cbm.addElement("Ёлемент списка є: " + i);
    }
    // смен€ем выбранный элемент
    cbm.setSelectedItem(cbm.getElementAt(4));
    // список на основе нашей модели
    JComboBox combo = new JComboBox(cbm);
    combo.setMaximumRowCount(5);
    // стандартна€ модель позвол€ет
    // динамически манипулировать данными
    JButton add = new JButton("ƒобавить");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // случайно выбираем позицию
        int pos = (int) (Math.random()*cbm.getSize());
        cbm.insertElementAt("Ќовинка!", pos);
      }
    });
    // добавл€ем список и кнопку в панель
    setLayout(new FlowLayout());
    add(combo);
    add(add);
    // выводим окно на экран
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingComboBoxModel(); } });
  }
}