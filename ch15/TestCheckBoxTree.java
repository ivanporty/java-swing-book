// TestCheckBoxTree.java
// Проверка дерева с поддержкой флажков
import com.porty.swing.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TestCheckBoxTree extends JFrame {
  public TestCheckBoxTree() {
    super("TestCheckBoxTree");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем модель и дерево
    TreeModel model = createTreeModel();
    CheckBoxTree tree = new CheckBoxTree(model);
    // добавляем дерево в окно
    add(new JScrollPane(tree));
    // выводим окно на экран
    setSize(400, 300);
    setVisible(true);
  }
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
    // присоединяем листья с данными для флажков
    for (int i=0; i<langs.length; i++) {
      lang.add(new DefaultMutableTreeNode(
          new CheckBoxListElement(false, langs[i])));
      ide.add(new DefaultMutableTreeNode(
          new CheckBoxListElement(false, ides[i])));
    }
    // создаем стандартную модель
    return new DefaultTreeModel(root);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TestCheckBoxTree(); } });
  }
}