// ControllingScrolling.java
// РЈРїСЂР°РІР»РµРЅРёРµ РїСЂРѕС†РµСЃСЃРѕРј РїСЂРѕРєСЂСѓС‚РєРё СЃ РїРѕРјРѕС‰СЊСЋ
// РёРЅС‚РµСЂС„РµР№СЃР° Scrollable
import javax.swing.*;
import java.awt.*;

public class ControllingScrolling extends JFrame {
  public ControllingScrolling() {
    super("ControllingScrolling");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РґРѕР±Р°РІРёРј РІ С†РµРЅС‚СЂ РїР°РЅРµР»СЊ РїСЂРѕРєСЂСѓС‚РєРё СЃ
    // РЅР°С€РёРј РєРѕРјРїРѕРЅРµРЅС‚РѕРј
    add(new JScrollPane(new GridComponent()));
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(400, 300);
    setVisible(true);
  }
  // РєРѕРјРїРѕРЅРµРЅС‚-"СЃРµС‚РєР°" СЃ РѕСЃРѕР±С‹Рј СЂРµР¶РёРјРѕРј РїСЂРѕРєСЂСѓС‚РєРё
  class GridComponent extends JPanel
      implements Scrollable {
    // СЂР°Р·РјРµСЂ СЏС‡РµР№РєРё СЃРµС‚РєРё
    private int CELL_SIZE = 45;
    // РєРѕР»РёС‡РµСЃС‚РІРѕ СЏС‡РµРµРє СЃРµС‚РєРё
    private int CELL_COUNT = 50;
    // РїСЂРµРґРїРѕС‡С‚РёС‚РµР»СЊРЅС‹Р№ СЂР°Р·РјРµСЂ РєРѕРјРїРѕРЅРµРЅС‚Р°
    public Dimension getPreferredSize() {
      return new Dimension(CELL_SIZE*CELL_COUNT,
          CELL_SIZE*CELL_COUNT);
    }
    // РїСЂРѕСЂРёСЃРѕРІРєР° РєРѕРјРїРѕРЅРµРЅС‚Р°
    public void paintComponent(Graphics g) {
      // РЅСѓР¶РЅРѕ РІС‹Р·РІР°С‚СЊ РјРµС‚РѕРґ Р±Р°Р·РѕРІРѕРіРѕ РєР»Р°СЃСЃР°
      super.paintComponent(g);
      for (int x=0; x<CELL_COUNT; x++) {
        for (int y=0; y<CELL_COUNT; y++) {
          // СЂРёСЃСѓРµРј СЏС‡РµР№РєСѓ
          g.setColor(Color.BLACK);
          g.drawRect(x*CELL_SIZE, y*CELL_SIZE,
              CELL_SIZE, CELL_SIZE);
          // С‚РµРєСЃС‚ СЃ РєРѕРѕСЂРґРёРЅР°С‚Р°РјРё
          g.drawString(""+x+","+y,
              x*CELL_SIZE + 5, y*CELL_SIZE + CELL_SIZE/2);
        }
      }
    }
    // РїСЂРµРґРїРѕС‡С‚РёС‚РµР»СЊРЅС‹Р№ СЂР°Р·РјРµСЂ РѕР±Р»Р°СЃС‚Рё РїСЂРѕРєСЂСѓС‚РєРё
    public Dimension
    getPreferredScrollableViewportSize() {
      return getPreferredSize();
    }
    // РїСЂРёСЂР°С‰РµРЅРёРµ РїСЂРё РїСЂРѕРєСЂСѓС‚РєРµ РЅР° РѕРґРёРЅ СЌР»РµРјРµРЅС‚
    public int getScrollableUnitIncrement(
        Rectangle visible, int or, int dir) {
      return CELL_SIZE;
    }
    // РїСЂРёСЂР°С‰РµРЅРёРµ РїСЂРё РїСЂРѕРєСЂСѓС‚РєРµ "Р±Р»РѕРєРѕРј"
    public int getScrollableBlockIncrement(
        Rectangle visible, int or, int dir) {
      return CELL_SIZE*10;
    }
    // РЅСѓР¶РЅРѕ Р»Рё СЃР»РµРґРёС‚СЊ Р·Р° СЂР°Р·РјРµСЂРѕРј РѕР±Р»Р°СЃС‚Рё РїСЂРѕРєСЂСѓС‚РєРё
    public boolean getScrollableTracksViewportWidth() {
      return false;
    }
    public boolean getScrollableTracksViewportHeight() {
      return false;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ControllingScrolling(); } });
  }
}
