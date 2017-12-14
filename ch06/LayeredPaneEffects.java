// LayeredPaneEffects.java
// Создание эффектов для интерфейса 
// с помощью многослойной панели
import javax.swing.*;
import java.awt.*;

public class LayeredPaneEffects extends JFrame {
  public LayeredPaneEffects() {
    super("LayeredPaneEffects");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // несколько обычных кнопок и текстовое поле
    JPanel buttons = new JPanel();
    buttons.add(new JButton("Применить"));
    buttons.add(new JButton("Записать"));
    buttons.add(new JTextField(20));
    // добавляем в панель содержимого
    getContentPane().add(buttons);
    // добавляем компонент с анимацией в слой PALETTE
    Animation an = new Animation();
    an.setBounds(50, 10, anim.getWidth(this),
        anim.getHeight(this));
    getLayeredPane().add(an, JLayeredPane.PALETTE_LAYER);
    // выводим окно на экран
    setSize(250, 100);
    setVisible(true);
  }
  // изображение
  private Image anim =
      new ImageIcon("anim.gif").getImage();
  // компонент, рисующий анимированное изображение
  class Animation extends JComponent {
    public Animation() {
      setOpaque(false);
    }
    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      // полупрозрачность
      g2.setComposite(AlphaComposite.getInstance(
          AlphaComposite.SRC_OVER, 0.3f));
      // рисуем изображение
      g2.drawImage(anim, 0, 0, this);
    }
    // мы никогда не получаем событий от мыши
    public boolean contains(int x, int y) {
      return false;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new LayeredPaneEffects(); } });
  }
}
