// CustomTreeEditor.java
// Создание специализированного редактора узлов
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

public class CustomTreeEditor extends JFrame {
  public CustomTreeEditor() {
    super("CustomTreeEditor");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // настраиваем дерево
    JTree tree = new JTree(createTreeModel());
    // включаем редактирование узлов
    tree.setEditable(true);
    DefaultTreeCellRenderer renderer =
        new DefaultTreeCellRenderer();
    DefaultTreeCellEditor editor =
        new DefaultTreeCellEditor(tree, renderer,
            new MaskTreeEditor(tree));
    tree.setCellEditor(editor);
    // выводим окно на экран
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // список телефонов
  private String[] phoneDirectory = {
      "123-13-13", "444-55-67", "111-23-45"};
  // создает модель дерева
  private TreeModel createTreeModel() {
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("Компания");
    DefaultMutableTreeNode node =
        new DefaultMutableTreeNode("Отдел кадров");
    root.add(node);
    // присоединяем листья
    for (String phone : phoneDirectory) {
      node.add(new DefaultMutableTreeNode(phone));
    }
    return new DefaultTreeModel(root);
  }
  // специальный редактор узлов дерева
  class MaskTreeEditor extends AbstractCellEditor
      implements TreeCellEditor {
    // дерево
    private JTree tree;
    // текстовое поле, применяемое для редактирования
    private JFormattedTextField editor;
    // конструктор редактора
    public MaskTreeEditor(JTree tree) {
      this.tree = tree;
      // создаем форматирующий объект
      try {
        MaskFormatter phone =
            new MaskFormatter("###-##-##");
        editor = new JFormattedTextField(phone);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      // присоединяем к полю слушателя
      editor.addActionListener(new ActionListener() {
        // вызывается при окончании редактирования
        public void actionPerformed(ActionEvent e) {
          stopCellEditing();
        }
      });
    }
    // возвращает компонент, используемый как редактор
    public Component getTreeCellEditorComponent(
        JTree tree, Object value, boolean selected,
        boolean expanded, boolean leaf, int row) {
      // устанавливаем новое значение
      editor.setText(value.toString());
      // возвращаем текстовое поле
      return editor;
    }
    // возращает текущее значение в редакторе
    public Object getCellEditorValue() {
      return editor.getText();
    }
    // определяет, можно ли проводить редактирование
    public boolean isCellEditable(EventObject event) {
      MutableTreeNode node = (MutableTreeNode)
          tree.getLastSelectedPathComponent();
      return ( (node != null) && ( node.isLeaf()) );
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomTreeEditor(); } });
  }
}