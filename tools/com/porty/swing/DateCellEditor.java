// com/porty/swing/DateCellEditor.java
// Р РµРґР°РєС‚РѕСЂ РґР»СЏ СЏС‡РµРµРє С‚Р°Р±Р»РёС†С‹, РѕС‚РѕР±СЂР°Р¶Р°СЋС‰РёС… РґР°С‚С‹
package com.porty.swing;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class DateCellEditor extends AbstractCellEditor
    implements TableCellEditor {
  // СЂРµРґР°РєС‚РѕСЂ - РїСЂРѕРєСЂСѓС‡РёРІР°СЋС‰РёР№СЃСЏ СЃРїРёСЃРѕРє
  private JSpinner editor;
  // РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ
  public DateCellEditor() {
    // РЅР°СЃС‚СЂР°РёРІР°РµРј РїСЂРѕРєСЂСѓС‡РёРІР°СЋС‰РёР№СЃСЏ СЃРїРёСЃРѕРє
    SpinnerDateModel model = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    editor = new JSpinner(model);
  }
  // РІРѕР·РІСЂР°С‰Р°РµС‚ РєРѕРјРїРѕРЅРµРЅС‚, РїСЂРёРјРµРЅСЏРµРјС‹Р№ РґР»СЏ СЂРµРґР°РєС‚РёСЂРѕРІР°РЅРёСЏ
  public java.awt.Component getTableCellEditorComponent(
      JTable table, Object value, boolean isSelected,
      int row, int column) {
    // РјРµРЅСЏРµРј Р·РЅР°С‡РµРЅРёРµ Рё РІРѕР·РІСЂР°С‰Р°РµРј СЃРїРёСЃРѕРє
    editor.setValue(value);
    return editor;
  }
  // РІРѕР·РІСЂР°С‰Р°РµС‚ С‚РµРєСѓС‰РµРµ Р·РЅР°С‡РµРЅРёРµ РІ СЂРµРґР°РєС‚РѕСЂРµ
  public Object getCellEditorValue() {
    return editor.getValue();
  }
}
