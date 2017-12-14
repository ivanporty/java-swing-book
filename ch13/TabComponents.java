// TabComponents.java
// Р Р°Р·РјРµС‰РµРЅРёРµ РєРѕРјРїРѕРЅРµРЅС‚РѕРІ РІРѕ РІРєР»Р°РґРєР°С…
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TabComponents extends JFrame {
  public TabComponents() {
    super("TabComponents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // РїР°РЅРµР»СЊ СЃ РІРєР»Р°РґРєР°РјРё
    final JTabbedPane tabs = new JTabbedPane();
    tabs.addTab(null, new JPanel());
    tabs.addTab(null, new JPanel());
    // С„Р»Р°Р¶РѕРє РІРѕ РІРєР»Р°РґРєРµ
    JCheckBox checkBox = new JCheckBox("Р¤Р»Р°Р¶РѕРє!");
    checkBox.setOpaque(false);
    tabs.setTabComponentAt(0, checkBox);
    // РІРєР»Р°РґРєР° СЃ РЅР°РґРїРёСЃСЊСЋ Рё РєРЅРѕРїРєРѕР№ Р·Р°РєСЂС‹С‚РёСЏ
    final JPanel panel = new JPanel();
    JLabel label = new JLabel("РњРѕР¶РЅРѕ Р·Р°РєСЂС‹С‚СЊ!");
    JButton closeButton = new JButton(new AbstractAction() {
      {
        putValue(SMALL_ICON, new ImageIcon("close.png"));
      }
      public void actionPerformed(ActionEvent e) {
        // РЅСѓР¶РЅРѕ РѕРїСЂРµРґРµР»РёС‚СЊ РІРєР»Р°РґРєСѓ, РІ РєРѕС‚РѕСЂРѕР№ РЅР°С…РѕРґРёС‚СЃСЏ РєРЅРѕРїРєР°
        tabs.removeTabAt(
            tabs.indexOfTabComponent(panel));
      }
    });
    closeButton.setBorderPainted(false);
    closeButton.setContentAreaFilled(false);
    panel.setOpaque(false);
    panel.add(label);
    panel.add(closeButton);
    tabs.setTabComponentAt(1, panel);
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    add(tabs);
    setSize(430, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TabComponents(); } });
  }
}