// CustomListSelection.java
// Реализация особого режима выделения
import javax.swing.*;
import java.awt.*;

public class CustomListSelection extends JFrame {
  private String[] data = { "Мороженное", "Курица",
      "Холодное", "Горячее"};
  public CustomListSelection() {
    super("CustomListSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // настроим список и добавим его в окно
    JList list = new JList(data);
    list.setSelectionModel(new CustomSelectionModel());
    add(new JScrollPane(list));
    // выведем окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  // специальная модель выделения
  class CustomSelectionModel
      extends DefaultListSelectionModel {
    // добавление интервала выделения
    public void addSelectionInterval(int idx0, int idx1) {
      super.addSelectionInterval(idx0, idx1);
      adjustSelection(idx0);
    }
    // установка интервала выделения
    public void setSelectionInterval(int idx0, int idx1) {
      super.setSelectionInterval(idx0, idx1);
      adjustSelection(idx0);
    }
    // общий метод "подкрутки" выделения
    private void adjustSelection(int idx) {
      if ( idx == 0 )
        addSelectionInterval(2, 2);
      if ( idx == 1 )
        addSelectionInterval(3, 3);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomListSelection(); } });
  }
}