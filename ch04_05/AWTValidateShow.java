// Р‘Р°Р·РѕРІР°СЏ РІР°Р»РёРґР°С†РёСЏ AWT - РїСЂРё РёР·РјРµРЅРµРЅРёРё СЂР°Р·РјРµСЂРѕРІ
//  РёР»Рё РґСЂСѓРіРёС… РїР°СЂР°РјРµС‚СЂРѕРІ РѕСЃС‚Р°РµС‚СЃСЏ РІС‹Р·РІР°С‚СЊ validate()
import java.awt.*;

public class AWTValidateShow extends Frame {
  private static Button button;

  public AWTValidateShow() {
    setSize(400, 300);
    Panel contents = new Panel();
    button = new Button("РўРµРєСЃС‚");
    Button button2 = new Button("РўРµРєСЃС‚ 2");
    contents.add(button);
    contents.add(button2);
    add(contents);
  }

  public static void main(String[] args)
      throws InterruptedException {
    new AWTValidateShow().setVisible(true);
    Thread.sleep(2000);
    button.setLabel("РћС‡РµРЅСЊ РґР»РёРЅРЅС‹Р№ С‚РµРєСЃС‚");
    // РЎ СЌС‚РѕРіРѕ РјРѕРјРµРЅС‚Р° СЂР°Р·РјРµСЂ РїРѕРјРµРЅСЏР»СЃСЏ - РІС‹Р·РІР°РЅ invalidate()
    // РјРѕР¶РЅРѕ РІС‹Р·С‹РІР°С‚СЊ validate() РІ РєРѕРЅС‚РµР№РЅРµСЂРµ
    Thread.sleep(2000);
    // Р±СѓРґРµС‚ Р·Р°РЅРѕРІРѕ СЂР°СЃРїРѕР»РѕР¶РµРЅ РІРµСЃСЊ РєРѕРЅС‚РµР№РЅРµСЂ
    // Рё РІСЃРµ РµРіРѕ СЃРѕРґРµСЂР¶РёРјРѕРµ (РєРЅРѕРїРєР°)
    button.getParent().validate();
  }
}