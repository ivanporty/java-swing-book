// com/porty/swing/HTMLComboBoxEditor.java
// Полнофункциональный редактор для списка
// JComboBox, использующего HTML
package com.porty.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HTMLComboBoxEditor
    implements ComboBoxEditor {
  // редактор для HTML
  private JEditorPane htmlEditor;
  public HTMLComboBoxEditor() {
    htmlEditor =
        new JEditorPane("text/html", "");
    htmlEditor.setBorder(BorderFactory.
        createEtchedBorder());
  }
  // возвращает редактор
  public Component getEditorComponent() {
    return htmlEditor;
  }
  // сигнал выбрать весь текст и приступить
  // к редактированию
  public void selectAll() {
    htmlEditor.selectAll();
    htmlEditor.requestFocus();
  }
  // возвращает редактируемый элемент
  public Object getItem() {
    return htmlEditor.getText();
  }
  // получает новый элемент для редактирования
  public void setItem(Object item) {
    htmlEditor.setText(item.toString());
  }
  // методы для присоединения слушателей
  // ActionListener, который оповещаются
  // об окончании редактирования
  public void addActionListener(
      ActionListener e) { }
  public void removeActionListener(
      ActionListener e) { }
}