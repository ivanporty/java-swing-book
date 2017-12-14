// TestXMLMenuLoader.java
// Проверка загрузки системы меню из файла XML
import javax.swing.*;
import com.porty.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class TestXMLMenuLoader extends JFrame {
  public TestXMLMenuLoader() {
    super("TestXMLMenuLoader");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // открываем файл XML с описанием меню
    try {
      InputStream stream =
          new FileInputStream("menu.xml");
      // загружаем меню
      XMLMenuLoader loader =
          new XMLMenuLoader(stream);
      loader.parse();
      // устанавливаем строку меню
      setJMenuBar(loader.getMenuBar("mainMenu"));
      // быстрое присоединение слушателя
      loader.addActionListener("exit",
          new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              System.exit(0);
            }
          });
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TestXMLMenuLoader(); } });
  }
}