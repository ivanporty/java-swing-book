// CheckBoxListTest.java
// Проверка работы списка с флажками
import javax.swing.*;
import com.porty.swing.*;
import java.awt.*;

public class CheckBoxListTest {
  // данные списка
  private static Object[] data = {
      new CheckBoxListElement(false, "Корпус"),
      new CheckBoxListElement(false,
          "<html><h3><font color=red>Колонки"),
      new CheckBoxListElement(false, "Набор шлейфов"),
      new CheckBoxListElement(true, "Системная плата")
  };
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // создаем список и настраиваем его
            JList list = new CheckBoxList(data);
            // добавляем в окно
            JFrame frame = new JFrame("CheckBoxListTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
