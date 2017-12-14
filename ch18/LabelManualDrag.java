// LabelManualDrag.java
// Перетаскивание и вставка данных "вручную"
import javax.swing.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class LabelManualDrag extends JFrame {
  public LabelManualDrag() {
    super("ListDrag");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    final JLabel label = new JLabel("Просто текст!");
    // стандартный способ обмена свойством "text"
    label.setTransferHandler(new TransferHandler("text"));
    // момент начала перетаскивания
    label.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        TransferHandler handler = label.getTransferHandler();
        // вызов системного перетаскивания
        handler.exportAsDrag(label, e, TransferHandler.COPY);
      }
    });
    // добавим текстовое поле и надпись на экран
    add(new JScrollPane(new JTextArea()));
    add(label, "South");
    // выведем окно на экран
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new LabelManualDrag(); } });
  }
}