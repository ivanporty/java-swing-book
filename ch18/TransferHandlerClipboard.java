// TransferHandlerClipboard.java
// РљРѕРїРёСЂРѕРІР°РЅРёРµ РІ Р±СѓС„РµСЂ СЃ РїРѕРјРѕС‰СЊСЋ TransferHandler
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferHandlerClipboard extends JFrame {
  public TransferHandlerClipboard() {
    super("TransferHandlerClipboard");
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // СЃРѕР·РґР°РµРј РјРѕРґРµР»СЊ
    DefaultListModel model = new DefaultListModel();
    model.addElement("Р Р°Р·");
    model.addElement("Р”РІР°");
    // СЃРїРёСЃРѕРє СЃРѕ СЃС‚СЂРѕРєР°РјРё
    final JList list = new JList(model);
    list.setTransferHandler(new ListDrag.ListTransferHandler(list));
    list.setDragEnabled(true);
    list.setDropMode(DropMode.INSERT);
    add(new JScrollPane(list));
    JButton copy = new JButton("РљРѕРїРёСЂРѕРІР°С‚СЊ РІ Р±СѓС„РµСЂ");
    copy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // РЅРµРѕР±С…РѕРґРёРјРѕ РґР»СЏ СЂР°Р±РѕС‚С‹ РєРѕРјР°РЅРґС‹
        e.setSource(list);
        // РІС‹Р·С‹РІР°РµРј СЃС‚Р°РЅРґР°СЂС‚РЅСѓСЋ РєРѕРјР°РЅРґСѓ РєРѕРїРёСЂРѕРІР°РЅРёСЏ
        TransferHandler.getCopyAction().actionPerformed(e);
      }
    });
    add(copy, "South");
    // РІС‹РІРµРґРµРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TransferHandlerClipboard(); } });
  }
}