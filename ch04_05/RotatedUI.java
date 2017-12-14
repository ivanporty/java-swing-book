// RotatedUI.java
// РљСЂСѓС‡РµРЅРёРµ Рё РІРµСЂС‡РµРЅРёРµ СЃС‚Р°РЅРґР°СЂС‚РЅС‹С… РєРѕРјРїРѕРЅРµРЅС‚РѕРІ
import javax.swing.*;
import java.awt.*;

public class RotatedUI extends JFrame {
  public RotatedUI() {
    super("RotatedUI");
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РґРѕР±Р°РІР»СЏРµРј РѕСЃРѕР±СѓСЋ РїР°РЅРµР»СЊ
    RotatingPanel rp = new RotatingPanel();
    add(rp);
    // РґРѕР±Р°РІР»СЏРµРј РІ РїР°РЅРµР»СЊ РєРѕРјРїРѕРЅРµРЅС‚С‹
    rp.add(new JButton("РџСЂРёРІРµС‚!"));
    rp.add(new JTextField(20));
    // СѓСЃС‚Р°РЅР°РІР»РёРІР°РµРј СЃРІРѕР№ RepaintManager
    RepaintManager.setCurrentManager(
        new RotatingRepaintManager());
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(200, 300);
    setVisible(true);
  }
  // РєРѕРјРїРѕРЅРµРЅС‚, РєРѕС‚РѕСЂС‹Р№ РїРѕРІРѕСЂР°С‡РёРІР°РµС‚ РІСЃРµС… РїРѕС‚РѕРјРєРѕРІ
  class RotatingPanel extends JPanel {
    // РѕС‚РІРµС‡Р°РµС‚ Р·Р° РїСЂРѕСЂРёСЃРѕРІРєСѓ РїРѕС‚РѕРјРєРѕРІ
    protected void paintChildren(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.translate(50, 200);
      // РїРѕРІРѕСЂРѕС‚ РЅР° 45 РіСЂР°РґСѓСЃРѕРІ
      g2.rotate(-Math.PI/4);
      // РЅРµР±РѕР»СЊС€РѕРµ СЂР°СЃС‚СЏР¶РµРЅРёРµ
      g2.shear(-0.1, -0.1);
      // РѕР±С‹С‡РЅРѕРµ СЂРёСЃРѕРІР°РЅРёРµ РїСЂРµРґРєРѕРІ
      super.paintChildren(g);
    }
  }
  // РѕСЃРѕР±С‹Р№ С‚РёРї RepaintManager
  class RotatingRepaintManager extends RepaintManager {
    // РІСЃРµ Р·Р°РїСЂРѕСЃС‹ РЅР° РїРµСЂРµСЂРёСЃРѕРІРєСѓ РїРѕРїР°РґР°СЋС‚ СЃСЋРґР°
    public void addDirtyRegion(JComponent c,
        int x, int y, int w, int h) {
      // РёС‰РµРј РЅСѓР¶РЅРѕРіРѕ РїСЂРµРґРєР°
      Container parent = c;
      while (! (parent instanceof RotatingPanel)) {
        parent = parent.getParent();
        if ( parent == null ) {
          // РјС‹ РЅРµ РЅР°С€Р»Рё РЅР°С€РµРіРѕ РїСЂРµРґРєР°, СЃР±СЂРѕСЃ
          parent = c;
          break;
        }
      }
      // РїРµСЂРµСЂРёСЃРѕРІС‹РІР°РµРј РІРµСЃСЊ РєРѕРјРїРѕРЅРµРЅС‚ РїРѕР»РЅРѕСЃС‚СЊСЋ
      super.addDirtyRegion((JComponent) parent,
          0, 0, parent.getWidth(), parent.getHeight());
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new RotatedUI(); } });
  }
}