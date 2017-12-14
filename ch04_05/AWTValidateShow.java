// Базовая валидация AWT - при изменении размеров
//  или других параметров остается вызвать validate()
import java.awt.*;

public class AWTValidateShow extends Frame {
  private static Button button;

  public AWTValidateShow() {
    setSize(400, 300);
    Panel contents = new Panel();
    button = new Button("Текст");
    Button button2 = new Button("Текст 2");
    contents.add(button);
    contents.add(button2);
    add(contents);
  }

  public static void main(String[] args)
      throws InterruptedException {
    new AWTValidateShow().setVisible(true);
    Thread.sleep(2000);
    button.setLabel("Очень длинный текст");
    // С этого момента размер поменялся - вызван invalidate()
    // можно вызывать validate() в контейнере
    Thread.sleep(2000);
    // будет заново расположен весь контейнер
    // и все его содержимое (кнопка)
    button.getParent().validate();
  }
}