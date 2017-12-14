// com/porty/swing/CheckBoxTree.java
// Р”РµСЂРµРІРѕ, СЃРїРѕСЃРѕР±РЅРѕРµ РѕС‚РѕР±СЂР°Р¶Р°С‚СЊ РІ РєР°С‡РµСЃС‚РІРµ СѓР·Р»РѕРІ С„Р»Р°Р¶РєРё
package com.porty.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class CheckBoxTree extends JTree {
  // РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ РЅР° РѕСЃРЅРѕРІРµ РјРѕРґРµР»Рё
  public CheckBoxTree(TreeModel model) {
    super(model);
    // Р·Р°РґР°РµРј СЃРѕР±СЃС‚РІРµРЅРЅС‹Р№ РѕС‚РѕР±СЂР°Р¶Р°СЋС‰РёР№ РѕР±СЉРµРєС‚
    setCellRenderer(new CheckBoxRenderer());
    // СЃР»РµРґРёРј Р·Р° С‰РµР»С‡РєР°РјРё РјС‹С€Рё
    addMouseListener(new MouseL());
  }
  // СЃС‚Р°РЅРґР°СЂС‚РЅС‹Р№ РѕР±СЉРµРєС‚ РґР»СЏ РѕС‚РѕР±СЂР°Р¶РµРЅРёСЏ СѓР·Р»РѕРІ
  private DefaultTreeCellRenderer renderer =
      new DefaultTreeCellRenderer();
  // С„Р»Р°Р¶РѕРє РґР»СЏ РѕС‚РѕР±СЂР°Р¶РµРЅРёСЏ СѓР·Р»РѕРІ РґРµСЂРµРІР°
  class CheckBoxRenderer extends JCheckBox
      implements TreeCellRenderer {
    public CheckBoxRenderer() {
      // РґРµР»Р°РµРј С„Р»Р°Р¶РѕРє РїСЂРѕР·СЂР°С‡РЅС‹Рј
      setOpaque(false);
    }
    // РґР°РЅРЅС‹Р№ РјРµС‚РѕРґ РґРѕР»Р¶РµРЅ РІРµСЂРЅСѓС‚СЊ РєРѕРјРїРѕРЅРµРЅС‚ РґР»СЏ СѓР·Р»Р°
    public Component getTreeCellRendererComponent(
        JTree tree, Object value, boolean selected,
        boolean expanded, boolean leaf, int row,
        boolean hasFocus) {
      // РїСЂРѕРІРµСЂСЏРµРј, С‡С‚Рѕ РёСЃРїРѕР»СЊР·СѓРµС‚СЃСЏ СЃС‚Р°РЅРґР°СЂС‚РЅР°СЏ РјРѕРґРµР»СЊ
      if (!(value instanceof DefaultMutableTreeNode)) {
        // РµСЃР»Рё РЅРµС‚, С‚Рѕ РёСЃРїРѕР»СЊР·СѓРµРј СЃС‚Р°РЅРґР°СЂС‚РЅС‹Р№ РѕР±СЉРµРєС‚
        return renderer.getTreeCellRendererComponent(
            tree, value, selected, expanded,
            leaf, row, hasFocus);
      }
      Object data = ((DefaultMutableTreeNode)value).
          getUserObject();
      // РїСЂРѕРІРµСЂСЏРµРј, РїРѕРґС…РѕРґРёС‚ Р»Рё РЅР°Рј С‚РёРї РґР°РЅРЅС‹С… СѓР·Р»Р°
      if ( data instanceof CheckBoxListElement ) {
        CheckBoxListElement element =
            (CheckBoxListElement)data;
        // РЅР°СЃС‚СЂР°РёРІР°РµРј С„Р»Р°Р¶РѕРє
        setSelected(element.isSelected());
        setText(element.getText());
        return this;
      }
      // РёРЅР°С‡Рµ Р·Р°РґРµР№СЃС‚РІСѓРµРј СЃС‚Р°РЅРґР°СЂС‚РЅС‹Р№ РѕР±СЉРµРєС‚
      return renderer.getTreeCellRendererComponent(tree,
          value, selected, expanded, leaf, row, hasFocus);
    }
  }
  // РєР»Р°СЃСЃ, СЃР»РµРґСЏС‰РёР№ Р·Р° С‰РµР»С‡РєР°РјРё РјС‹С€Рё
  class MouseL extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      // РїРѕР»СѓС‡РёРј РїСѓС‚СЊ Рє СѓР·Р»Сѓ
      TreePath path = getClosestPathForLocation(
          e.getX(), e.getY());
      if ( path == null ) return;
      // РїСЂРѕРІРµСЂРёРј, РїРѕРґС…РѕРґСЏС‚ Р»Рё РЅР°Рј РґР°РЅРЅС‹Рµ СѓР·Р»Р°
      Object _node = path.getLastPathComponent();
      if (_node instanceof DefaultMutableTreeNode) {
        DefaultMutableTreeNode node =
            (DefaultMutableTreeNode)_node;
        Object data = node.getUserObject();
        if ( data instanceof CheckBoxListElement ) {
          // РјРµРЅСЏРµРј СЃРѕСЃС‚РѕСЏРЅРёРµ С„Р»Р°Р¶РєР°
          CheckBoxListElement element =
              (CheckBoxListElement)data;
          element.setSelected(! element.isSelected());
          repaint(getPathBounds(path));
        }
      }
    }
  }
}