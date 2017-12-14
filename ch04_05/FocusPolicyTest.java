// FocusPolicyTest.java
// Р Р°Р·Р»РёС‡РЅС‹Рµ Р°Р»РіРѕСЂРёС‚РјС‹ РїРµСЂРµРґР°С‡Рё С„РѕРєСѓСЃР° РІРІРѕРґР°
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusPolicyTest extends JFrame {
  public FocusPolicyTest() {
    super("FocusPolicyTest");
    // РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР° РІС‹С…РѕРґ
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РґРѕР±Р°РІР»СЏРµРј С‚СЂРё РєРЅРѕРїРєРё
    add(new JButton("Р›РµРІР°СЏ"), "West");
    // РґРѕР±Р°РІР»СЏРµРј СЌС‚Сѓ РєРЅРѕРїРєСѓ РІС‚РѕСЂРѕР№, РЅРѕ РѕРЅР° Р±СѓРґРµС‚ РЅРёР¶Рµ
    // РґРІСѓС… РґСЂСѓРіРёС… РєРЅРѕРїРѕРє
    JButton button = new JButton("РЎРјРµРЅРёС‚СЊ");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // РїСЂРё РЅР°Р¶Р°С‚РёРё СЃРјРµРЅРёРј Р°Р»РіРѕСЂРёС‚Рј РґР»СЏ РѕРєРЅР°
        setFocusTraversalPolicy(
            new ContainerOrderFocusTraversalPolicy());
      }
    });
    add(button, "South");
    add(new JButton("РџСЂР°РІР°СЏ"), "East");
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FocusPolicyTest(); } });
  }
}
