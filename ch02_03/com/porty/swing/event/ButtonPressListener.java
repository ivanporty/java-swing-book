// com/porty/swing/event/ButtonPressListener.java
// Интерфейс слушателя события нажатия кнопки
package com.porty.swing.event;

import java.util.EventListener;

public interface ButtonPressListener extends EventListener {
  // данный метод будет вызываться при нажатии кнопки
  void buttonPressed(ButtonPressEvent e);
}