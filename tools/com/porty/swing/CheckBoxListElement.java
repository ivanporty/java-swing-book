// com/porty/swing/CheckBoxListElement.java
// Р”Р°РЅРЅС‹Рµ СЌР»РµРјРµРЅС‚Р° СЃРїРёСЃРєР° СЃ С„Р»Р°Р¶РєР°РјРё
package com.porty.swing;

public class CheckBoxListElement {
  // РґР°РЅРЅС‹Рµ СЌР»РµРјРµРЅС‚Р°
  private boolean selected;
  private String text;
  // СѓРґРѕР±РЅС‹Р№ РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ
  public CheckBoxListElement(boolean selected, String text){
    this.selected = selected;
    this.text = text;
  }
  // РјРµС‚РѕРґС‹ РґР»СЏ РґРѕСЃС‚СѓРїР° Рє Р·РЅР°С‡РєСѓ Рё С‚РµРєСЃС‚Сѓ
  public boolean isSelected() {  return selected; }
  public String getText() { return text; }
  public void setSelected(boolean selected) {
    this.selected = selected;
  }
  public void setText(String text) { this.text = text; }
}