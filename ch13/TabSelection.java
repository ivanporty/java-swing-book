// TabSelection.java
// Р Р°Р±РѕС‚Р° СЃ Р°РєС‚РёРІРЅС‹РјРё РІРєР»Р°РґРєР°РјРё Рё РѕР±СЂР°Р±РѕС‚РєР° СЃРѕР±С‹С‚РёР№
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class TabSelection extends JFrame {
  public TabSelection() {
    super("TabSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // СЃРѕР·РґР°РµРј РЅР°С€Сѓ РїР°РЅРµР»СЊ СЃ РІРєР»Р°РґРєР°РјРё
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("Р’РєР»Р°РґРєР°", new JPanel());
    tabs.addTab("Р•С‰Рµ РІРєР»Р°РґРєР°", new JPanel());
    // РґРѕР±Р°РІР»СЏРµРј СЃР»СѓС€Р°С‚РµР»СЏ СЃРѕР±С‹С‚РёР№
    tabs.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // РґРѕР±Р°РІР»СЏРµРј РЅР° РІРєР»Р°РґРєСѓ РЅРѕРІС‹Р№ РєРѕРјРїРѕРЅРµРЅС‚
        JPanel panel = (JPanel)
            ((JTabbedPane)e.getSource()).
                getSelectedComponent();
        panel.add(new JButton("РљРЅРѕРїРєР°"));
      }
    });
    // СЂР°Р±РѕС‚Р° СЃ РЅРёР·РєРѕСѓСЂРѕРІРЅРµРІС‹РјРё СЃРѕР±С‹С‚РёСЏРјРё
    tabs.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // СѓР·РЅР°РµРј, РЅР° РєР°РєРѕР№ РІРєР»Р°РґРєРµ Р±С‹Р» С‰РµР»С‡РѕРє
        int idx = ((JTabbedPane)e.getSource()).
            indexAtLocation(e.getX(), e.getY());
        JOptionPane.showMessageDialog(
            null, "Index: " + idx);
      }
    });
    // РІС‹РІРѕРґРёРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    add(tabs);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TabSelection(); } });
  }
}