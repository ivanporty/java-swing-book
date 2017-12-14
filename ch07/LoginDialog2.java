// LoginDialog2.java
// Диалог входа в систему с помощью MigLayout
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class LoginDialog2 extends JDialog {
  public LoginDialog2(JFrame parent) {
    super(parent, "Вход в систему");
    // удаление окна при закрытии
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    // добавляем расположение в центр окна
    add(createGUI());
    // задаем предпочтительный размер
    pack();
    // выводим окно на экран
    setVisible(true);
  }

  // этот метод будет возвращать панель с
  // созданным расположением
  private JPanel createGUI() {
    // 1. Основная панель
    // В конструкторе задаем "рост" второго столбца
    JPanel main = new JPanel(new MigLayout("", "[][grow]"));
    // первый ряд сетки
    main.add(new JLabel("Имя:"));
    main.add(new JTextField(15), "gap rel, wrap rel, growx");
    // второй ряд сетки
    main.add(new JLabel("Пароль:"));
    main.add(new JTextField(15), "gap rel, wrap unrel, growx");
    // третий ряд сетки - кнопки одинакового размера
    // пропускаем первую ячейку, разбиваем вторую на две
    main.add(new JButton("OK"), "skip 1, split, sg buttons, align right");
    main.add(new JButton("Отмена"), "sg buttons");
    // готово
    return main;
  }
  // тестовый метод для проверки диалогового окна
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new LoginDialog2(new JFrame());
      }
    });
  }
}