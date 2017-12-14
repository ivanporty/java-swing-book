// com/porty/swing/CheckBoxListElement.java
// Данные элемента списка с флажками
package com.porty.swing;

public class CheckBoxListElement {
  // данные элемента
  private boolean selected;
  private String text;
  // удобный конструктор
  public CheckBoxListElement(boolean selected, String text){
    this.selected = selected;
    this.text = text;
  }
  // методы для доступа к значку и тексту
  public boolean isSelected() {  return selected; }
  public String getText() { return text; }
  public void setSelected(boolean selected) {
    this.selected = selected;
  }
  public void setText(String text) { this.text = text; }
}