// UndoListAdd.java
// РћС‚РјРµРЅР° РѕРїРµСЂР°С†РёР№ РІ СЃРїРёСЃРєР°С… Рё UndoManager
import javax.swing.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UndoListAdd extends JFrame {
  // РѕР±СЉРµРєС‚ РґР»СЏ РѕС‚РјРµРЅС‹ РѕРїРµСЂР°С†РёР№
  private UndoManager undoManager = new UndoManager();
  public UndoListAdd() {
    super("ListDrag");
    // РІС‹С…РѕРґ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР°
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // СЃРѕР·РґР°РµРј РјРѕРґРµР»СЊ СЃРїРёСЃРєР°
    final DefaultListModel model = new DefaultListModel();
    // СЃРѕР·РґР°РµРј СЃРїРёСЃРєРё
    JList list1 = new JList(model);
    JList list2 = new JList(model);
    // РґРѕР±Р°РІРёРј СЃРїРёСЃРєРё РІ РѕРєРЅРѕ
    JPanel listPanel = new JPanel(new GridLayout(1, 2));
    listPanel.add(new JScrollPane(list1));
    listPanel.add(new JScrollPane(list2));
    add(listPanel);
    // РєРЅРѕРїРєР° РґРѕР±Р°РІР»РµРЅРёРµ СЌР»РµРјРµРЅС‚Р°
    JButton add = new JButton("Р”РѕР±Р°РІРёС‚СЊ");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String newElement = "РќРѕРІС‹Р№!";
        model.addElement(newElement);
        // СЂРµРіРёСЃС‚СЂР°С†РёСЏ РЅРѕРІРѕР№ РѕРїРµСЂР°С†РёРё РґР»СЏ РѕС‚РјРµРЅС‹
        undoManager.addEdit(new
            ListAddUndoableEdit(model, newElement));
      }
    });
    // РєРЅРѕРїРєРё РѕС‚РјРµРЅС‹ Рё РїРѕРІС‚РѕСЂР°
    final JButton undo = new JButton("РћС‚РјРµРЅРёС‚СЊ");
    final JButton redo = new JButton("РџРѕРІС‚РѕСЂРёС‚СЊ");
    // РѕР±СЂР°Р±РѕС‚С‡РёРє РЅР°Р¶Р°С‚РёР№ РєРЅРѕРїРѕРє
    ActionListener al = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // РѕС‚РјРµРЅР° Рё РїРѕРІС‚РѕСЂ РїСЂРё РІРѕР·РјРѕР¶РЅРѕСЃС‚Рё
        if ( e.getSource() == undo
            && undoManager.canUndo() ) {
          undoManager.undo();
        } else if ( undoManager.canRedo() ) {
          undoManager.redo();
        }
      }
    };
    undo.addActionListener(al);
    redo.addActionListener(al);
    // РґРѕР±Р°РІРёРј РєРЅРѕРїРєРё РЅР° СЋРі РѕРєРЅР°
    JPanel buttons = new JPanel();
    buttons.add(add);
    buttons.add(undo);
    buttons.add(redo);
    add(buttons, "South");
    // РІС‹РІРµРґРµРј РѕРєРЅРѕ РЅР° СЌРєСЂР°РЅ
    setSize(400, 300);
    setVisible(true);
  }
  // РєР»Р°СЃСЃ, РѕРїРёСЃС‹РІР°СЋС‰РёР№ РґРѕР±Р°РІР»РµРЅРёРµ РІ СЃРїРёСЃРѕРє
  class ListAddUndoableEdit extends AbstractUndoableEdit {
    // РјРѕРґРµР»СЊ Рё РЅРѕРІС‹Р№ СЌР»РµРјРµРЅС‚
    private DefaultListModel model;
    private Object element;
    public ListAddUndoableEdit(DefaultListModel model, Object element) {
      this.model = model;
      this.element = element;
    }
    @Override
    public void undo() throws CannotUndoException {
      super.undo();
      model.removeElement(element);
    }
    @Override
    public void redo() throws CannotRedoException {
      super.redo();
      model.addElement(element);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UndoListAdd(); } });
  }
}