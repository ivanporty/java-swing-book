// com/porty/swing/BoxLayoutUtils.java
// РљР»Р°СЃСЃ РґР»СЏ СѓРґРѕР±РЅРѕР№ СЂР°Р±РѕС‚С‹ СЃ Р±Р»РѕС‡РЅС‹Рј СЂР°СЃРїРѕР»РѕР¶РµРЅРёРµРј
package com.porty.swing;
import javax.swing.*;
import java.awt.*;

public class BoxLayoutUtils {
	// Р·Р°РґР°РµС‚ РµРґРёРЅРѕРµ РІС‹СЂР°РІРЅРёРІР°РЅРёРµ РїРѕ РѕСЃРё X РґР»СЏ
	// РіСЂСѓРїРїС‹ РєРѕРјРїРѕРЅРµРЅС‚РѕРІ
	public static void setGroupAlignmentX(float alignment, JComponent... cs) {
    for (JComponent c : cs) {
      c.setAlignmentX(alignment);
    }
	}
	// Р·Р°РґР°РµС‚ РµРґРёРЅРѕРµ РІС‹СЂР°РІРЅРёРІР°РЅРёРµ РїРѕ РѕСЃРё Y РґР»СЏ
	// РіСЂСѓРїРїС‹ РєРѕРјРїРѕРЅРµРЅС‚РѕРІ
	public static void setGroupAlignmentY(float alignment, JComponent... cs) {
    for (JComponent c : cs) {
      c.setAlignmentY(alignment);
    }
	}
	// РІРѕР·РІСЂР°С‰Р°РµС‚ РїР°РЅРµР»СЊ СЃ СѓСЃС‚Р°РЅРѕРІР»РµРЅРЅС‹Рј РІРµСЂС‚РёРєР°Р»СЊРЅС‹Рј
	// Р±Р»РѕС‡РЅС‹Рј СЂР°СЃРїРѕР»РѕР¶РµРЅРёРµРј
	public static JPanel createVerticalPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));		
		return p;
	}
	// РІРѕР·РІСЂР°С‰Р°РµС‚ РїР°РЅРµР»СЊ СЃ СѓСЃС‚Р°РЅРѕРІР»РµРЅРЅС‹Рј РіРѕСЂРёР·РѕРЅС‚Р°Р»СЊРЅС‹Рј
	// Р±Р»РѕС‡РЅС‹Рј СЂР°СЃРїРѕР»РѕР¶РµРЅРёРµРј
	public static JPanel createHorizontalPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));		
		return p;
	}
  // СЃРѕР·РґР°РµС‚ РіРѕСЂРёР·РѕРЅС‚Р°Р»СЊРЅСѓСЋ СЂР°СЃРїРѕСЂРєСѓ
  // С„РёРєСЃРёСЂРѕРІР°РЅРЅРѕРіРѕ СЂР°Р·РјРµСЂР°
  public static Component createHorizontalStrut(int size) {
    return Box.createRigidArea(new Dimension(size, 0));
  }
  // СЃРѕР·РґР°РµС‚ РІРµСЂС‚РёРєР°Р»СЊРЅСѓСЋ СЂР°СЃРїРѕСЂРєСѓ
  // С„РёРєСЃРёСЂРѕРІР°РЅРЅРѕРіРѕ СЂР°Р·РјРµСЂР°
  public static Component createVerticalStrut(int size) {
    return Box.createRigidArea(new Dimension(0, size));
  }
}