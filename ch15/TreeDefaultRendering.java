// TreeDefaultRendering.java
// »спользование возможностей стандартного
// отображащего объекта DefaultTreeCellRenderer
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeDefaultRendering extends JFrame {
  public TreeDefaultRendering() {
    super("TreeDefaultRendering");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем дерево на основе незатейливой модели
    JTree tree = new JTree(createTreeModel());
    // создадем и настраиваем отображающий объект
    DefaultTreeCellRenderer renderer =
        new DefaultTreeCellRenderer();
    renderer.setLeafIcon(new ImageIcon("Leaf.gif"));
    renderer.setClosedIcon(
        new ImageIcon("NodeClosed.gif"));
    renderer.setOpenIcon(
        new ImageIcon("NodeOpened.gif"));
    // передаем его дереву
    tree.setCellRenderer(renderer);
    // добавл€ем дерево и выводим окно на экран
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // листь€ дерева храним в массивах
  private String[] langs = {
      "<html><b>Java", "<html><pre>Scala", "Ruby" };
  private String[] ides = {
      "IDEA", "<html><i>Eclipse", "NetBeans" };
  // создание несложной модели дерева
  private TreeModel createTreeModel() {
    // корень нашего дерева
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode(
            "<html><font color=blue>—оздание кода");
    // основные ветви
    DefaultMutableTreeNode lang =
        new DefaultMutableTreeNode("языки");
    DefaultMutableTreeNode ide =
        new DefaultMutableTreeNode("—реды");
    root.add(lang);
    root.add(ide);
    // присоедин€ем листь€
    for (int i=0; i<langs.length; i++) {
      lang.add(new DefaultMutableTreeNode(langs[i]));
      ide.add(new DefaultMutableTreeNode(ides[i]));
    }
    // создаем стандартную модель
    return new DefaultTreeModel(root);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeDefaultRendering(); } });
  }
}