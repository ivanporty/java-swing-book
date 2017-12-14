// AWTPainting.java
// РџСЂРѕС†РµСЃСЃ СЂРёСЃРѕРІР°РЅРёСЏ РІ AWT РѕС‡РµРЅСЊ РїСЂРѕСЃС‚

import java.awt.*;
import java.awt.event.*;

public class AWTPainting extends Frame {

  public AWTPainting() {
    super("AWTPainting");
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setLayout(new FlowLayout());
    // РїРѕРїСЂРѕР±СѓРµРј Р·Р°РєСЂР°СЃРёС‚СЊ С‡Р°СЃС‚СЊ РєРЅРѕРїРєРё
    add(new Button("РџРµСЂРµСЂРёСЃСѓРµРј РєРЅРѕРїРєСѓ!") {
      public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(2, 2, getWidth() - 5, getHeight() - 5);
      }
    });
    setSize(200, 200);
  }

  // РІ СЌС‚РѕРј РјРµС‚РѕРґРµ РїСЂРѕРёР·РІРѕРґРёС‚СЃСЏ СЂРёСЃРѕРІР°РЅРёРµ
  public void paint(Graphics g) {
    // Р·Р°РїРѕР»РЅСЏРµРј РІСЃРµ РєСЂР°СЃРЅС‹Рј С†РІРµС‚РѕРј
    g.setColor(Color.RED);
    g.fillRect(0, 0, getWidth(), getHeight());
  }

  public static void main(String[] args) {
    new AWTPainting().setVisible(true);
  }
}
