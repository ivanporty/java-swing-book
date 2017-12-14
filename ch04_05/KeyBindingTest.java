// KeyBindingTest.java
// РџСЂРёРјРµСЂ РёСЃРїРѕР»СЊР·РѕРІР°РЅРёСЏ РєР»Р°РІРёС‚СѓСЂРЅС‹С… СЃРѕРєСЂР°С‰РµРЅРёР№

import javax.swing.*;
import java.awt.event.*;

public class KeyBindingTest extends JFrame {
  public KeyBindingTest() {
    super("KeyBindingTest");
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РЅР°СЃС‚СЂР°РёРІР°РµРј РєР°СЂС‚С‹ РєРѕРјР°РЅРґ Рё РІС…РѕРґРЅС‹С… СЃРѕР±С‹С‚РёР№ РґР»СЏ
    // РєРѕСЂРЅРµРІРѕР№ РїР°РЅРµР»Рё РїСЂРёР»РѕР¶РµРЅРёСЏ
    InputMap im = getRootPane().getInputMap();
    ActionMap am = getRootPane().getActionMap();
    // СЃСЂР°Р±Р°С‚С‹РІР°РµС‚ РїСЂРё РѕС‚РїСѓСЃРєР°РЅРёРё СЃРѕС‡РµС‚Р°РЅРёСЏ Ctrl+A
    im.put(KeyStroke.getKeyStroke(
        KeyEvent.VK_A,
        KeyEvent.CTRL_MASK, true), "Action");
    // СЃСЂР°Р±Р°С‚С‹РІР°РµС‚ РїСЂРё РїРµС‡Р°С‚Рё Р±СѓРєРІС‹ 'РЇ'
    im.put(KeyStroke.getKeyStroke('РЇ'), "Action");
    am.put("Action", new AnAction());
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(200, 200);
    setVisible(true);
  }

  // РєР»Р°СЃСЃ РЅР°С€РµР№ РєРѕРјР°РЅРґС‹
  class AnAction extends AbstractAction {
    public void actionPerformed(ActionEvent e) {
      System.out.println("OK");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new KeyBindingTest(); } });
  }
}
