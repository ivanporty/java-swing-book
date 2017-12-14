// HeadersAndCorners.java
// Р—Р°РіРѕР»РѕРІРєРё Рё "СѓРіРѕР»РєРё" РїР°РЅРµР»Рё РїСЂРѕРєСЂСѓС‚РєРё JScrollPane
import javax.swing.*;
import java.awt.*;

public class HeadersAndCorners extends JFrame {
  // РЅР°РґРїРёСЃСЊ СЃ Р±РѕР»СЊС€РёРј РёР·РѕР±СЂР°Р¶РµРЅРёРµРј
  private JLabel label = new JLabel(
      new ImageIcon("image.jpg"));
  public HeadersAndCorners() {
    super("HeadersAndCorners");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // СЃРѕР·РґР°РµРј РїР°РЅРµР»СЊ РїСЂРѕРєСЂСѓС‚РєРё
    JScrollPane scroll = new JScrollPane(label);
    // СѓСЃС‚Р°РЅР°РІР»РёРІР°РµРј Р·Р°РіРѕР»РѕРІРєРё
    scroll.setColumnHeaderView(new XHeader());
    scroll.setRowHeaderView(new YHeader());
    // СѓСЃС‚Р°РЅР°РІР»РёРІР°РµРј Р»РµРІС‹Р№ РІРµСЂС…РЅРёР№ "СѓРіРѕР»РѕРє"
    scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER,
        new JButton(new ImageIcon("Print16.gif")));
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    add(scroll);
    setSize(400, 300);
    setVisible(true);
  }
  // Р·Р°РіРѕР»РѕРІРѕРє РїРѕ РѕСЃРё X
  class XHeader extends JPanel {
    // СЂР°Р·РјРµСЂ Р·Р°РіРѕР»РѕРІРєР°
    public Dimension getPreferredSize() {
      return new Dimension(
          label.getPreferredSize().width, 20);
    }
    // РїСЂРѕСЂРёСЃРѕРІС‹РІР°РµРј Р»РёРЅРµР№РєСѓ
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int width = getWidth();
      for (int i=0; i<width; i+=50) {
        g.drawString("" + i, i, 15);
      }
    }
  }
  // Р·Р°РіРѕР»РѕРІРѕРє РїРѕ РѕСЃРё Y
  class YHeader extends JPanel {
    // СЂР°Р·РјРµСЂ Р·Р°РіРѕР»РѕРІРєР°
    public Dimension getPreferredSize() {
      return new Dimension(
          20, label.getPreferredSize().height);
    }
    // РїСЂРѕСЂРёСЃРѕРІС‹РІР°РµРј Р»РёРЅРµР№РєСѓ
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int height = getHeight();
      for (int i=0; i<height; i+=50) {
        g.drawString("" + i, 0, i);
      }
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HeadersAndCorners(); } });
  }
}
