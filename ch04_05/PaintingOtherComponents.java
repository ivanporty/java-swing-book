// PaintingOtherComponents.java
// РџСЂРѕСЂРёСЃРѕРІРєР° РґСЂСѓРіРёС… РєРѕРјРїРѕРЅРµРЅС‚РѕРІ РєР°Рє РёР·РѕР±СЂР°Р¶РµРЅРёР№
import javax.swing.*;
import java.awt.*;

public class PaintingOtherComponents extends JFrame {
  public PaintingOtherComponents() {
    super("PaintingOtherComponents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CustomPaintComponent());
    setSize(400, 300);
    setVisible(true);
  }
  class CustomPaintComponent extends JPanel {
    // РєРЅРѕРїРєР° РґР»СЏ РїСЂРѕСЂРёСЃРѕРІРєРё
    private JButton button = new JButton("РџСЂРёРІРµС‚!");
    // РјРµС‚РѕРґ РґР»СЏ СЂРёСЃРѕРІР°РЅРёСЏ РІ Swing
    protected void paintComponent(Graphics g) {
      // РЅРµРѕР±С…РѕРґРёРјРѕ РІС‹Р·РІР°С‚СЊ РґР»СЏ РѕР±СЂР°Р±РѕС‚РєРё СЃРІРѕР№СЃС‚РІР° opaque
      super.paintComponent(g);
      // СЂРёСЃСѓРµРј РєРЅРѕРїРєРё
      Graphics2D g2 = (Graphics2D) g;
      button.setSize(80, 30);
      // РѕС‚РєР»СЋС‡РµРЅРёРµ РґРІРѕР№РЅРѕР№ Р±СѓС„РµСЂРёР·Р°С†РёРё - РЅРµ РІСЃРµРіРґР° РЅСѓР¶РЅРѕ
      button.setDoubleBuffered(false);
      // РїРµСЂРµРјРµСЃС‚РёРј РїРѕР·РёС†РёСЋ СЂРёСЃРѕРІР°РЅРёСЏ
      g2.translate(100, 100);
      for (int i=1; i<=8; i++) {
        // РєСЂСѓС‡РµРЅРёРµ РєРЅРѕРїРєРё РїРѕ РєСЂСѓРіСѓ
        g2.rotate(2*Math.PI / i);
        button.paint(g);
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new PaintingOtherComponents(); } });
  }
}
