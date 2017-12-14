// SpinnerLabelEditor.java
// Редактор счетчика JSpinner на основе надписи
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SpinnerLabelEditor extends JFrame {
  // данные для списка
  private String[] data = {
      "Красный", "Зеленый", "Синий"
  };
  public SpinnerLabelEditor() {
    super("SpinnerLabelEditor");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем счетчик
    JSpinner spinner = new JSpinner(
        new SpinnerListModel(data));
    // присоединяем наш редактор
    LabelEditor editor = new LabelEditor();
    spinner.setEditor(editor);
    // регистрируем слушателя
    spinner.addChangeListener(editor);
    // для появления на экране необходимо
    // чтобы до редактора дошло событие
    spinner.getModel().setValue(data[1]);
    // выводим окно на экран
    setLayout(new FlowLayout());
    add(spinner);
    setSize(300, 200);
    setVisible(true);
  }
  // специальный редактор для счетчика
  class LabelEditor extends JLabel
      implements ChangeListener {
    // метод слушателя событий
    public void stateChanged(ChangeEvent e) {
      // получаем счетчик
      JSpinner spinner = (JSpinner)e.getSource();
      // получаем текущий элемент
      Object value = spinner.getValue();
      // устанавливаем новое значение
      if ( value.equals(data[0]) ) {
        setText("<html><h2><font color=\"red\">"
            + value);
      }
      if ( value.equals(data[1]) ) {
        setText("<html><h3><font color=\"green\">"
            + value);
      }
      if ( value.equals(data[2]) ) {
        setText("<html><h4><font color=\"blue\">"
            + value);
      }
    }
    // размер редактора
    public Dimension getPreferredSize() {
      return new Dimension(100, 30);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SpinnerLabelEditor(); } });
  }
}