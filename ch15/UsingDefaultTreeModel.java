// UsingDefaultTreeModel.java
// »спользование стандартной модели дерева и 
// узлов DefaultMutableTreeNode
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class UsingDefaultTreeModel extends JFrame {
  // дл€ удобства листь€ будем хранить в массивах
  private String[] drinks =  { " октейль", "—ок", "ћорс" };
  private String[] fruits =  { "яблоки", "јпельсины" };
  public UsingDefaultTreeModel() {
    super("UsingDefaultTreeModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем нашу древовидную структуру
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode(" орень дерева");
    // основные ветви
    DefaultMutableTreeNode drink =
        new DefaultMutableTreeNode("Ќапитки");
    DefaultMutableTreeNode fruit =
        new DefaultMutableTreeNode("‘рукты");
    // добавл€ем ветви
    root.add(drink);
    root.add(fruit);
    // специальный конструктор
    root.add(new DefaultMutableTreeNode("ƒесерт", true));
    // добавл€ем листь€
    for (String _drink : drinks) {
      drink.add(
          new DefaultMutableTreeNode(_drink, false));
    }
    for (String _fruit : fruits) {
      fruit.add(
          new DefaultMutableTreeNode(_fruit, false));
    }
    // создаем стандартную модель и дерево
    DefaultTreeModel dtm1 =
        new DefaultTreeModel(root, true);
    JTree tree1 = new JTree(dtm1);
    // модель можно создать, начина€ с любого узла
    DefaultTreeModel dtm2 = new DefaultTreeModel(drink);
    JTree tree2 = new JTree(dtm2);
    // добавл€ем деревь€ в окно и показываем его
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(tree1));
    add(new JScrollPane(tree2));
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingDefaultTreeModel(); } });
  }
}