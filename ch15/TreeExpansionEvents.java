// TreeExpansionEvents.java
// События при развертывании узлов дерева
import javax.swing.*;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.ExpandVetoException;
import java.awt.*;

public class TreeExpansionEvents extends JFrame {
  public TreeExpansionEvents() {
    super("TreeExpansionEvents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем дерево на основе модели
    JTree tree = new JTree(createTreeModel());
    // добавляем слушателей
    TreeListener listener = new TreeListener();
    tree.addTreeExpansionListener(listener);
    tree.addTreeWillExpandListener(listener);
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // листья дерева храним в массивах
  private String[] langs = {
      "<html><b>Java", "<html><pre>Scala", "Ruby" };
  private String[] ides = {
      "IDEA", "<html><i>Eclipse", "NetBeans" };
  // создание несложной модели дерева
  private TreeModel createTreeModel() {
    // корень нашего дерева
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode(
            "<html><font color=blue>Создание кода");
    // основные ветви
    DefaultMutableTreeNode lang =
        new DefaultMutableTreeNode("Языки");
    DefaultMutableTreeNode ide =
        new DefaultMutableTreeNode("Среды");
    root.add(lang);
    root.add(ide);
    // присоединяем листья
    for (int i=0; i<langs.length; i++) {
      lang.add(new DefaultMutableTreeNode(langs[i]));
      ide.add(new DefaultMutableTreeNode(ides[i]));
    }
    // создаем стандартную модель
    return new DefaultTreeModel(root);
  }
  // слушатель событий о развертывании узлов
  class TreeListener implements TreeExpansionListener,
      TreeWillExpandListener {
    public void treeExpanded(TreeExpansionEvent event) {
      System.out.println("Узел развернут: " + event.getPath());
    }
    public void treeCollapsed(TreeExpansionEvent event) {
      System.out.println("Узел свернут: " + event.getPath());
    }
    public void treeWillExpand(TreeExpansionEvent event)
        throws ExpandVetoException { }
    public void treeWillCollapse(TreeExpansionEvent event)
        throws ExpandVetoException {
      if ( event.getPath().getLastPathComponent().
          toString().equals("Языки") )
        throw new ExpandVetoException(event);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeExpansionEvents(); } });
  }
}