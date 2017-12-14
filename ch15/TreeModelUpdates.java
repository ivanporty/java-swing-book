// TreeModelUpdates.java
// ѕример эффективного обновлени€ большого
// дерева с переменными данными
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class TreeModelUpdates extends JFrame {
  // дерево
  private JTree tree;
  // стандартна€ модель дерева
  private DefaultTreeModel model;
  public TreeModelUpdates() {
    super("TreeModelUpdates");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем дерево на основе модели
    tree = new JTree(model = createTreeModel());
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // создание несложной, но большой модели дерева
  private DefaultTreeModel createTreeModel() {
    // корень нашего дерева
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode(
            "Ѕольшоооое ƒерево");
    // присоедин€ем листь€
    for (int i=0; i<100; i++) {
      DefaultMutableTreeNode node = new ChangeableColorNode();
      root.add(node);
      for (int k=0; k<10; k++) {
        node.add(new ChangeableColorNode());
      }
    }
    // создаем стандартную модель
    return new DefaultTreeModel(root);
  }
  // узел дерева, динамически обновл€ющий свое содержимое
  class ChangeableColorNode
      extends DefaultMutableTreeNode implements ActionListener {
    // случайна€ задержка обновлени€
    private int delay = (int) (Math.random()*3000 + 500);
    // цвета текста, хранимого в узле
    private int r,g,b;
    public ChangeableColorNode() {
      // генерируем цвета и запускаем таймер обновлени€
      generateColors();
      new Timer(delay, this).start();
    }
    // этот метод вызываетс€ таймером
    public void actionPerformed(ActionEvent e) {
      // обновл€ем цвета и текст
      generateColors();
      // обновл€ем узел если он развернут
      TreePath path = new TreePath(
          model.getPathToRoot(this));
      if ( tree.isVisible(path) ) {
        model.nodeChanged(this);
      }
    }
    // метод генерирует случайные цвета и обновл€ет текст
    public void generateColors() {
      r = (int) (Math.random()*255);
      g = (int) (Math.random()*255);
      b = (int) (Math.random()*255);
      setUserObject("<html><font color=rgb("
          +r+","+g+","+b+")> акой-то цвет!");
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeModelUpdates(); } });
  }
}
