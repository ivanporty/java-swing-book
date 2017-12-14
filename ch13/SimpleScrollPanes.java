// SimpleScrollPanes.java
// РќР°СЃС‚СЂРѕР№РєР° РЅРµРєРѕС‚РѕСЂС‹С… РїСЂРѕСЃС‚С‹С… СЃРІРѕР№СЃС‚РІ РїР°РЅРµР»РµР№ РїСЂРѕРєСЂСѓС‚РєРё
import javax.swing.*;
import java.awt.*;

public class SimpleScrollPanes extends JFrame {
  public SimpleScrollPanes() {
    super("SimpleScrollPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РЅР°РґРїРёСЃСЊ
    JLabel label = new JLabel(new ImageIcon("image.jpg"));
    // РѕСЃРѕР±С‹Р№ РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ РїР°РЅРµР»Рё РїСЂРѕРєСЂСѓС‚РєРё
    JScrollPane scrollPane = new JScrollPane(label,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    // РЅРµРєРѕС‚РѕСЂС‹Рµ СЃРІРѕР№СЃС‚РІР°
    scrollPane.setViewportBorder(
        BorderFactory.createLineBorder(Color.BLUE));
    scrollPane.setWheelScrollingEnabled(false);
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    add(scrollPane);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleScrollPanes(); } });
  }
}