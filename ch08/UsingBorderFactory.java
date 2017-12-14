// UsingBorderFactory.java
// Фабрика рамок BorderFactory
import javax.swing.*;

public class UsingBorderFactory extends JFrame {
  public UsingBorderFactory() {
    super("UsingBorderFactory");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // рамка для панели содержимого
    JPanel cp = (JPanel)getContentPane();
    cp.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createRaisedBevelBorder(),
        "Сделано на фабрике рамок"));
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingBorderFactory(); } });
  }
}
