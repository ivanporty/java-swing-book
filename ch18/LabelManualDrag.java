// LabelManualDrag.java
// РџРµСЂРµС‚Р°СЃРєРёРІР°РЅРёРµ Рё РІСЃС‚Р°РІРєР° РґР°РЅРЅС‹С… "РІСЂСѓС‡РЅСѓСЋ"
import javax.swing.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class LabelManualDrag extends JFrame {
  public LabelManualDrag() {
    super("ListDrag");
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    final JLabel label = new JLabel("РџСЂРѕСЃС‚Рѕ С‚РµРєСЃС‚!");
    // СЃС‚Р°РЅРґР°СЂС‚РЅС‹Р№ СЃРїРѕСЃРѕР± РѕР±РјРµРЅР° СЃРІРѕР№СЃС‚РІРѕРј "text"
    label.setTransferHandler(new TransferHandler("text"));
    // РјРѕРјРµРЅС‚ РЅР°С‡Р°Р»Р° РїРµСЂРµС‚Р°СЃРєРёРІР°РЅРёСЏ
    label.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        TransferHandler handler = label.getTransferHandler();
        // РІС‹Р·РѕРІ СЃРёСЃС‚РµРјРЅРѕРіРѕ РїРµСЂРµС‚Р°СЃРєРёРІР°РЅРёСЏ
        handler.exportAsDrag(label, e, TransferHandler.COPY);
      }
    });
    // РґРѕР±Р°РІРёРј С‚РµРєСЃС‚РѕРІРѕРµ РїРѕР»Рµ Рё РЅР°РґРїРёСЃСЊ РЅР° СЌРєСЂР°РЅ
    add(new JScrollPane(new JTextArea()));
    add(label, "South");
    // РІС‹РІРµРґРµРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new LabelManualDrag(); } });
  }
}