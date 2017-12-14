// SimpleFileChooser.java
// Создание простых диалоговых окон 
// открытия и сохранения файлов
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleFileChooser extends JFrame {
  // создадим общий экземпляр JFileChooser
  private JFileChooser fc = new JFileChooser();
  public SimpleFileChooser() {
    super("SimpleFileChooser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // кнопка, создающая диалоговое окно для открытия файла
    JButton open = new JButton("Открыть...");
    open.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Выберите каталог");
        // настроим для выбора каталога
        fc.setFileSelectionMode(
            JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showOpenDialog(
            SimpleFileChooser.this);
        // если файл выбран, покажем его
        if ( res == JFileChooser.APPROVE_OPTION )
          JOptionPane.showMessageDialog(
              SimpleFileChooser.this,
              fc.getSelectedFile());
      }
    });
    // кнопка, создающая диалоговое окно
    // для сохранения файла
    JButton save = new JButton("Сохранить...");
    save.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Сохранение файла");
        // настройка режима
        fc.setFileSelectionMode(
            JFileChooser.FILES_ONLY);
        int res = fc.showSaveDialog(
            SimpleFileChooser.this);
        // сообщим об успехе
        if ( res == JFileChooser.APPROVE_OPTION )
          JOptionPane.showMessageDialog(
              SimpleFileChooser.this,
              "Файл сохранен");
      }
    });
    // добавим кнопки и выведем окно на экран
    setLayout(new FlowLayout());
    add(open);
    add(save);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleFileChooser(); } });
  }
}
