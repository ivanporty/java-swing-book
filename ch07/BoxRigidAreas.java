// BoxRigidAreas.java
// Пример использования фиксированных областей
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;
import java.awt.*;

public class BoxRigidAreas extends JFrame {
  public BoxRigidAreas() {
    super("BoxRigidAreas");
    setSize(250, 200);
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // вертикальная панель
    JPanel pVert = BoxLayoutUtils.createVerticalPanel();
    pVert.add(new JButton("Один"));
    // горизонтальная панель
    JPanel pHor = BoxLayoutUtils.createHorizontalPanel();
    pHor.add(new JButton("Два"));
    // размер пространства задается в виде объекта
    // Dimension из пакета java.awt
    pHor.add(Box.createRigidArea(new Dimension(50,120)));
    pHor.add(new JButton("Три"));
    pVert.add(pHor);
    // добавляем вертикальную панель в центр окна
    add(pVert);
    // выводим окно на экран
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new BoxRigidAreas(); } });
  }
}