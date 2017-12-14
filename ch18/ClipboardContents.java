// ClipboardContents.java
// Доступ к содержимому буфера обмена
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.*;

public class ClipboardContents extends JFrame {
  public ClipboardContents() {
    super("ClipboardContents");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим кнопку получения содержимого
    JButton getButton = new JButton("Получить");
    // текстовое поле для вывода данных
    final JTextArea textArea = new JTextArea();
    getButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          // буфер обмена
          Clipboard clipboard = Toolkit.getDefaultToolkit().
              getSystemClipboard();
          // выведем все типы данных
          for (DataFlavor next:
              clipboard.getAvailableDataFlavors()) {
            textArea.append(next.toString() + "\n");
            // попытка получить сами данные
            textArea.append(clipboard.
                getData(next).toString() + "\n");
          }
        } catch (UnsupportedFlavorException ex) {
          ex.printStackTrace();
        } catch (IOException ex) {
          ex.printStackTrace();
        }

      }
    });
    add(new JScrollPane(textArea));
    add(getButton, "South");
    // выведем окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ClipboardContents(); } });
  }
}