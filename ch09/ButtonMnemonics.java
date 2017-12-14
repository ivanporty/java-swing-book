// ButtonMnemonics.java
// Поддержка кнопками клавиатурных мнемоник
import javax.swing.*;
import java.awt.*;

public class ButtonMnemonics extends JFrame {
  public ButtonMnemonics() {
    super("ButtonMnemonics");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // используем последовательное расположение
    setLayout(new FlowLayout());
    // создаем кнопку
    JButton button = new JButton("Нажмите меня!");
    // мнемоника (русский символ)
    button.setMnemonic('Н');
    add(button);
    // еще одна кнопка, только надпись на английском
    button = new JButton("All Right!");
    button.setMnemonic('L');
    button.setToolTipText("Жмите смело");
    button.setDisplayedMnemonicIndex(2);
    add(button);
    // выводим окно на экран
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonMnemonics(); } });
  }
}
