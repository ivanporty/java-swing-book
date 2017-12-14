// PastingClipboard.java
// Р’СЃС‚Р°РІРєР° РґР°РЅРЅС‹С… РІ СЃРёСЃС‚РµРјРЅС‹Р№ Р±СѓС„РµСЂ РѕР±РјРµРЅР°
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
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РґРѕР±Р°РІРёРј РєРЅРѕРїРєСѓ РґР»СЏ РІСЃС‚Р°РІРєРё РґР°РЅРЅС‹С…
    JButton copyButton = new JButton("РљРѕРїРёСЂРѕРІР°С‚СЊ");
    // С‚РµРєСЃС‚РѕРІРѕРµ РїРѕР»Рµ РґР»СЏ РїРѕР»СѓС‡РµРЅРёСЏ С‚РµРєСЃС‚Р°
    textArea = new JTextArea();
    copyButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Р±СѓС„РµСЂ РѕР±РјРµРЅР°
        Clipboard clipboard = Toolkit.getDefaultToolkit().
            getSystemClipboard();
        // РІСЃС‚Р°РІРёРј РІ Р±СѓС„РµСЂ РЅР°С€Рё Р°РґР°РїС‚РёСЂРѕРІР°РЅРЅС‹Рµ РґР°РЅРЅС‹Рµ
        clipboard.setContents(new ComplexTransferable(), null);
      }
    });
    add(new JScrollPane(textArea));
    add(copyButton, "South");
    // РІС‹РІРµРґРµРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(400, 300);
    setVisible(true);
  }
  // РѕР±СЉРµРєС‚-Р°РґР°РїС‚РµСЂ РґР»СЏ РЅР°С€РёС… РґР°РЅРЅС‹С…
  class ComplexTransferable implements Transferable {
    // СЃРїРёСЃРѕРє РїРѕРґРґРµСЂР¶РёРІР°РµРјС‹С… С‚РёРїРѕРІ РґР°РЅРЅС‹С…
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
        // РµСЃР»Рё Р·Р°РїСЂРѕС€РµРЅРѕ РёР·РѕР±СЂР°Р¶РµРЅРёРµ, РІРµСЂРЅРµРј РєСЂР°СЃРЅС‹Р№ РєРІР°РґСЂР°С‚
        BufferedImage bi = new
            BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
        return bi;
      } else if ( flavor == DataFlavor.stringFlavor ) {
        // РµСЃР»Рё Р·Р°РїСЂРѕС€РµРЅР° СЃС‚СЂРѕРєР°, РІРµСЂРЅРµРј РІС‹РґРµР»РµРЅРЅС‹Р№ С‚РµРєСЃС‚
        return textArea.getSelectedText();
      }
      // РёСЃРєР»СЋС‡РµРЅРёРµ РІ СЃР»СѓС‡Р°Рµ РЅРµРёР·РІРµСЃС‚РЅРѕРіРѕ С‚РёРїР° РґР°РЅРЅС‹С…
      throw new UnsupportedFlavorException(flavor);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new PastingClipboard(); } });
  }
}