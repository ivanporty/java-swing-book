// com/porty/swing/GUITools.java
// РќР°Р±РѕСЂ РёРЅСЃС‚СЂСѓРјРµРЅС‚РѕРІ РґР»СЏ РѕРєРѕРЅС‡Р°С‚РµР»СЊРЅРѕР№
// С€Р»РёС„РѕРІРєРё Рё РїСЂРёРґР°РЅРёСЏ Р±Р»РµСЃРєР° РёРЅС‚РµСЂС„РµР№СЃСѓ
package com.porty.swing;

import javax.swing.*;
import java.awt.*;

public class GUITools {
  // РёРЅСЃС‚СЂСѓРјРµРЅС‚ РґР»СЏ РїСЂРёРґР°РЅРёСЏ РіСЂСѓРїРїРµ РєРѕРјРїРѕРЅРµРЅС‚РѕРІ
  // РѕРґРёРЅР°РєРѕРІС‹С… СЂР°Р·РјРµСЂРѕРІ (РјРёРЅРёРјР°Р»СЊРЅС‹С…,
  // РїСЂРµРґРїРѕС‡С‚РёС‚РµР»СЊРЅС‹С… Рё РјР°РєСЃРёРјР°Р»СЊРЅС‹С…).
  public static void makeSameSize(JComponent... cs) {
    // РѕРїСЂРµРґРµР»РµРЅРёРµ РјР°РєСЃРёРјР°Р»СЊРЅРѕРіРѕ СЂР°Р·РјРµСЂР°
    Dimension maxSize = cs[0].getPreferredSize();
    for (JComponent c: cs) {
      if ( c.getPreferredSize().width > maxSize.width ) {
        maxSize = c.getPreferredSize();
      }
    }
    // РїСЂРёРґР°РЅРёРµ РѕРґРёРЅР°РєРѕРІС‹С… СЂР°Р·РјРµСЂРѕРІ
    for (JComponent c : cs) {
      c.setPreferredSize(maxSize);
      c.setMinimumSize(maxSize);
      c.setMaximumSize(maxSize);
    }
  }
  // РїРѕР·РІРѕР»СЏРµС‚ РёСЃРїСЂР°РІРёС‚СЊ РѕРїР»РѕС€РЅРѕСЃС‚СЊ РІ
  // СЂР°Р·РјРµСЂР°С… С‚РµРєСЃС‚РѕРІРѕРіРѕ РїРѕР»СЏ JTextField
  public static void fixTextFieldSize(JTextField field) {
    Dimension size = field.getPreferredSize();
    // С‡С‚РѕР±С‹ С‚РµРєСЃС‚РѕРІРѕРµ РїРѕР»Рµ РїРѕ-РїСЂРµР¶РЅРµРјСѓ РјРѕРіР»Рѕ
    // СѓРІРµР»РёС‡РёРІР°С‚СЊ СЃРІРѕР№ СЂР°Р·РјРµСЂ РІ РґР»РёРЅСѓ
    size.width = field.getMaximumSize().width;
    // С‚РµРїРµСЂСЊ С‚РµРєСЃС‚РѕРІРѕРµ РїРѕР»Рµ РЅРµ СЃС‚Р°РЅРµС‚ РІС‹С€Рµ
    // СЃРІРѕРµР№ РѕРїС‚РёРјР°Р»СЊРЅРѕР№ РІС‹СЃРѕС‚С‹
    field.setMaximumSize(size);
  }
}