// ListDrag.java
// РџРµСЂРµС‚Р°СЃРєРёРІР°РЅРёРµ Рё РІСЃС‚Р°РІРєР° РґР°РЅРЅС‹С… Рё TransferHandler
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ListDrag extends JFrame {
  // РЅР°С‡Р°Р»СЊРЅС‹Рµ РґР°РЅРЅС‹Рµ РґР»СЏ СЃРїРёСЃРєРѕРІ
  private String[] listData =
      new String[] { "Р Р°Р·", "Р”РІР°", "РўСЂРё" };
  public ListDrag() {
    super("ListDrag");
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // СЃРѕР·РґР°РµРј РјРѕРґРµР»Рё
    DefaultListModel model1 = new DefaultListModel(),
        model2 = new DefaultListModel();
    for (String element: listData) {
      model1.addElement(element);
      model2.addElement(element);
    }
    // СЃРѕР·РґР°РµРј СЃРїРёСЃРєРё
    JList list1 = new JList(model1);
    list1.setTransferHandler(new ListTransferHandler(list1));
    list1.setDragEnabled(true);
    JList list2 = new JList(model2);
    list2.setTransferHandler(new ListTransferHandler(list2));
    list2.setDragEnabled(true);
    // РґРѕР±Р°РІРёРј СЃРїРёСЃРєРё РЅР° СЌРєСЂР°РЅ
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    // РІС‹РІРµРґРµРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(400, 300);
    setVisible(true);
  }
  // РѕР±СЉРµРєС‚-Р°РґР°РїС‚РµСЂ РґР»СЏ СЃРїРёСЃРєРѕРІ Рё РёС… РґР°РЅРЅС‹С…
  static class ListTransferHandler extends TransferHandler {
    private JList list;
    public ListTransferHandler(JList list) {
      this.list = list;
    }
    @Override
    public int getSourceActions(JComponent c) {
      // РґР°РЅРЅС‹Рµ РјРѕРіСѓС‚ РєРѕРїРёСЂРѕРІР°С‚СЊСЃСЏ РёР»Рё РїРµСЂРµРјРµС‰Р°С‚СЊСЃСЏ
      return TransferHandler.COPY_OR_MOVE;
    }
    @Override
    public boolean canImport(TransferSupport support) {
      // РїРѕРґРґРµСЂР¶РёРІР°РµС‚СЃСЏ РёРјРїРѕСЂС‚ С‚РѕР»СЊРєРѕ СЃС‚СЂРѕРєРѕРІС‹С… РґР°РЅРЅС‹С…
      return support.isDataFlavorSupported(
          DataFlavor.stringFlavor);
    }
    @Override
    protected Transferable createTransferable(JComponent c) {
      // СЃС‚Р°РЅРґР°СЂС‚РЅС‹Р№ СЃРїРѕСЃРѕР± Р°РґР°РїС‚РёСЂРѕРІР°С‚СЊ СЃС‚СЂРѕРєСѓ РґР»СЏ РѕР±РјРµРЅР°
      return new StringSelection(
          list.getSelectedValue().toString());
    }
    @Override
    public boolean importData(TransferSupport support) {
      if ( support.isDataFlavorSupported(DataFlavor.stringFlavor) ) {
        try {
          // РґРѕР±Р°РІР»СЏРµРј РІ РјРѕРґРµР»СЊ РЅРѕРІСѓСЋ СЃС‚СЂРѕРєСѓ РЅР° РІС‹Р±СЂР°РЅРЅСѓСЋ РїРѕР·РёС†РёСЋ
          ((DefaultListModel)list.getModel()).
              add(list.locationToIndex(
                  support.getDropLocation().getDropPoint()),
                  // РїРѕР»СѓС‡РµРЅРёРµ СЃС‚СЂРѕРєРё РёР· Transferable
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