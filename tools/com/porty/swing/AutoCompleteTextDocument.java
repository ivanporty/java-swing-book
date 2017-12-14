// com/porty/swing/AutoCompleteTextDocument.java
// РњРѕРґРµР»СЊ РґРѕРєСѓРјРµРЅС‚Р° СЃ РїРѕРґРґРµСЂР¶РєРѕР№ Р°РІС‚РѕР·Р°РїРѕР»РЅРµРЅРёСЏ
package com.porty.swing;

import javax.swing.text.*;
import javax.swing.*;
import java.util.*;

public class AutoCompleteTextDocument extends PlainDocument {
  // С‚РµРєСЃС‚РѕРІС‹Р№ РєРѕРјРїРѕРЅРµРЅС‚ РІ РєРѕС‚РѕСЂРѕРј СЂР°Р±РѕС‚Р°РµС‚ РґРѕРєСѓРјРµРЅС‚
  private JTextComponent comp;
  // СЃРїРёСЃРѕРє СЃР»РѕРІ РґР»СЏ Р°РІС‚РѕР·Р°РїРѕР»РЅРµРЅРёСЏ
  private List<String> words = new ArrayList<String>();
  // РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ С‚СЂРµР±СѓРµС‚ С‚РµРєСЃС‚РѕРІС‹Р№ РєРѕРјРїРѕРЅРµРЅС‚
  public AutoCompleteTextDocument(JTextComponent comp) {
    this.comp = comp;
    comp.setDocument(this);
  }
  // РґРѕР±Р°РІР»СЏРµС‚ СЃР»РѕРІРѕ РІ СЃРїРёСЃРѕРє
  public void addWord(String word) {
    words.add(word);
  }
  // СЃРІРѕР№СЃС‚РІРѕ, СѓРїСЂР°РІР»СЏСЋС‰РµРµ РЅР°С‡Р°Р»РѕРј Р°РІС‚РѕР·Р°РїРѕР»РЅРµРЅРёСЏ
  private int beforeCompletion = 3;
  public void setBeforeCompletion(int value) {
    beforeCompletion = value;
  }

  // РІС‹Р·С‹РІР°РµС‚СЃСЏ РїСЂРё РІСЃС‚Р°РІРєРµ РІ РґРѕРєСѓРјРµРЅС‚ РЅРѕРІРѕРіРѕ С‚РµРєСЃС‚Р°
  @Override
  public void insertString(int offs, String str, AttributeSet a)
      throws BadLocationException {
    // С‚РµРєСѓС‰Р°СЏ РїРѕР·РёС†РёСЏ РІ С‚РµРєСЃС‚Рµ
    int end = offs + str.length();
    // РѕРїСЂРµРґРµР»СЏРµРј РїРѕР·РёС†РёРё С‚РµРєСѓС‰РµРіРѕ СЃР»РѕРІР°
    final int wordStart = Utilities.getWordStart(comp, offs);
    // РґР»РёРЅР° С‚РµРєСѓС‰РµРіРѕ СЃР»РѕРІР°
    int wordLength = end - wordStart;
    // РїСЂРѕРІРµСЂРёРј, РјРѕР¶РЅРѕ Р»Рё Р·Р°РІРµСЂС€Р°С‚СЊ СЃР»РѕРІРѕ
    if ( wordLength >= beforeCompletion) {
      // РїРѕР»СѓС‡Р°РµРј С‚РµРєСѓС‰РµРµ СЃР»РѕРІРѕ
      String word = getText(wordStart, offs - wordStart) + str;
      // РїС‹С‚Р°РµРјСЃСЏ РЅР°Р№С‚Рё РµРіРѕ РїРѕР»РЅС‹Р№ РІР°СЂРёР°РЅС‚ РІ СЃРїРёСЃРєРµ
      String wholeWord = "";
      for (String next : words) {
        if (next.startsWith(word)) {
          // СЃР»РѕРІРѕ РЅР°Р№РґРµРЅРѕ
          wholeWord = next;
          break;
        }
      }
      // РµСЃР»Рё СЃР»РѕРІРѕ РЅР°Р№РґРµРЅРѕ
      if ( wholeWord.length() > 0) {
        // РІС‹СЂРµР·Р°РµРј С‡Р°СЃС‚СЊ РґР»СЏ Р°РІС‚РѕР·Р°РїРѕР»РЅРµРЅРёСЏ
        final String toComplete =
            wholeWord.substring(wordLength);
        // РїРѕР·РёС†РёРё РґР»СЏ РІС‹РґРµР»РµРЅРёСЏ СЌС‚РѕР№ С‡Р°СЃС‚Рё
        final int startPos = offs + str.length();
        final int endPos = end + toComplete.length();
        // РґРѕР±Р°РІР»СЏРµРј РґРѕР±Р°РІРєСѓ Рє С‚РµРєСЃС‚Сѓ
        str = str + toComplete;
        // РѕС‚Р»РѕР¶РµРЅРЅР°СЏ Р·Р°РґР°С‡Р° РґР»СЏ РІС‹РґРµР»РµРЅРёСЏ РґРѕР±Р°РІРєРё
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            try {
              // РІС‹РґРµР»РёРј РґРѕР±Р°РІР»РµРЅРЅСѓСЋ С‡Р°СЃС‚СЊ
              comp.setSelectionStart(startPos);
              comp.setSelectionEnd(endPos);
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }
        });
      }
    }
    // СЂРѕРґРёС‚РµР»СЊСЃРєРёР№ РјРµС‚РѕРґ РґРѕР±Р°РІРёС‚ С‚РµРєСЃС‚
    super.insertString(offs, str, a);
  }
}