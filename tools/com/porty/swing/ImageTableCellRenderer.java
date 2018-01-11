// com/porty/swing/ImageTableCellRenderer.java
// Объект для прорисовки значка и текста в таблице
package com.porty.swing;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ImageTableCellRenderer
    extends DefaultTableCellRenderer {
  // метод возвращает компонент для прорисовки
  public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    // получаем объект нужного типа
    if ( value instanceof ImageListElement ) {
      ImageListElement imageCell = (ImageListElement)value;
      // получаем настроенную надпись от базового класса
      JLabel label = (JLabel)super.
          getTableCellRendererComponent(table,
              imageCell.getText(), isSelected, hasFocus,
              row, column);
      // устанавливаем значок и подсказку
      label.setIcon(imageCell.getIcon());
      label.setToolTipText(imageCell.getText());
      return label;
    } else {
      return super.getTableCellRendererComponent(
          table, value, isSelected, hasFocus, row, column);
    }
  }
}
