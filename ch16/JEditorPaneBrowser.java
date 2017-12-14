// JEditorPaneBrowser.java
// Простой браузер на основе редактора JEditorPane
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JEditorPaneBrowser extends JFrame {
  // наш редактор
  private JEditorPane editor;
  // текстовое поле с адресом
  private JTextField address;
  public JEditorPaneBrowser() {
    super("JEditorPaneBrowser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // создаем пользовательский интерфейс
    createGUI();
    // выводим окно на экран
    setSize(500, 400);
    setVisible(true);
  }
  // настройка пользовательского интерфейса
  private void createGUI() {
    // панель с адресной строкой
    JPanel addressPanel = new JPanel();
    addressPanel.setLayout(
        new FlowLayout(FlowLayout.LEFT));
    addressPanel.setBorder(BorderFactory.
        createEmptyBorder(5, 5, 5, 5));
    // поле для адреса
    address = new JTextField(30);
    // слушатель окончания ввода
    address.addActionListener(new NewAddressAction());
    addressPanel.add(new JLabel("Адрес:"));
    addressPanel.add(address);
    // настраиваем редактор
    try {
      // пути к ресурсам нужно записывать
      // полностью, вместе с протоколами
      editor = new JEditorPane("http://java.sun.com");
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(
          this, "Адрес недоступен");
    }
    editor.setContentType("text/html");
    editor.setEditable(false);
    // поддержка ссылок
    editor.addHyperlinkListener(new HyperlinkL());
    // добавляем все в окно
    add(addressPanel, "North");
    add(new JScrollPane(editor));
  }
  // слушатель, получающий уведомления о вводе нового адреса
  class NewAddressAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // переходим по адресу
      String newAddress = address.getText();
      try {
        editor.setPage(newAddress);
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(
            JEditorPaneBrowser.this,"Адрес недоступен");
      }
    }
  }
  // слушатель, обеспечивающий поддержку ссылок
  class HyperlinkL implements HyperlinkListener {
    public void hyperlinkUpdate(HyperlinkEvent he) {
      // нужный ли это тип события
      if ( he.getEventType() ==
          HyperlinkEvent.EventType.ACTIVATED ) {
        // переходим по адресу
        try {
          editor.setPage(he.getURL());
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(
              JEditorPaneBrowser.this,"Адрес недоступен");
        }
      }
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new JEditorPaneBrowser(); } });
  }
}