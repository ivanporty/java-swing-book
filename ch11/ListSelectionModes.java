// ListSelectionModes.java
// Различные режимы выделения
import javax.swing.*;
import java.awt.*;

public class ListSelectionModes extends JFrame {
  private String[] data = { "Красный", "Синий",
      "Зеленый", "Желтый", "Белый"};
  public ListSelectionModes() {
    super("ListSelectionModes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // заполним модель данными
    DefaultListModel dlm =
        new DefaultListModel();
    for (String next : data)
      dlm.addElement(next);
    // три списка с разным типом выделения
    JList list1 = new JList(dlm);
    list1.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    JList list2 = new JList(dlm);
    list2.setSelectionMode(
        ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    JList list3 = new JList(dlm);
    // аналогично предыдущему вызову
    list3.getSelectionModel().setSelectionMode(
        ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    // добавляем компоненты
    setLayout(new FlowLayout());
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    add(new JScrollPane(list3));
    // выведем окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ListSelectionModes(); } });
  }
}