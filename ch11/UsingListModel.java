// UsingListModel.java
// Использование стандартной модели списка
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UsingListModel extends JFrame {
  // наша модель
  private DefaultListModel dlm;
  public UsingListModel() {
    super("UsingListModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // заполним модель данными
    dlm = new DefaultListModel();
    dlm.add(0, "Кое-что");
    dlm.add(0, "Кое-что еще");
    dlm.add(0, "Еще немного");
    // создаем кнопку и пару списков
    JButton add = new JButton("Обновить");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dlm.add(0, "Новинка!");
      }
    });
    JList list1 = new JList(dlm);
    JList list2 = new JList(dlm);
    // добавляем компоненты
    setLayout(new FlowLayout());
    add(add);
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    // выведем окно на экран
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingListModel(); } });
  }
}
