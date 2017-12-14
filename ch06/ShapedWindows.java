// ShapedWindows.java
// ѕолупрозрачные окна произвольных форм
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.geom.RoundRectangle2D;

public class ShapedWindows extends JFrame {
  public ShapedWindows() {
    super("ShapedWindows");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // размер окна
    setSize(300, 200);
    // несколько компонентов в р€д
    setLayout(new FlowLayout());
    add(new JLabel("“екст:"));
    add(new JTextField(15));
    // задаем округлую форму
    RoundRectangle2D.Float roundedShape =
        new RoundRectangle2D.Float(0, 0, 300, 200, 70, 70);
    setShape(roundedShape);
    // задаем прозрачность
    setOpacity(0.7f);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ShapedWindows();
        
      }
    });
  }
}