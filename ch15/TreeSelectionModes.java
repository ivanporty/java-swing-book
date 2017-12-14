// TreeSelectionModes.java
// Использование стандартной модели выделения и
// всех поддерживаемых ею режимов
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeSelectionModes extends JFrame {
  public TreeSelectionModes() {
    super("TreeSelectionModes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создадим модель нашего дерева
    TreeModel model = createTreeModel();
    // дерево с одиночным режимом выделения
    JTree tree1 = new JTree(model);
    tree1.getSelectionModel().setSelectionMode(
        TreeSelectionModel.SINGLE_TREE_SELECTION);
    // дерево с выделением непрерывными интервалами
    JTree tree2 = new JTree(model);
    tree2.getSelectionModel().setSelectionMode(
        TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
    // модель выделения можно хранить и отдельно
    TreeSelectionModel selModel =
        new DefaultTreeSelectionModel();
    selModel.setSelectionMode(
        TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    JTree tree3 = new JTree(model);
    tree3.setSelectionModel(selModel);
    // будем следить за выделением в последнем дереве
    tree3.addTreeSelectionListener(new SelectionL());
    // размещаем деревья в панели
    JPanel contents = new JPanel(new GridLayout(1, 3));
    contents.add(new JScrollPane(tree1));
    contents.add(new JScrollPane(tree2));
    contents.add(new JScrollPane(tree3));
    add(contents);
    // добавляем текстовое поле
    add(new JScrollPane(log), "South");
    // выводим окно на экран
    setSize(500, 300);
    setVisible(true);
  }
  // текстовое поле для информации
  private JTextArea log = new JTextArea(5, 20);
  // листья дерева храним в массивах
  private String[] langs = { "Java", "Scala", "Ruby" };
  private String[] ides =
      { "IDEA", "Eclipse", "NetBeans" };
  // создание несложной модели дерева
  private TreeModel createTreeModel() {
    // корень нашего дерева
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("Создание кода");
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
  // этот слушатель следит за изменением выделения
  class SelectionL implements TreeSelectionListener {
    public void valueChanged(TreeSelectionEvent e)  {
      // получаем источник события - дерево
      JTree tree = (JTree)e.getSource();
      // добавленные/удаленные пути
      TreePath[] paths = e.getPaths();
      log.append("Изменено путей: " +
          paths.length + "\n");
      // выделенные элементы и их номера строк
      TreePath[] selected = tree.getSelectionPaths();
      int[] rows = tree.getSelectionRows();
      // последние элементы в пути
      for (int i=0; i<selected.length; i++) {
        log.append("Выделен: " +
            selected[i].getLastPathComponent() +
            " на строке: " + rows[i] +  "\n");
      }
      // полная информация о пути в дереве
      if ( selected.length > 0 ) {
        TreePath path = selected[0];
        Object[] nodes = path.getPath();
        for (int i=0; i<nodes.length; i++) {
          // путь состоит из узлов
          DefaultMutableTreeNode node =
              (DefaultMutableTreeNode)nodes[i];
          log.append("Отрезок пути " + i + " : " +
              node.getUserObject() + " ");
        }
      }
      log.append("\n");
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeSelectionModes(); } });
  }
}