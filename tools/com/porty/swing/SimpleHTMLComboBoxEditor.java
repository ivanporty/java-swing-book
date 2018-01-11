// com/porty/swing/
// SimpleHTMLComboBoxEditor.java
// Простой редактор для раскрывающегося списка,
// использующего HTML
package com.porty.swing;
import javax.swing.plaf.basic.*;

public class SimpleHTMLComboBoxEditor
    extends BasicComboBoxEditor {
  // в этот метод передается новый элемент
  // для редактирования
  public void setItem(Object item) {
    // получаем строковое представление
    String text = item.toString();
    // заменяем все теги с помощью регулярного выражения
    String noHTMLString = text.replaceAll("\\<.*?\\>", "");
    // передаем "очищенную" строку
    // стандартному объекту
    super.setItem(noHTMLString);
  }
}