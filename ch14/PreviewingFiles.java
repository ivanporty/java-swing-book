// PreviewingFiles.java
// Предварительный просмотр файлов
// в компоненте JFileChooser
import javax.swing.*;
import javax.swing.filechooser.*;
import java.beans.*;
import java.awt.*;

public class PreviewingFiles extends JFrame {
  public PreviewingFiles() {
    super("PreviewingFiles");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
    // настраиваем компонент для выбора файла
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Выберите изображение");
    // присоединяем фильтр
    chooser.setFileFilter(new ImageFilesFilter());
    // убираем универсальный фильтр
    chooser.setAcceptAllFileFilterUsed(false);
    // присоединяем дополнительный компонент
    Previewer previewer = new Previewer();
    chooser.setAccessory(previewer);
    // регистрируем в качестве слушателя
    chooser.addPropertyChangeListener(previewer);
    // выводим диалоговое окно на экран
    int res = chooser.showOpenDialog(this);
    if ( res == JFileChooser.APPROVE_OPTION )
      JOptionPane.showMessageDialog(
          this, chooser.getSelectedFile());
  }
  // компонент для предварительного просмотра
  class Previewer extends JPanel
      implements PropertyChangeListener {
    private JLabel label;
    public Previewer() {
      // настраиваем контейнер
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(200, 200));
      // создаем надпись в панели прокрутки
      label = new JLabel();
      JScrollPane scroller = new JScrollPane(label);
      add(scroller);
    }
    public void propertyChange(PropertyChangeEvent e) {
      if ( e.getPropertyName().equals(
          JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
        // сменился выбранный файл, покажем его
        if ( e.getNewValue() != null )
          label.setIcon(new ImageIcon(
              e.getNewValue().toString()));
      }
    }
  }
  // фильтр, отбирающий файлы с изображениями
  class ImageFilesFilter extends FileFilter {
    // принимает файл или отказывает ему
    public boolean accept(java.io.File file) {
      // все каталоги принимаем
      if ( file.isDirectory() ) return true;
      // имя файла не будет учитывать регистр
      String name = file.getName().toLowerCase();
      // для файлов смотрим на расширение
      return ( name.endsWith(".jpg") ||
          name.endsWith(".gif") || name.endsWith(".png") );
    }
    // возвращает описание фильтра
    public String getDescription() {
      return "Изображения (*.jpg, *.gif, *.png)";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new PreviewingFiles(); } });
  }
}
