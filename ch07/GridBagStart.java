// GridBagStart.java
// ѕервые опыты с расположением GridBagLayout
import java.awt.*;
import javax.swing.*;

public class GridBagStart extends JFrame {
  public GridBagStart() {
    super("GridBagStart");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // устанавливаем расположение компонентов
    setLayout(new GridBagLayout());
    // добавл€ем две кнопки, €чейки по умолчанию
    add(new JButton("ѕривет"));
    add(new JButton("ќтмена"));
    // настройка €чейки дл€ текстового пол€
    GridBagConstraints textFieldConstraints =
        new GridBagConstraints();
    // заполнение €чейки по горизонтали
    textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
    // просим зан€ть все оставшиес€ €чейки
    textFieldConstraints.gridwidth =
        GridBagConstraints.REMAINDER;
    textFieldConstraints.weightx = 1.0f;
    add(new JTextField(10), textFieldConstraints);
    // выведем окно на экран
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new GridBagStart(); } });
  }
}