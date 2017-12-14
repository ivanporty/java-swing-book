// ListDrag.java
// Перетаскивание и вставка данных и TransferHandler
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ListDrag extends JFrame {
  // начальные данные для списков
  private String[] listData =
      new String[] { "Раз", "Два", "Три" };
  public ListDrag() {
    super("ListDrag");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем модели
    DefaultListModel model1 = new DefaultListModel(),
        model2 = new DefaultListModel();
    for (String element: listData) {
      model1.addElement(element);
      model2.addElement(element);
    }
    // создаем списки
    JList list1 = new JList(model1);
    list1.setTransferHandler(new ListTransferHandler(list1));
    list1.setDragEnabled(true);
    JList list2 = new JList(model2);
    list2.setTransferHandler(new ListTransferHandler(list2));
    list2.setDragEnabled(true);
    // добавим списки на экран
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    // выведем окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  // объект-адаптер для списков и их данных
  static class ListTransferHandler extends TransferHandler {
    private JList list;
    public ListTransferHandler(JList list) {
      this.list = list;
    }
    @Override
    public int getSourceActions(JComponent c) {
      // данные могут копироваться или перемещаться
      return TransferHandler.COPY_OR_MOVE;
    }
    @Override
    public boolean canImport(TransferSupport support) {
      // поддерживается импорт только строковых данных
      return support.isDataFlavorSupported(
          DataFlavor.stringFlavor);
    }
    @Override
    protected Transferable createTransferable(JComponent c) {
      // стандартный способ адаптировать строку для обмена
      return new StringSelection(
          list.getSelectedValue().toString());
    }
    @Override
    public boolean importData(TransferSupport support) {
      if ( support.isDataFlavorSupported(DataFlavor.stringFlavor) ) {
        try {
          // добавляем в модель новую строку на выбранную позицию
          ((DefaultListModel)list.getModel()).
              add(list.locationToIndex(
                  support.getDropLocation().getDropPoint()),
                  // получение строки из Transferable
                  support.getTransferable().
                      getTransferData(DataFlavor.stringFlavor));
          return true;
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return false;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ListDrag(); } });
  }
}