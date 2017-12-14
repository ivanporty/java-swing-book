// LayoutStyleTest.java
// Автоматическое определение стиля интерфейса
import javax.swing.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

public class LayoutStyleTest {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // компоненты
            JPanel panel = new JPanel();
            JTextField text = new JTextField();
            JLabel label = new JLabel("Тест");
            // отступ от границы контейнера
            LayoutStyle style = LayoutStyle.getInstance();
            System.out.println("" + style.getContainerGap(
                text, SwingConstants.WEST, panel));
            // расстояние между связанными компонентами
            System.out.println("" + style.getPreferredGap(
                label, text, RELATED, SwingConstants.EAST, panel));
          } });
  }
}