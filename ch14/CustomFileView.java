// CustomFileView.java
// Внешний вид файлов в компоненте JFileChooser
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;

public class CustomFileView extends JFrame {
  public CustomFileView() {
    super("CustomFileView");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
    // настраиваем компонент для выбора файлов
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Выберите файл");
    chooser.setFileView(new NewFileView(
        chooser.getFileSystemView()));
    // показываем диалоговое окно
    int res = chooser.showOpenDialog(this);
  }
  // объект, определяющий внешний вид файлов
  class NewFileView extends FileView {
    // значки, применяемые для файлов
    private Icon fileIcon = new ImageIcon("file.gif");
    private Icon folderIcon = new ImageIcon("folder.gif");
    // конструктору необходимо описание файловой системы
    public NewFileView(FileSystemView fileSystem) {
      this.fileSystem = fileSystem;
    }
    private FileSystemView fileSystem;
    // возвращает значок для файла
    public Icon getIcon(java.io.File file) {
      // основные части файловой системы пропускаем
      if ( fileSystem.isRoot(file) ||
          fileSystem.isDrive(file) )
        return null;
      if ( file.isDirectory() )
        return folderIcon;
      else return fileIcon;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomFileView(); } });
  }
}
