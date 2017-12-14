// UndoListAdd.java
// Отмена операций в списках и UndoManager
import javax.swing.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UndoListAdd extends JFrame {
  // объект для отмены операций
  private UndoManager undoManager = new UndoManager();
  public UndoListAdd() {
    super("ListDrag");
    // выход при закрытии окна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем модель списка
    final DefaultListModel model = new DefaultListModel();
    // создаем списки
    JList list1 = new JList(model);
    JList list2 = new JList(model);
    // добавим списки в окно
    JPanel listPanel = new JPanel(new GridLayout(1, 2));
    listPanel.add(new JScrollPane(list1));
    listPanel.add(new JScrollPane(list2));
    add(listPanel);
    // кнопка добавление элемента
    JButton add = new JButton("Добавить");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String newElement = "Новый!";
        model.addElement(newElement);
        // регистрация новой операции для отмены
        undoManager.addEdit(new
            ListAddUndoableEdit(model, newElement));
      }
    });
    // кнопки отмены и повтора
    final JButton undo = new JButton("Отменить");
    final JButton redo = new JButton("Повторить");
    // обработчик нажатий кнопок
    ActionListener al = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // отмена и повтор при возможности
        if ( e.getSource() == undo
            && undoManager.canUndo() ) {
          undoManager.undo();
        } else if ( undoManager.canRedo() ) {
          undoManager.redo();
        }
      }
    };
    undo.addActionListener(al);
    redo.addActionListener(al);
    // добавим кнопки на юг окна
    JPanel buttons = new JPanel();
    buttons.add(add);
    buttons.add(undo);
    buttons.add(redo);
    add(buttons, "South");
    // выведем окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  // класс, описывающий добавление в список
  class ListAddUndoableEdit extends AbstractUndoableEdit {
    // модель и новый элемент
    private DefaultListModel model;
    private Object element;
    public ListAddUndoableEdit(DefaultListModel model, Object element) {
      this.model = model;
      this.element = element;
    }
    @Override
    public void undo() throws CannotUndoException {
      super.undo();
      model.removeElement(element);
    }
    @Override
    public void redo() throws CannotRedoException {
      super.redo();
      model.addElement(element);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UndoListAdd(); } });
  }
}