// com/porty/swing/AutoCompleteTextDocument.java
// Модель документа с поддержкой автозаполнения
package com.porty.swing;

import javax.swing.text.*;
import javax.swing.*;
import java.util.*;

public class AutoCompleteTextDocument extends PlainDocument {
  // текстовый компонент в котором работает документ
  private JTextComponent comp;
  // список слов для автозаполнения
  private List<String> words = new ArrayList<String>();
  // конструктор требует текстовый компонент
  public AutoCompleteTextDocument(JTextComponent comp) {
    this.comp = comp;
    comp.setDocument(this);
  }
  // добавляет слово в список
  public void addWord(String word) {
    words.add(word);
  }
  // свойство, управляющее началом автозаполнения
  private int beforeCompletion = 3;
  public void setBeforeCompletion(int value) {
    beforeCompletion = value;
  }

  // вызывается при вставке в документ нового текста
  @Override
  public void insertString(int offs, String str, AttributeSet a)
      throws BadLocationException {
    // текущая позиция в тексте
    int end = offs + str.length();
    // определяем позиции текущего слова
    final int wordStart = Utilities.getWordStart(comp, offs);
    // длина текущего слова
    int wordLength = end - wordStart;
    // проверим, можно ли завершать слово
    if ( wordLength >= beforeCompletion) {
      // получаем текущее слово
      String word = getText(wordStart, offs - wordStart) + str;
      // пытаемся найти его полный вариант в списке
      String wholeWord = "";
      for (String next : words) {
        if (next.startsWith(word)) {
          // слово найдено
          wholeWord = next;
          break;
        }
      }
      // если слово найдено
      if ( wholeWord.length() > 0) {
        // вырезаем часть для автозаполнения
        final String toComplete =
            wholeWord.substring(wordLength);
        // позиции для выделения этой части
        final int startPos = offs + str.length();
        final int endPos = end + toComplete.length();
        // добавляем добавку к тексту
        str = str + toComplete;
        // отложенная задача для выделения добавки
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            try {
              // выделим добавленную часть
              comp.setSelectionStart(startPos);
              comp.setSelectionEnd(endPos);
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }
        });
      }
    }
    // родительский метод добавит текст
    super.insertString(offs, str, a);
  }
}