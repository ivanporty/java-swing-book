// UndoAndRedo.java
// Поддержка отмены и повтора операций
// в текстовых компонентах Swing
import javax.swing.*;
import javax.swing.undo.*;
import java.awt.event.*;
import java.awt.*;

public class UndoAndRedo extends JFrame {
  // поддержка отмены/повтора операций
  private UndoManager undoManager = new UndoManager();
  public UndoAndRedo() {
    super("UndoAndRedo");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // панель инструментов
    JToolBar toolBar = new JToolBar();
    toolBar.add(new UndoAction());
    toolBar.add(new RedoAction());
    // текстовое поле
    JTextArea textArea = new JTextArea();
    // добавляем слушателя операций
    textArea.getDocument().
        addUndoableEditListener(undoManager);
    // добавляем компоненты в окно
    add(toolBar, "North");
    add(new JScrollPane(textArea));
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
  // команда - отмена операции
  class UndoAction extends AbstractAction {
    public UndoAction() {
      // настройка команды
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("undo16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      if ( undoManager.canUndo() )
        undoManager.undo();
    }
  }
  // команда - повтор операции
  class RedoAction extends AbstractAction {
    public RedoAction() {
      // настройка команды
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("redo16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      if ( undoManager.canRedo() )
        undoManager.redo();
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UndoAndRedo(); } });
  }
}