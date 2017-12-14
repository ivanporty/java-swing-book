// com/porty/swing/ImageListCellRenderer.java
// Класс для прорисовки в списке одновременно
// значка и текста
package com.porty.swing;

import javax.swing.*;
import java.awt.*;

public class ImageListCellRenderer
    extends DefaultListCellRenderer {
  // метод, возвращающий для элемента рисующий компонент
  public Component getListCellRendererComponent(
      JList list, Object data, int idx, boolean isSelected,
      boolean hasFocus) {
    // проверяем, нужного ли элемент типа
    if ( data instanceof ImageListElement ) {
      ImageListElement lie =
          (ImageListElement)data;
      // получаем текст и значок
      Icon icon = lie.getIcon();
      String text = lie.getText();
      // используем возможности базового класса
      JLabel label = (JLabel)
          super.getListCellRendererComponent(
              list, text, idx, isSelected, hasFocus);
      label.setIcon(icon);
      return label;
    } else
      return super.getListCellRendererComponent(
          list, data, idx, isSelected, hasFocus);
  }
}