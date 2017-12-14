// com/porty/swing/ImageTableCellRenderer.java
// РћР±СЉРµРєС‚ РґР»СЏ РїСЂРѕСЂРёСЃРѕРІРєРё Р·РЅР°С‡РєР° Рё С‚РµРєСЃС‚Р° РІ С‚Р°Р±Р»РёС†Рµ
package com.porty.swing;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ImageTableCellRenderer
    extends DefaultTableCellRenderer {
  // РјРµС‚РѕРґ РІРѕР·РІСЂР°С‰Р°РµС‚ РєРѕРјРїРѕРЅРµРЅС‚ РґР»СЏ РїСЂРѕСЂРёСЃРѕРІРєРё
  public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    // РїРѕР»СѓС‡Р°РµРј РѕР±СЉРµРєС‚ РЅСѓР¶РЅРѕРіРѕ С‚РёРїР°
    if ( value instanceof ImageListElement ) {
      ImageListElement imageCell = (ImageListElement)value;
      // РїРѕР»СѓС‡Р°РµРј РЅР°СЃС‚СЂРѕРµРЅРЅСѓСЋ РЅР°РґРїРёСЃСЊ РѕС‚ Р±Р°Р·РѕРІРѕРіРѕ РєР»Р°СЃСЃР°
      JLabel label = (JLabel)super.
          getTableCellRendererComponent(table,
              imageCell.getText(), isSelected, hasFocus,
              row, column);
      // СѓСЃС‚Р°РЅР°РІР»РёРІР°РµРј Р·РЅР°С‡РѕРє Рё РїРѕРґСЃРєР°Р·РєСѓ
      label.setIcon(imageCell.getIcon());
      label.setToolTipText(imageCell.getText());
      return label;
    } else {
      return super.getTableCellRendererComponent(
          table, value, isSelected, hasFocus, row, column);
    }
  }
}
