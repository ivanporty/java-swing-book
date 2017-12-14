// TreeDefaultEditing.java
// Стандартные редакторы для деревьев
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeDefaultEditing extends JFrame {
  // листья дерева храним в массивах
  private String[] basics = {
      "Красный", "Зеленый", "Синий" };
  private String[] extendeds = {
      "Желтый", "Голубой", "Розовый" };
  public TreeDefaultEditing() {
    super("TreeDefaultEditing");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем дерево на основе простой модели
    JTree tree = new JTree(createTreeModel());
    // включаем редактирование
    tree.setEditable(true);
    // "настоящий" редактор
    JComboBox combo = new JComboBox(
        new String[] {"Красный", "Зеленый"});
    DefaultCellEditor editor = new DefaultCellEditor(combo);
    // специальный редактор для дерева
    DefaultTreeCellRenderer renderer =
        new DefaultTreeCellRenderer();
    DefaultTreeCellEditor treeEditor =
        new DefaultTreeCellEditor(tree, renderer, editor);
    // присоединяем редактор к дереву
    tree.setCellEditor(treeEditor);
    // выводим окно на экран
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // создание несложной модели дерева
  private TreeModel createTreeModel() {
    // корень нашего дерева
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("Цвета");
    // основные ветви
    DefaultMutableTreeNode basic =
        new DefaultMutableTreeNode("Основные");
    DefaultMutableTreeNode extended =
        new DefaultMutableTreeNode("Дополнительные");
    root.add(basic);
    root.add(extended);
    // присоединяем листья
    for (int i=0; i<basics.length; i++) {
      basic.add(new DefaultMutableTreeNode(basics[i]));
      extended.add(
          new DefaultMutableTreeNode(extendeds[i]));
    }
    // создаем стандартную модель
    return new DefaultTreeModel(root);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeDefaultEditing(); } });
  }
}
