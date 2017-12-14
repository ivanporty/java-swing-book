// RedBullet.java
// Создание собственного значка
import javax.swing.*;
import java.awt.*;

public class RedBullet implements Icon {
  public int getIconWidth() {
    return 16;
  }
  public int getIconHeight() {
    return 16;
  }
  public void paintIcon(
      Component c, Graphics g, int w, int h) {
    g.setColor(Color.red);
    g.fillRect(0, 0, 16, 16);
  }
}
