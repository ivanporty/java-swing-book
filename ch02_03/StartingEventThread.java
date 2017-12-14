// StartingEventThread.java
// Проверка момента запуска потока рассылки событий

import javax.swing.*;
import java.awt.*;

public class StartingEventThread {
  public static void main(String[] args) {
    // заменяем системную очередь событий своей
    Toolkit.getDefaultToolkit().
        getSystemEventQueue().push(new CustomQueue());
    // создаем окно
    JFrame frame = new JFrame("Тест");
    System.out.println("(1) JFrame()");
    // добавляем флажок
    JCheckBox checkBox = new JCheckBox("Тест");
    frame.add(checkBox, "South");
    System.out.println("(2) Добавлен флажок");
    // создаем список
    DefaultListModel model = new DefaultListModel();
    JList list = new JList(model);
    frame.add(list);
    System.out.println("(3) Добавлен список");
    // обновляем модель
    model.addElement("Тест");
    System.out.println("(4) Обновление модели");
    // окончательно выводим интерфейс на экран
    frame.setVisible(true);
    System.out.println("(5) Интерфейс построен");
  }

  // специальная очередь событий, сообщающая
  // отладочную информацию о событиях и потоках
  static class CustomQueue extends EventQueue {
    // метод кладет событие в очередь
    public void postEvent(AWTEvent event) {
      System.out.println("post(), поток: " +
          Thread.currentThread().toString());
      System.out.println("post(), событие: " + event);
      super.postEvent(event);
    }

    // метод распределяет событие по компонентам
    protected void dispatchEvent(AWTEvent event) {
      System.out.println("dispatch(), поток: " +
          Thread.currentThread().toString());
      System.out.println("dispatch(), событие: " + event);
      super.dispatchEvent(event);
    }
  }
}
