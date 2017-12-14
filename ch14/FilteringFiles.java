// FilteringFiles.java
// Фильтры файлов в компоненте JFileChooser
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;

public class FilteringFiles extends JFrame {
  public FilteringFiles() {
    super("FilteringFiles");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
    // настраиваем компонент для выбора файла
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Выберите текстовый файл");
    // присоединяем фильтр
    chooser.addChoosableFileFilter(
        new TextFilesFilter());
    chooser.setFileFilter(
        new TextFilesFilter());
    // выводим диалоговое окно на экран
    int res = chooser.showOpenDialog(this);
    if ( res == JFileChooser.APPROVE_OPTION )
      JOptionPane.showMessageDialog(
          this, chooser.getSelectedFile());
  }
  // фильтр, отбирающий текстовые файлы
  class TextFilesFilter extends FileFilter {
    // принимает файл или отказывает ему
    public boolean accept(java.io.File file) {
      // все каталоги принимаем
      if ( file.isDirectory() ) return true;
      // для файлов смотрим на расширение
      return ( file.getName().endsWith(".txt") );
    }
    // возвращает описание фильтра
    public String getDescription() {
      return "Текстовые файлы (*.txt)";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FilteringFiles(); } });
  }
}
