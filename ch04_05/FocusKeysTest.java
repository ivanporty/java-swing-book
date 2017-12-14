// FocusKeysTest.java
// РќР°СЃС‚СЂРѕР№РєР° РєР»Р°РІРёС€ РїРµСЂРµС…РѕРґР° С„РѕРєСѓСЃР° РІРІРѕРґР°
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class FocusKeysTest extends JFrame {
  public FocusKeysTest() {
    super("FocusKeysTest");
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РґРѕР±Р°РІР»СЏРµРј РїР°СЂСѓ РєРЅРѕРїРѕРє
    setLayout(new FlowLayout());
    // РѕСЃРѕР±Р°СЏ РєРЅРѕРїРєР°
    JButton button = new JButton("РћСЃРѕР±Р°СЏ");
    add(button);
    add(new JButton("РћР±С‹С‡РЅР°СЏ"));
    // РЅР°СЃС‚СЂРѕРёРј РєР»Р°РІРёС€Рё РїРµСЂРµС…РѕРґР° С„РѕРєСѓСЃР°
    HashSet<AWTKeyStroke> set = new HashSet<AWTKeyStroke>();
    set.add(AWTKeyStroke.getAWTKeyStroke(
        'Q', KeyEvent.CTRL_MASK));
    button.setFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set);
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FocusKeysTest(); } });
  }
}
