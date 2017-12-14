// SimpleTreeModel.java
// —оздание простой модели дл€ дерева
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.util.*;
import java.awt.*;

public class SimpleTreeModel extends JFrame {
  public SimpleTreeModel() {
    super("SimpleTreeModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // дерево на основе нашей модели
    JTree tree = new JTree(new SimpleModel());
    // добавл€ем его в окно
    add(new JScrollPane(tree));
    setSize(300, 200);
    setVisible(true);
  }

  // наша модель дл€ дерева
  class SimpleModel implements TreeModel {
    // корень дерева и основные узлы
    private String root = " ое-что интересное";
    private String
        colors = "÷вета",
        food = "≈да";
    // хранилища данных
    private ArrayList<String> rootList = new ArrayList<String>(),
        colorsList = new ArrayList<String>(),
        foodList = new ArrayList<String>();
    public SimpleModel() {
      // заполн€ем списки данными
      rootList.add(colors);
      rootList.add(food);
      colorsList.add(" расный");
      colorsList.add("«еленый");
      foodList.add("ћороженое");
      foodList.add("Ѕутерброд");
    }

    // возвращает корень дерева
    public Object getRoot() {
      return root;
    }

    // сообщает о количестве потомков узла
    public int getChildCount(Object parent) {
      if ( parent == root ) return rootList.size();
      else if ( parent == colors )
        return colorsList.size();
      else if ( parent == food ) return foodList.size();
      return 0;
    }

    // возвращает потомка узла по пор€дковому номеру
    public Object getChild(Object parent, int index) {
      if ( parent == root )
        return rootList.get(index);
      else if ( parent == colors )
        return colorsList.get(index);
      else if ( parent == food )
        return foodList.get(index);
      return null;
    }

    // позвол€ет получить пор€дковый номер потомка
    public int getIndexOfChild(
        Object parent, Object child) {
      if ( parent == root )
        return rootList.indexOf(child);
      else if ( parent == colors )
        return colorsList.indexOf(child);
      else if ( parent == food )
        return foodList.indexOf(child);
      return 0;
    }

    // определ€ет, какие узлы €вл€ютс€ листь€ми
    public boolean isLeaf(Object node) {
      if ( colorsList.contains(node) ||
          foodList.contains(node) ) return true;
      else return false;
    }

    // вызываетс€ при изменении значени€ некоторого узла
    // дл€ нашей модели не понадобитс€
    public void valueForPathChanged(
        TreePath path, Object value) {
    }

    // методы дл€ присоединени€ и удалени€ слушателей
    // нашей простой модели не потребуютс€
    public void addTreeModelListener(
        TreeModelListener tml) {
    }
    public void removeTreeModelListener(
        TreeModelListener tml) {
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTreeModel(); } });
  }
}