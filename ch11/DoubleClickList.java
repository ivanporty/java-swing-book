// DoubleClickList.java
// Получение элемента списка по точке экрана
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DoubleClickList extends JFrame {
  // данные списка
  private String[] data = { "Стейк", "Лобстер",
      "Борщ", "Севрюга"};
  private JList list;
  public DoubleClickList() {
    super("DoubleClickList");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем список
    list = new JList(data);
    list.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    // добавим cлушателя событий от мыши
    list.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if ( e.getClickCount() == 2 ) {
          // получаем элемент и покажем его
          int pos =
              list.locationToIndex(e.getPoint());
          JOptionPane.showMessageDialog(
              list, "Уже готовится: " +
                  list.getModel().getElementAt(pos));
        }
      }
    });
    // выведем окно на экран
    add(new JScrollPane(list));
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new DoubleClickList(); } });
  }
}