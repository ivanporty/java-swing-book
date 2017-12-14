// PastingClipboard.java
// Вставка данных в системный буфер обмена
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

public class PastingClipboard extends JFrame {
  private JTextArea textArea;
  public PastingClipboard() {
    super("PastingClipboard");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим кнопку для вставки данных
    JButton copyButton = new JButton("Копировать");
    // текстовое поле для получения текста
    textArea = new JTextArea();
    copyButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // буфер обмена
        Clipboard clipboard = Toolkit.getDefaultToolkit().
            getSystemClipboard();
        // вставим в буфер наши адаптированные данные
        clipboard.setContents(new ComplexTransferable(), null);
      }
    });
    add(new JScrollPane(textArea));
    add(copyButton, "South");
    // выведем окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  // объект-адаптер для наших данных
  class ComplexTransferable implements Transferable {
    // список поддерживаемых типов данных
    private DataFlavor[] supportedTypes = new DataFlavor[]
        { DataFlavor.stringFlavor, DataFlavor.imageFlavor };
    public DataFlavor[] getTransferDataFlavors() {
      return supportedTypes;
    }
    public boolean isDataFlavorSupported(DataFlavor flavor) {
      return Arrays.asList(supportedTypes).contains(flavor);
    }
    public Object getTransferData(DataFlavor flavor)
        throws UnsupportedFlavorException, IOException {
      if ( flavor == DataFlavor.imageFlavor ) {
        // если запрошено изображение, вернем красный квадрат
        BufferedImage bi = new
            BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
        return bi;
      } else if ( flavor == DataFlavor.stringFlavor ) {
        // если запрошена строка, вернем выделенный текст
        return textArea.getSelectedText();
      }
      // исключение в случае неизвестного типа данных
      throw new UnsupportedFlavorException(flavor);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new PastingClipboard(); } });
  }
}