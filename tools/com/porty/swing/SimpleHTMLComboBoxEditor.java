// com/porty/swing/
// SimpleHTMLComboBoxEditor.java
// РџСЂРѕСЃС‚РѕР№ СЂРµРґР°РєС‚РѕСЂ РґР»СЏ СЂР°СЃРєСЂС‹РІР°СЋС‰РµРіРѕСЃСЏ СЃРїРёСЃРєР°,
// РёСЃРїРѕР»СЊР·СѓСЋС‰РµРіРѕ HTML
package com.porty.swing;
import javax.swing.plaf.basic.*;

public class SimpleHTMLComboBoxEditor
    extends BasicComboBoxEditor {
  // РІ СЌС‚РѕС‚ РјРµС‚РѕРґ РїРµСЂРµРґР°РµС‚СЃСЏ РЅРѕРІС‹Р№ СЌР»РµРјРµРЅС‚
  // РґР»СЏ СЂРµРґР°РєС‚РёСЂРѕРІР°РЅРёСЏ
  public void setItem(Object item) {
    // РїРѕР»СѓС‡Р°РµРј СЃС‚СЂРѕРєРѕРІРѕРµ РїСЂРµРґСЃС‚Р°РІР»РµРЅРёРµ
    String text = item.toString();
    // Р·Р°РјРµРЅСЏРµРј РІСЃРµ С‚РµРіРё СЃ РїРѕРјРѕС‰СЊСЋ СЂРµРіСѓР»СЏСЂРЅРѕРіРѕ РІС‹СЂР°Р¶РµРЅРёСЏ
    String noHTMLString = text.replaceAll("\\<.*?\\>", "");
    // РїРµСЂРµРґР°РµРј "РѕС‡РёС‰РµРЅРЅСѓСЋ" СЃС‚СЂРѕРєСѓ
    // СЃС‚Р°РЅРґР°СЂС‚РЅРѕРјСѓ РѕР±СЉРµРєС‚Сѓ
    super.setItem(noHTMLString);
  }
}