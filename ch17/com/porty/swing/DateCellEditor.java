// com/porty/swing/DateCellEditor.java
// Редактор для ячеек таблицы, отображающих даты
package com.porty.swing;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class DateCellEditor extends AbstractCellEditor
    implements TableCellEditor {
  // редактор - прокручивающийся список
  private JSpinner editor;
  // конструктор
  public DateCellEditor() {
    // настраиваем прокручивающийся список
    SpinnerDateModel model = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    editor = new JSpinner(model);
  }
  // возвращает компонент, применяемый для редактирования
  public java.awt.Component getTableCellEditorComponent(
      JTable table, Object value, boolean isSelected,
      int row, int column) {
    // меняем значение и возвращаем список
    editor.setValue(value);
    return editor;
  }
  // возвращает текущее значение в редакторе
  public Object getCellEditorValue() {
    return editor.getValue();
  }
}
