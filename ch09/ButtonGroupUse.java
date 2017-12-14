// ButtonGroupUse.java
// Класс ButtonGroup помогает обеспечить
// эксклюзивный выбор
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;
import java.awt.*;

public class ButtonGroupUse extends JFrame {
  public ButtonGroupUse() {
    super("ButtonGroupUse");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // создадим горизонтальную панель
    // с блочным расположением
    JPanel bh = BoxLayoutUtils.createHorizontalPanel();
    // надпись и отступ
    bh.add(new JLabel("Что Вы предпочитаете:"));
    bh.add(Box.createHorizontalStrut(12));
    // несколько выключателей JToggleButton
    JToggleButton b1 = new JToggleButton("Чай", true);
    JToggleButton b2 = new JToggleButton("Кофе");
    JToggleButton b3 = new JToggleButton("Лимонад");
    // добавим все кнопки в группу ButtonGroup
    ButtonGroup bg = new ButtonGroup();
    bg.add(b1);
    bg.add(b2);
    bg.add(b3);
    // добавим все кнопки в контейнер, учтем при
    // этом рекомендации интерфейса "Metal"
    bh.add(b1);
    bh.add(Box.createHorizontalStrut(2));
    bh.add(b2);
    bh.add(Box.createHorizontalStrut(2));
    bh.add(b3);
    getContentPane().add(bh);
    // выводим окно на экран
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonGroupUse(); } });
  }
}