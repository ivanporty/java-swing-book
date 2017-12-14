// com/porty/swing/SimpleButton.java
// Пример компонента со своим собственным событием
package com.porty.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import com.porty.swing.event.*;

public class SimpleButton extends JComponent {
  // список слушателей
  private ArrayList<ButtonPressListener>
      listenerList = new ArrayList<ButtonPressListener>();
  // один объект-событие на все случаи жизни
  private ButtonPressEvent event =
      new ButtonPressEvent(this);

  // конструктор - присоединяет к кнопке слушателя
  // событий от мыши
  public SimpleButton() {
    addMouseListener(new PressL());
    // зададим размеры компонента
    setPreferredSize(new Dimension(100, 100));
  }

  // присоединяет слушателя нажатия кнопки
  public void addButtonPressListener(
      ButtonPressListener l) {
    listenerList.add(l);
  }

  // отсоединяет слушателя нажатия кнопки
  public void removeButtonPressListener(
      ButtonPressListener l) {
    listenerList.remove(l);
  }

  // прорисовывает кнопку
  public void paintComponent(Graphics g) {
    // зальем зеленым цветом
    g.setColor(Color.green);
    g.fillRect(0, 0, getWidth(), getHeight());
    // рамка
    g.setColor(Color.black);
    g.draw3DRect(0, 0, getWidth(), getHeight(), true);
  }

  // оповещает слушателей о событии
  protected void fireButtonPressed() {
    for (ButtonPressListener l :
        listenerList) {
      l.buttonPressed(event);
    }
  }

  // внутренний класс, следит за нажатиями мыши
  class PressL extends MouseAdapter {
    // нажатие мыши в области кнопки
    public void mousePressed(MouseEvent e) {
      // оповестим слушателей
      fireButtonPressed();
    }
  }
}
