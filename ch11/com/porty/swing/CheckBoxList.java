// CheckBoxList.java
// Список с флажками
package com.porty.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class CheckBoxList extends JList {
  // сохраняем все конструкторы
  public CheckBoxList(ListModel model) {
    super(model);
    initList();
  }
  public CheckBoxList(Object[] data) {
    super(data);
    initList();
  }
  public CheckBoxList(Vector data) {
    super(data);
    initList();
  }
  // специальная настройка списка
  private void initList() {
    setCellRenderer(new CheckBoxCellRenderer());
    setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // следим за щелчками
        if ( e.getClickCount() == 1 &&
            SwingUtilities.isLeftMouseButton(e) ) {
          // нужный нам щелчок
          int pos =
              locationToIndex(e.getPoint());
          CheckBoxListElement cbel =
              (CheckBoxListElement)getModel().
                  getElementAt(pos);
          cbel.setSelected(! cbel.isSelected());
          // заново рисуем только эту ячейку списка
          repaint(getCellBounds(pos, pos));
        }
      }
    });
  }
  // отображающий флажки объект
  public static class CheckBoxCellRenderer
      extends JCheckBox implements ListCellRenderer {
    public Component getListCellRendererComponent(
        JList list, Object data, int idx,
        boolean isSelected, boolean hasFocus) {
      // полагаем, что данные всегда нужного типа
      CheckBoxListElement
          cbel = (CheckBoxListElement)data;
      // настраиваем флажок
      if ( isSelected ) {
        setBackground(list.getSelectionBackground());
        setForeground(list.getSelectionForeground());
      } else {
        setBackground(list.getBackground());
        setForeground(list.getForeground());
      }
      setSelected(cbel.isSelected());
      setText(cbel.getText());
      return this;
    }
  }
}