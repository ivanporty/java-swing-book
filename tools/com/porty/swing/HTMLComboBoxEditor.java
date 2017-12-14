// com/porty/swing/HTMLComboBoxEditor.java
// РџРѕР»РЅРѕС„СѓРЅРєС†РёРѕРЅР°Р»СЊРЅС‹Р№ СЂРµРґР°РєС‚РѕСЂ РґР»СЏ СЃРїРёСЃРєР°
// JComboBox, РёСЃРїРѕР»СЊР·СѓСЋС‰РµРіРѕ HTML
package com.porty.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HTMLComboBoxEditor
    implements ComboBoxEditor {
  // СЂРµРґР°РєС‚РѕСЂ РґР»СЏ HTML
  private JEditorPane htmlEditor;
  public HTMLComboBoxEditor() {
    htmlEditor =
        new JEditorPane("text/html", "");
    htmlEditor.setBorder(BorderFactory.
        createEtchedBorder());
  }
  // РІРѕР·РІСЂР°С‰Р°РµС‚ СЂРµРґР°РєС‚РѕСЂ
  public Component getEditorComponent() {
    return htmlEditor;
  }
  // СЃРёРіРЅР°Р» РІС‹Р±СЂР°С‚СЊ РІРµСЃСЊ С‚РµРєСЃС‚ Рё РїСЂРёСЃС‚СѓРїРёС‚СЊ
  // Рє СЂРµРґР°РєС‚РёСЂРѕРІР°РЅРёСЋ
  public void selectAll() {
    htmlEditor.selectAll();
    htmlEditor.requestFocus();
  }
  // РІРѕР·РІСЂР°С‰Р°РµС‚ СЂРµРґР°РєС‚РёСЂСѓРµРјС‹Р№ СЌР»РµРјРµРЅС‚
  public Object getItem() {
    return htmlEditor.getText();
  }
  // РїРѕР»СѓС‡Р°РµС‚ РЅРѕРІС‹Р№ СЌР»РµРјРµРЅС‚ РґР»СЏ СЂРµРґР°РєС‚РёСЂРѕРІР°РЅРёСЏ
  public void setItem(Object item) {
    htmlEditor.setText(item.toString());
  }
  // РјРµС‚РѕРґС‹ РґР»СЏ РїСЂРёСЃРѕРµРґРёРЅРµРЅРёСЏ СЃР»СѓС€Р°С‚РµР»РµР№
  // ActionListener, РєРѕС‚РѕСЂС‹Р№ РѕРїРѕРІРµС‰Р°СЋС‚СЃСЏ
  // РѕР± РѕРєРѕРЅС‡Р°РЅРёРё СЂРµРґР°РєС‚РёСЂРѕРІР°РЅРёСЏ
  public void addActionListener(
      ActionListener e) { }
  public void removeActionListener(
      ActionListener e) { }
}