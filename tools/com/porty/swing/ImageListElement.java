// com/porty/swing/ImageListElement.java
// РљР»Р°СЃСЃ, С…СЂР°РЅСЏС‰РёР№ Р·РЅР°С‡РѕРє Рё С‚РµРєСЃС‚ СЌР»РµРјРµРЅС‚Р°
package com.porty.swing;

import javax.swing.*;

public class ImageListElement {
  // Р·РЅР°С‡РѕРє Рё С‚РµРєСЃС‚
  private Icon icon;
  private String text;
	// СѓРґРѕР±РЅС‹Р№ РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ
	public ImageListElement(Icon icon, String text) {
		this.icon = icon;
		this.text = text;
	}
  // РјРµС‚РѕРґС‹ РґР»СЏ РґРѕСЃС‚СѓРїР° Рє Р·РЅР°С‡РєСѓ Рё С‚РµРєСЃС‚Сѓ
  public Icon getIcon() {  return icon; }
  public String getText() { return text; }
  public void setIcon(Icon icon) { this.icon = icon; }
  public void setText(String text) { this.text = text; }
}