// SwingPainting.java
// Р Р°Р±РѕС‚Р° СЂРёСЃСѓСЋС‰РёС… РјРµС…Р°РЅРёР·РјРѕРІ Swing

import javax.swing.*;
import java.awt.*;

public class SwingPainting extends JFrame {

  public SwingPainting() {
    super("SwingPainting");
    // РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР° Р·Р°РІРµСЂС€Р°РµРј СЂР°Р±РѕС‚Сѓ
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РґРѕР±Р°РІР»СЏРµРј РІ РїР°РЅРµР»СЊ СЃРѕРґРµСЂР¶РёРјРѕРіРѕ РЅР°С€ РєРѕРјРїРѕРЅРµРЅС‚
    getContentPane().add(new SwingComponent());
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(200, 200);
    setVisible(true);
  }

  // РєРѕРјРїРѕРЅРµРЅС‚, РёСЃРїРѕР»СЊР·СѓСЋС‰РёР№ РІРѕР·РјРѕР¶РЅРѕСЃС‚Рё Swing
  class SwingComponent extends JComponent {
    // РїСЂРѕСЂРёСЃРѕРІРєР° РєРѕРјРїРѕРЅРµРЅС‚Р°
    public void paintComponent(Graphics g) {
      System.out.println("paintComponent");
      super.paintComponent(g);
      g.setColor(Color.red);
      g.fillOval(10, 10, 50, 50);
    }

    // РїСЂРѕСЂРёСЃРѕРІРєР° СЂР°РјРєРё
    public void paintBorder(Graphics g) {
      System.out.println("paintBorder");
      super.paintBorder(g);
    }

    // РїСЂРѕСЂРёСЃРѕРІРєР° РїРѕС‚РѕРјРєРѕРІ
    public void paintChildren(Graphics g) {
      System.out.println("paintChildren");
      super.paintChildren(g);
    }
  }

  public static void main(String[] args) {
    new SwingPainting();
  }
}
