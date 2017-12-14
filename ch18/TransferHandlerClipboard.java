// TransferHandlerClipboard.java
// Копирование в буфер с помощью TransferHandler
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferHandlerClipboard extends JFrame {
  public TransferHandlerClipboard() {
    super("TransferHandlerClipboard");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем модель
    DefaultListModel model = new DefaultListModel();
    model.addElement("Раз");
    model.addElement("Два");
    // список со строками
    final JList list = new JList(model);
    list.setTransferHandler(new ListDrag.ListTransferHandler(list));
    list.setDragEnabled(true);
    list.setDropMode(DropMode.INSERT);
    add(new JScrollPane(list));
    JButton copy = new JButton("Копировать в буфер");
    copy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // необходимо для работы команды
        e.setSource(list);
        // вызываем стандартную команду копирования
        TransferHandler.getCopyAction().actionPerformed(e);
      }
    });
    add(copy, "South");
    // выведем окно на экран
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TransferHandlerClipboard(); } });
  }
}