// Валидация Swing - большинство компонентов
// позаботятся о себе сами. В остальном метод revalidate()
// позволяет не задумываться о деталях
import javax.swing.*;

public class SwingValidateShow extends JFrame {
  private static JButton button, newButton;

  public SwingValidateShow() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(400, 300);
    JPanel contents = new JPanel();
    button = new JButton("Текст");
    JButton button2 = new JButton("Текст 2");
    contents.add(button);
    contents.add(button2);
    add(contents);
  }

  public static void main(String[] args)
      throws InterruptedException {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SwingValidateShow().setVisible(true);
      }
    });
    Thread.sleep(2000);
    // Кнопка при смене параметра сама вызовет
    // revalidate() и мы сразу же увидим изменения
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        button.setText("Очень длинный текст");
      }
    });
    // при добавлении в контейнер revalidate()
    // автоматически не вызывается
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        newButton = new JButton("Новичок");
        button.getParent().add(newButton);
      }
    });
    Thread.sleep(2000);
    // revalidate() может быть вызван из любого потока
    newButton.revalidate();
  }
}