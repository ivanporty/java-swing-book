// LowLevelEvents.java
// Наблюдение за основными низкоуровневыми событиями 

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LowLevelEvents extends JFrame {
  // сюда мы будем выводить информацию
  private JTextArea out;

  public LowLevelEvents() {
    super("LowLevelEvents");
    // при закрытии окна - выход
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавим текстовое поле
    add(new JScrollPane(out = new JTextArea()));
    // и кнопку
    JButton button = new JButton("Источник событий");
    add(button, "South");
    // регистрируем нащего слушателя
    OurListener ol = new OurListener();
    button.addKeyListener(ol);
    button.addMouseListener(ol);
    button.addMouseMotionListener(ol);
    button.addMouseWheelListener(ol);
    button.addFocusListener(ol);
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }

  // внутренний класс - слушатель событий
  class OurListener implements MouseListener, KeyListener,
      MouseMotionListener, MouseWheelListener,
      FocusListener {

    public void mouseClicked(MouseEvent e) {
      out.append(e.toString() + "\n");
    }

    public void mousePressed(MouseEvent e) {
      out.append(e.toString() + "\n");
    }

    public void mouseReleased(MouseEvent e) {
      out.append(e.toString() + "\n");
    }

    public void mouseEntered(MouseEvent e) {
      out.append(e.toString() + "\n");
    }

    public void mouseExited(MouseEvent e) {
      out.append(e.toString() + "\n");
    }

    public void keyTyped(KeyEvent e) {
      out.append(e.toString() + "\n");
    }

    public void keyPressed(KeyEvent e) {
      out.append(e.toString() + "\n");
    }

    public void keyReleased(KeyEvent e) {
      out.append(e.toString() + "\n");
    }

    public void mouseDragged(MouseEvent e) {
      out.append(e.toString() + "\n");
    }

    public void mouseMoved(MouseEvent e) {
      out.append(e.toString() + "\n");
    }

    public void focusGained(FocusEvent e) {
      out.append(e.toString() + "\n");
    }

    public void focusLost(FocusEvent e) {
      out.append(e.toString() + "\n");
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
      out.append(e.toString() + "\n");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new LowLevelEvents();
          }
        });
  }
}
