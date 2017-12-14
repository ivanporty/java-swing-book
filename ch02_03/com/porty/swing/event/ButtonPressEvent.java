// com/porty/swing/event/ButtonPressEvent.java
// Класс события для кнопки SimpleButton
package com.porty.swing.event;

import java.util.EventObject;

public class ButtonPressEvent extends EventObject {
  // конструктор. Требует задать источник события
  public ButtonPressEvent(Object source) {
    super(source);
  }
}