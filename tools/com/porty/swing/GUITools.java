// com/porty/swing/GUITools.java
// Набор инструментов для окончательной
// шлифовки и придания блеска интерфейсу
package com.porty.swing;

import javax.swing.*;
import java.awt.*;

public class GUITools {
  // инструмент для придания группе компонентов
  // одинаковых размеров (минимальных,
  // предпочтительных и максимальных).
  public static void makeSameSize(JComponent... cs) {
    // определение максимального размера
    Dimension maxSize = cs[0].getPreferredSize();
    for (JComponent c: cs) {
      if ( c.getPreferredSize().width > maxSize.width ) {
        maxSize = c.getPreferredSize();
      }
    }
    // придание одинаковых размеров
    for (JComponent c : cs) {
      c.setPreferredSize(maxSize);
      c.setMinimumSize(maxSize);
      c.setMaximumSize(maxSize);
    }
  }
  // позволяет исправить оплошность в
  // размерах текстового поля JTextField
  public static void fixTextFieldSize(JTextField field) {
    Dimension size = field.getPreferredSize();
    // чтобы текстовое поле по-прежнему могло
    // увеличивать свой размер в длину
    size.width = field.getMaximumSize().width;
    // теперь текстовое поле не станет выше
    // своей оптимальной высоты
    field.setMaximumSize(size);
  }
}