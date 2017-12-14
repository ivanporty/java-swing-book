// LoginDialog.java
// Этапы создание первоклассного
// пользовательского интерфейса на примере
// диалогового окна входа в систему
import javax.swing.*;
import java.awt.*;
import com.porty.swing.BoxLayoutUtils;
import com.porty.swing.GUITools;

public class LoginDialog extends JDialog {
  public LoginDialog(JFrame parent) {
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
    // 1. Создается панель, которая будет содержать
    // все остальные элементы и панели расположения
    JPanel main =
        BoxLayoutUtils.createVerticalPanel();
    // Чтобы интерфейс отвечал требованиям Java,
    // необходимо отделить его содержимое от
    // границ окна на 12 пикселов.
    // Для этого используем пустую рамку
    main.setBorder(
        BorderFactory.createEmptyBorder(12,12,12,12));
    // 2. Поочередно создаются "полосы", на которые
    // был разбит интерфейс на этапе анализа
    // а) первое текстовое поле и надпись к нему
    JPanel name =
        BoxLayoutUtils.createHorizontalPanel();
    JLabel nameLabel = new JLabel("Имя:");
    name.add(nameLabel);
    name.add(BoxLayoutUtils.createHorizontalStrut(12));
    JTextField nameField = new JTextField(15);
    name.add(nameField);
    // б) второе текстовое поле и надпись к нему
    JPanel password =
        BoxLayoutUtils.createHorizontalPanel();
    JLabel passwrdLabel = new JLabel("Пароль:");
    password.add(passwrdLabel);
    password.add(BoxLayoutUtils.createHorizontalStrut(12));
    JTextField passwrdField = new JTextField(15);
    password.add(passwrdField);
    // в) ряд кнопок
    JPanel flow = new JPanel( new FlowLayout(
        FlowLayout.RIGHT, 0, 0) );
    JPanel grid = new JPanel( new GridLayout(
        1,2,5,0) );
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Отмена");
    grid.add(ok);
    grid.add(cancel);
    flow.add(grid);
    // 3. Проводятся необходимые действия по
    // выравниванию компонентов, уточнению их
    // размеров, приданию одинаковых размеров
    // а) согласованное выравнивание
    // вложенных панелей
    BoxLayoutUtils.setGroupAlignmentX(
        Component.LEFT_ALIGNMENT,
        name, password, main, flow);
    // б) центральное выравнивание надписей
    // и текстовых полей
    BoxLayoutUtils.setGroupAlignmentY(
        Component.CENTER_ALIGNMENT,
        nameField, passwrdField, nameLabel, passwrdLabel);
    // в) одинаковые размеры надписей к текстовым полям
    GUITools.makeSameSize(nameLabel, passwrdLabel);
    // д) устранение "бесконечной" высоты текстовых полей
    GUITools.fixTextFieldSize(nameField);
    GUITools.fixTextFieldSize(passwrdField);
    // 4. Окончательный "сбор" полос в интерфейс
    main.add(name);
    main.add(BoxLayoutUtils.createVerticalStrut(12));
    main.add(password);
    main.add(BoxLayoutUtils.createVerticalStrut(17));
    main.add(flow);
    // готово
    return main;
  }
  // тестовый метод для проверки диалогового окна
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new LoginDialog(new JFrame());
      }
    });
  }
}