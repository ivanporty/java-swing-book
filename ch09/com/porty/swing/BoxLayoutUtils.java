// com/porty/swing/BoxLayoutUtils.java
// Класс для удобной работы с блочным расположением
package com.porty.swing;
import javax.swing.*;
import java.awt.*;

public class BoxLayoutUtils {
	// задает единое выравнивание по оси X для
	// группы компонентов
	public static void setGroupAlignmentX(float alignment, JComponent... cs) {
    for (JComponent c : cs) {
      c.setAlignmentX(alignment);
    }
	}
	// задает единое выравнивание по оси Y для
	// группы компонентов
	public static void setGroupAlignmentY(float alignment, JComponent... cs) {
    for (JComponent c : cs) {
      c.setAlignmentY(alignment);
    }
	}
	// возвращает панель с установленным вертикальным
	// блочным расположением
	public static JPanel createVerticalPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));		
		return p;
	}
	// возвращает панель с установленным горизонтальным
	// блочным расположением
	public static JPanel createHorizontalPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));		
		return p;
	}
  // создает горизонтальную распорку
  // фиксированного размера
  public static Component createHorizontalStrut(int size) {
    return Box.createRigidArea(new Dimension(size, 0));
  }
  // создает вертикальную распорку
  // фиксированного размера
  public static Component createVerticalStrut(int size) {
    return Box.createRigidArea(new Dimension(0, size));
  }
}