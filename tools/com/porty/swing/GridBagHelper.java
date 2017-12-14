// com/porty/swing/GridBagHelper.java
// Р’СЃРїРѕРјРѕРіР°С‚РµР»СЊРЅС‹Р№ РєР»Р°СЃСЃ, РїРѕР·РІРѕР»СЏСЋС‰РёР№ РїРёСЃР°С‚СЊ
// РєР°С‡РµСЃС‚РІРµРЅРЅС‹Р№ РєРѕРґ РґР»СЏ СЂР°СЃРїРѕР»РѕР¶РµРЅРёСЏ GridBagLayout
package com.porty.swing;

import javax.swing.*;
import java.awt.*;

public class GridBagHelper {
  // РєРѕРѕСЂРґРёРЅР°С‚С‹ С‚РµРєСѓС‰РµР№ СЏС‡РµР№РєРё
  private int gridx, gridy;
  // РЅР°СЃС‚СЂР°РёРІР°РµРјС‹Р№ РѕР±СЉРµРєС‚ GridBagConstraints
  private GridBagConstraints constraints;

  // РІРѕР·РІСЂР°С‰Р°РµС‚ РЅР°СЃС‚СЂРѕРµРЅРЅС‹Р№ РѕР±СЉРµРєС‚ GridBagConstraints
  public GridBagConstraints get() {
    return constraints;
  }
  // РґРІРёРіР°РµС‚СЃСЏ РЅР° СЃР»РµРґСѓСЋС‰СѓСЋ СЏС‡РµР№РєСѓ
  public GridBagHelper nextCell() {
    constraints = new GridBagConstraints();
    constraints.gridx = gridx++;
    constraints.gridy = gridy;
    // РґР»СЏ СѓРґРѕР±СЃС‚РІР° РІРѕР·РІСЂР°С‰Р°РµРј СЃРµР±СЏ
    return this;
  }
  // РґРІРёРіР°РµС‚СЃСЏ РЅР° СЃР»РµРґСѓСЋС‰РёР№ СЂСЏРґ
  public GridBagHelper nextRow() {
    gridy++;
    gridx = 0;
    constraints.gridx = 0;
    constraints.gridy = gridy;
    return this;
  }
  // СЂР°Р·РґРІРёРіР°РµС‚ СЏС‡РµР№РєСѓ РґРѕ РєРѕРЅС†Р° СЃС‚СЂРѕРєРё
  public GridBagHelper span() {
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    return this;
  }
  // Р·Р°РїРѕР»РЅСЏРµС‚ СЏС‡РµР№РєСѓ РїРѕ РіРѕСЂРёР·РѕРЅС‚Р°Р»Рё
  public GridBagHelper fillHorizontally() {
    constraints.fill = GridBagConstraints.HORIZONTAL;
    return this;
  }
  // РІСЃС‚Р°РІР»СЏРµС‚ СЂР°СЃРїРѕСЂРєСѓ СЃРїСЂР°РІР°
  public GridBagHelper gap(int size) {
    constraints.insets.right = size;
    return this;
  }

  public GridBagHelper spanY() {
    constraints.gridheight = GridBagConstraints.REMAINDER;
    return this;
  }


  public GridBagHelper fillBoth() {
    constraints.fill = GridBagConstraints.BOTH;
    return this;
  }

  public GridBagHelper alignLeft() {
    constraints.anchor = GridBagConstraints.LINE_START;
    return this;
  }

  public GridBagHelper alignRight() {
    constraints.anchor = GridBagConstraints.LINE_END;
    return this;
  }

  public GridBagHelper setInsets(int left, int top, int right, int bottom) {
    Insets i = new Insets(top, left, bottom, right);
    constraints.insets = i;
    return this;
  }

  public GridBagHelper setWeights(float horizontal, float vertical) {
    constraints.weightx = horizontal;
    constraints.weighty = vertical;
    return this;
  }

  public void insertEmptyRow(Container c, int height) {
    Component comp = Box.createVerticalStrut(height);
    nextCell().nextRow().fillHorizontally().span();
    c.add(comp, get());
    nextRow();
  }

  public void insertEmptyFiller(Container c) {
    Component comp = Box.createGlue();
    nextCell().nextRow().fillBoth().span().spanY().setWeights(1.0f, 1.0f);
    c.add(comp, get());
    nextRow();
  }
}
