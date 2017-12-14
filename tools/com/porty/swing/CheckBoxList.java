// CheckBoxList.java
// РЎРїРёСЃРѕРє СЃ С„Р»Р°Р¶РєР°РјРё
package com.porty.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class CheckBoxList extends JList {
  // СЃРѕС…СЂР°РЅСЏРµРј РІСЃРµ РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂС‹
  public CheckBoxList(ListModel model) {
    super(model);
    initList();
  }
  public CheckBoxList(Object[] data) {
    super(data);
    initList();
  }
  public CheckBoxList(Vector data) {
    super(data);
    initList();
  }
  // СЃРїРµС†РёР°Р»СЊРЅР°СЏ РЅР°СЃС‚СЂРѕР№РєР° СЃРїРёСЃРєР°
  private void initList() {
    setCellRenderer(new CheckBoxCellRenderer());
    setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // СЃР»РµРґРёРј Р·Р° С‰РµР»С‡РєР°РјРё
        if ( e.getClickCount() == 1 &&
            SwingUtilities.isLeftMouseButton(e) ) {
          // РЅСѓР¶РЅС‹Р№ РЅР°Рј С‰РµР»С‡РѕРє
          int pos =
              locationToIndex(e.getPoint());
          CheckBoxListElement cbel =
              (CheckBoxListElement)getModel().
                  getElementAt(pos);
          cbel.setSelected(! cbel.isSelected());
          // Р·Р°РЅРѕРІРѕ СЂРёСЃСѓРµРј С‚РѕР»СЊРєРѕ СЌС‚Сѓ СЏС‡РµР№РєСѓ СЃРїРёСЃРєР°
          repaint(getCellBounds(pos, pos));
        }
      }
    });
  }
  // РѕС‚РѕР±СЂР°Р¶Р°СЋС‰РёР№ С„Р»Р°Р¶РєРё РѕР±СЉРµРєС‚
  public static class CheckBoxCellRenderer
      extends JCheckBox implements ListCellRenderer {
    public Component getListCellRendererComponent(
        JList list, Object data, int idx,
        boolean isSelected, boolean hasFocus) {
      // РїРѕР»Р°РіР°РµРј, С‡С‚Рѕ РґР°РЅРЅС‹Рµ РІСЃРµРіРґР° РЅСѓР¶РЅРѕРіРѕ С‚РёРїР°
      CheckBoxListElement
          cbel = (CheckBoxListElement)data;
      // РЅР°СЃС‚СЂР°РёРІР°РµРј С„Р»Р°Р¶РѕРє
      if ( isSelected ) {
        setBackground(list.getSelectionBackground());
        setForeground(list.getSelectionForeground());
      } else {
        setBackground(list.getBackground());
        setForeground(list.getForeground());
      }
      setSelected(cbel.isSelected());
      setText(cbel.getText());
      return this;
    }
  }
}