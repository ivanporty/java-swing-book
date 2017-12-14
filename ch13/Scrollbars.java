// Scrollbars.java
// РџРѕР»РѕСЃС‹ РїСЂРѕРєСЂСѓС‚РєРё JScrollBar
import javax.swing.*;
import java.awt.*;

public class Scrollbars extends JFrame {
  public Scrollbars() {
    super("Scrollbars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // СЃРѕР·РґР°РµРј СЃС‚Р°РЅРґР°СЂС‚РЅСѓСЋ РјРѕРґРµР»СЊ
    BoundedRangeModel model =
        new DefaultBoundedRangeModel(10, 40, 0, 100);
    // РїР°СЂР° РїРѕР»РѕСЃ РїСЂРѕРєСЂСѓС‚РєРё
    JScrollBar scrollbar1 = new JScrollBar(
        JScrollBar.HORIZONTAL);
    JScrollBar scrollbar2 = new JScrollBar(
        JScrollBar.VERTICAL);
    // РїСЂРёСЃРѕРµРґРёРЅСЏРµРј РјРѕРґРµР»СЊ
    scrollbar1.setModel(model);
    scrollbar2.setModel(model);
    // РґРѕР±Р°РІР»СЏРµРј РєРѕРјРїРѕРЅРµРЅС‚С‹ РІ РїР°РЅРµР»СЊ
    add(scrollbar1, "South");
    add(scrollbar2, "East");
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new Scrollbars(); } });
  }
}
