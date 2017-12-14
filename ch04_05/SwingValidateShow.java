// Р’Р°Р»РёРґР°С†РёСЏ Swing - Р±РѕР»СЊС€РёРЅСЃС‚РІРѕ РєРѕРјРїРѕРЅРµРЅС‚РѕРІ
// РїРѕР·Р°Р±РѕС‚СЏС‚СЃСЏ Рѕ СЃРµР±Рµ СЃР°РјРё. Р’ РѕСЃС‚Р°Р»СЊРЅРѕРј РјРµС‚РѕРґ revalidate()
// РїРѕР·РІРѕР»СЏРµС‚ РЅРµ Р·Р°РґСѓРјС‹РІР°С‚СЊСЃСЏ Рѕ РґРµС‚Р°Р»СЏС…
import javax.swing.*;

public class SwingValidateShow extends JFrame {
  private static JButton button, newButton;

  public SwingValidateShow() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(400, 300);
    JPanel contents = new JPanel();
    button = new JButton("РўРµРєСЃС‚");
    JButton button2 = new JButton("РўРµРєСЃС‚ 2");
    contents.add(button);
    contents.add(button2);
    add(contents);
  }

  public static void main(String[] args)
      throws InterruptedException {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SwingValidateShow().setVisible(true);
      }
    });
    Thread.sleep(2000);
    // РљРЅРѕРїРєР° РїСЂРё СЃРјРµРЅРµ РїР°СЂР°РјРµС‚СЂР° СЃР°РјР° РІС‹Р·РѕРІРµС‚
    // revalidate() Рё РјС‹ СЃСЂР°Р·Сѓ Р¶Рµ СѓРІРёРґРёРј РёР·РјРµРЅРµРЅРёСЏ
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        button.setText("РћС‡РµРЅСЊ РґР»РёРЅРЅС‹Р№ С‚РµРєСЃС‚");
      }
    });
    // РїСЂРё РґРѕР±Р°РІР»РµРЅРёРё РІ РєРѕРЅС‚РµР№РЅРµСЂ revalidate()
    // Р°РІС‚РѕРјР°С‚РёС‡РµСЃРєРё РЅРµ РІС‹Р·С‹РІР°РµС‚СЃСЏ
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        newButton = new JButton("РќРѕРІРёС‡РѕРє");
        button.getParent().add(newButton);
      }
    });
    Thread.sleep(2000);
    // revalidate() РјРѕР¶РµС‚ Р±С‹С‚СЊ РІС‹Р·РІР°РЅ РёР· Р»СЋР±РѕРіРѕ РїРѕС‚РѕРєР°
    newButton.revalidate();
  }
}