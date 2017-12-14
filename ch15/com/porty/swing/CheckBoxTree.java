// com/porty/swing/CheckBoxTree.java
// Дерево, способное отображать в качестве узлов флажки
package com.porty.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class CheckBoxTree extends JTree {
  // конструктор на основе модели
  public CheckBoxTree(TreeModel model) {
    super(model);
    // задаем собственный отображающий объект
    setCellRenderer(new CheckBoxRenderer());
    // следим за щелчками мыши
    addMouseListener(new MouseL());
  }
  // стандартный объект для отображения узлов
  private DefaultTreeCellRenderer renderer =
      new DefaultTreeCellRenderer();
  // флажок для отображения узлов дерева
  class CheckBoxRenderer extends JCheckBox
      implements TreeCellRenderer {
    public CheckBoxRenderer() {
      // делаем флажок прозрачным
      setOpaque(false);
    }
    // данный метод должен вернуть компонент для узла
    public Component getTreeCellRendererComponent(
        JTree tree, Object value, boolean selected,
        boolean expanded, boolean leaf, int row,
        boolean hasFocus) {
      // проверяем, что используется стандартная модель
      if (!(value instanceof DefaultMutableTreeNode)) {
        // если нет, то используем стандартный объект
        return renderer.getTreeCellRendererComponent(
            tree, value, selected, expanded,
            leaf, row, hasFocus);
      }
      Object data = ((DefaultMutableTreeNode)value).
          getUserObject();
      // проверяем, подходит ли нам тип данных узла
      if ( data instanceof CheckBoxListElement ) {
        CheckBoxListElement element =
            (CheckBoxListElement)data;
        // настраиваем флажок
        setSelected(element.isSelected());
        setText(element.getText());
        return this;
      }
      // иначе задействуем стандартный объект
      return renderer.getTreeCellRendererComponent(tree,
          value, selected, expanded, leaf, row, hasFocus);
    }
  }
  // класс, следящий за щелчками мыши
  class MouseL extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      // получим путь к узлу
      TreePath path = getClosestPathForLocation(
          e.getX(), e.getY());
      if ( path == null ) return;
      // проверим, подходят ли нам данные узла
      Object _node = path.getLastPathComponent();
      if (_node instanceof DefaultMutableTreeNode) {
        DefaultMutableTreeNode node =
            (DefaultMutableTreeNode)_node;
        Object data = node.getUserObject();
        if ( data instanceof CheckBoxListElement ) {
          // меняем состояние флажка
          CheckBoxListElement element =
              (CheckBoxListElement)data;
          element.setSelected(! element.isSelected());
          repaint(getPathBounds(path));
        }
      }
    }
  }
}