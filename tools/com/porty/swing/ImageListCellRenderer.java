// com/porty/swing/ImageListCellRenderer.java
// РљР»Р°СЃСЃ РґР»СЏ РїСЂРѕСЂРёСЃРѕРІРєРё РІ СЃРїРёСЃРєРµ РѕРґРЅРѕРІСЂРµРјРµРЅРЅРѕ
// Р·РЅР°С‡РєР° Рё С‚РµРєСЃС‚Р°
package com.porty.swing;

import javax.swing.*;
import java.awt.*;

public class ImageListCellRenderer
    extends DefaultListCellRenderer {
  // РјРµС‚РѕРґ, РІРѕР·РІСЂР°С‰Р°СЋС‰РёР№ РґР»СЏ СЌР»РµРјРµРЅС‚Р° СЂРёСЃСѓСЋС‰РёР№ РєРѕРјРїРѕРЅРµРЅС‚
  public Component getListCellRendererComponent(
      JList list, Object data, int idx, boolean isSelected,
      boolean hasFocus) {
    // РїСЂРѕРІРµСЂСЏРµРј, РЅСѓР¶РЅРѕРіРѕ Р»Рё СЌР»РµРјРµРЅС‚ С‚РёРїР°
    if ( data instanceof ImageListElement ) {
      ImageListElement lie =
          (ImageListElement)data;
      // РїРѕР»СѓС‡Р°РµРј С‚РµРєСЃС‚ Рё Р·РЅР°С‡РѕРє
      Icon icon = lie.getIcon();
      String text = lie.getText();
      // РёСЃРїРѕР»СЊР·СѓРµРј РІРѕР·РјРѕР¶РЅРѕСЃС‚Рё Р±Р°Р·РѕРІРѕРіРѕ РєР»Р°СЃСЃР°
      JLabel label = (JLabel)
          super.getListCellRendererComponent(
              list, text, idx, isSelected, hasFocus);
      label.setIcon(icon);
      return label;
    } else
      return super.getListCellRendererComponent(
          list, data, idx, isSelected, hasFocus);
  }
}