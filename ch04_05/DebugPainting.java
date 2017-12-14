// DebugPainting.java
// Р”РµРјРѕРЅСЃС‚СЂР°С†РёСЏ РІРѕР·РјРѕР¶РЅРѕСЃС‚РµР№ РѕС‚Р»Р°РґРєРё РіСЂР°С„РёРєРё РІ Swing
import java.awt.*;
import javax.swing.*;

public class DebugPainting extends JFrame {
  public DebugPainting() {
    super("DebugPainting");
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РґРѕР±Р°РІР»СЏРµРј СЂРёСЃСѓСЋС‰РёР№ РєРѕРјРїРѕРЅРµРЅС‚
    PaintingComponent pc = new PaintingComponent();
    add(pc);
    // РІРєР»СЋС‡Р°РµРј РґР»СЏ РЅРµРіРѕ РѕС‚Р»Р°РґРєСѓ РіСЂР°С„РёРєРё
    RepaintManager.currentManager(pc).
        setDoubleBufferingEnabled(false);
    pc.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION
        | DebugGraphics.FLASH_OPTION);
    DebugGraphics.setFlashTime(50);
    DebugGraphics.setFlashCount(3);
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(200, 200);
    setVisible(true);
  }

  // РєРѕРјРїРѕРЅРµРЅС‚, РєРѕС‚РѕСЂС‹Р№ С‡С‚Рѕ-С‚Рѕ СЂРёСЃСѓРµС‚
  class PaintingComponent extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // С‚СЂРё РїСЂРѕСЃС‚С‹Рµ С„РёРіСѓСЂС‹
      g.setColor(Color.orange);
      g.fillRect(10, 10, 100, 100);
      g.setColor(Color.green);
      g.drawOval(50, 50, 50, 50);
      g.setColor(Color.blue);
      g.fillOval(100, 20, 50, 50);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new DebugPainting(); } });
  }
}
