// ClipboardContents.java
// Р”РѕСЃС‚СѓРї Рє СЃРѕРґРµСЂР¶РёРјРѕРјСѓ Р±СѓС„РµСЂР° РѕР±РјРµРЅР°
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
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РґРѕР±Р°РІРёРј РєРЅРѕРїРєСѓ РїРѕР»СѓС‡РµРЅРёСЏ СЃРѕРґРµСЂР¶РёРјРѕРіРѕ
    JButton getButton = new JButton("РџРѕР»СѓС‡РёС‚СЊ");
    // С‚РµРєСЃС‚РѕРІРѕРµ РїРѕР»Рµ РґР»СЏ РІС‹РІРѕРґР° РґР°РЅРЅС‹С…
    final JTextArea textArea = new JTextArea();
    getButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          // Р±СѓС„РµСЂ РѕР±РјРµРЅР°
          Clipboard clipboard = Toolkit.getDefaultToolkit().
              getSystemClipboard();
          // РІС‹РІРµРґРµРј РІСЃРµ С‚РёРїС‹ РґР°РЅРЅС‹С…
          for (DataFlavor next:
              clipboard.getAvailableDataFlavors()) {
            textArea.append(next.toString() + "\n");
            // РїРѕРїС‹С‚РєР° РїРѕР»СѓС‡РёС‚СЊ СЃР°РјРё РґР°РЅРЅС‹Рµ
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
    // РІС‹РІРµРґРµРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ClipboardContents(); } });
  }
}