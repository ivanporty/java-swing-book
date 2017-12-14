// UsingViewport.java
// Р Р°Р±РѕС‚Р° СЃ "РІРёРґРѕРёСЃРєР°С‚РµР»РµРј" JViewport
import javax.swing.*;
import java.awt.*;

public class UsingViewport extends JFrame {
  public UsingViewport() {
    super("UsingViewport");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РЅР°РґРїРёСЃСЊ СЃ С‚РµРєСЃС‚РѕРј Р±РѕР»СЊС€РѕРіРѕ СЂР°Р·РјРµСЂР°
    JLabel bigLabel = new JLabel(
        "<html><h1>Р‘РѕР»СЊС€Р°СЏ РќР°РґРїРёСЃСЊ!<br>РњРЅРѕРіРѕ С‚РµРєСЃС‚Р°!");
    // "РІРёРґРѕРёСЃРєР°С‚РµР»СЊ"
    JViewport viewport = new JViewport();
    // СѓСЃС‚Р°РЅР°РІР»РёРІР°РµРј РІРёРґ Рё РІРёРґРёРјС‹Р№ РґРёР°РїР°Р·РѕРЅ
    viewport.setView(bigLabel);
    viewport.setExtentSize(new Dimension(100, 60));
    // С‚РѕС‡РєР° РЅР°С‡Р°Р»Р° РІРёРґРёРјРѕР№ РѕР±Р»Р°СЃС‚Рё
    viewport.setViewPosition(new Point(50, 50));
    // РѕРіСЂР°РЅРёС‡РёРј СЂР°Р·РјРµСЂ "РІРёРґРѕРёСЃРєР°С‚РµР»СЏ"
    viewport.setPreferredSize(new Dimension(100, 60));
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setLayout(new FlowLayout());
    add(viewport);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingViewport(); } });
  }
}