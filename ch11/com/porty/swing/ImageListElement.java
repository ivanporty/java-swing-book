// com/porty/swing/ImageListElement.java
// Класс, хранящий значок и текст элемента
package com.porty.swing;

import javax.swing.*;

public class ImageListElement {
  // значок и текст
  private Icon icon;
  private String text;
	// удобный конструктор
	public ImageListElement(Icon icon, String text) {
		this.icon = icon;
		this.text = text;
	}
  // методы для доступа к значку и тексту
  public Icon getIcon() {  return icon; }
  public String getText() { return text; }
  public void setIcon(Icon icon) { this.icon = icon; }
  public void setText(String text) { this.text = text; }
}