// ListSelectionEvents.java
// Слежение за выделением списка
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ListSelectionEvents extends JFrame {
  // данные списка
  private String[] data =
      { "Красный", "Желтый", "Зеленый"};
  private JTextArea jta;
  public ListSelectionEvents() {
    super("ListSelectionEvents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем список и текстовое поле
    setLayout(new FlowLayout());
    JList list = new JList(data);
    list.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    jta = new JTextArea(5, 20);
    // добавим слушателя событий выделения
    list.addListSelectionListener(new SelectionL());
    // добавляем компоненты
    add(new JScrollPane(list));
    add(new JScrollPane(jta));
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  // слушатель событий от модели выделения
  class SelectionL implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent lse) {
      int selected =
          ((JList)lse.getSource()).getSelectedIndex();
      switch ( selected ) {
        case 0: jta.setText("Переходить нельзя"); break;
        case 1: jta.setText("Будьте готовы"); break;
        case 2: jta.setText("Переходите улицу");
      }
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ListSelectionEvents(); } });
  }
}