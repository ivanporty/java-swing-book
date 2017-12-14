// com/porty/swing/XMLMenuLoader.java
// Инструмент для загрузки меню из файла XML
package com.porty.swing;

import javax.swing.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import javax.xml.parsers.*;
import java.awt.event.*;
import java.util.*;

public class XMLMenuLoader {
  // источник данных XML
  private InputSource source;
  // анализатор XML
  private SAXParser parser;
  // обработчик XML
  private DefaultHandler documentHandler;
  // хранилище для всех частей системы меню
  private Map<String, JComponent> menuStorage
      = new HashMap<String, JComponent>();

  // конструктор, требует задать поток данных с меню
  public XMLMenuLoader(InputStream stream) {
    // настраиваем источник данных XML
    try {
      Reader reader = new InputStreamReader(stream, "UTF-8");
      source = new InputSource(reader);
      parser = SAXParserFactory.
          newInstance().newSAXParser();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
    // создаем обработчик XML
    documentHandler = new XMLParser();
  }

  // считывает XML и создает систему меню
  public void parse() throws Exception {
    parser.parse(source, documentHandler);
  }

  // позволяет получить строку меню
  public JMenuBar getMenuBar(String name) {
    return (JMenuBar) menuStorage.get(name);
  }
  // позволяет получить выпадающее меню
  public JMenu getMenu(String name) {
    return (JMenu) menuStorage.get(name);
  }
  // позволяет получить элемент меню
  public JMenuItem getMenuItem(String name) {
    return (JMenuItem) menuStorage.get(name);
  }
  // удобный метод для быстрого добавления
  // слушателя событий
  public void addActionListener(String name, ActionListener listener) {
    getMenuItem(name).addActionListener(listener);
  }

  // текущая строка меню
  private JMenuBar currentMenuBar;
  // список для упорядочения выпадающих меню
  private LinkedList<JMenu> menus = new LinkedList<JMenu>();

  // обработчик XML
  class XMLParser extends DefaultHandler {
    // новый узел XML
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {
      // определяем тип узла
      if (qName.equals("menubar"))
        parseMenuBar(attributes);
      else if (qName.equals("menu"))
        parseMenu(attributes);
      else if (qName.equals("menuitem"))
        parseMenuItem(attributes);
    }
    // конец узла, используется для смены выпадающих меню
    public void endElement(String uri, String localName,
                           String qName) {
      if (qName.equals("menu")) menus.removeFirst();
    }
    // создает новую строку меню
    protected void parseMenuBar(Attributes attrs) {
      JMenuBar menuBar = new JMenuBar();
      // определяем имя
      String name = attrs.getValue("name");
      menuStorage.put(name, menuBar);
      currentMenuBar = menuBar;
    }
    // создает новое выпадающее меню
    protected void parseMenu(Attributes attrs) {
      // создаем меню
      JMenu menu = new JMenu();
      String name = attrs.getValue("name");
      // настраиваем общие атрибуты
      adjustProperties(menu, attrs);
      menuStorage.put(name, menu);
      // добавляем меню к предыдущему выпадающему
      // меню или к строке меню
      if ( menus.size() != 0 ) {
        menus.getFirst().add(menu);
      } else {
        currentMenuBar.add(menu);
      }
      // добавляем в список выпадающих меню
      menus.addFirst(menu);
    }
    // новый пункт меню
    protected void parseMenuItem(Attributes attrs) {
      // проверяем, не разделитель ли это
      String name = attrs.getValue("name");
      if (name.equals("separator")) {
        menus.getFirst().addSeparator();
        return;
      }
      // создаем пункт меню
      JMenuItem menuItem = new JMenuItem();
      // настраиваем свойства
      adjustProperties(menuItem, attrs);
      menuStorage.put(name, menuItem);
      // добавляем к текущему выпадающему меню
      menus.getFirst().add(menuItem);
    }
    // настройка общих атрибутов пунктов меню
    private void adjustProperties(
        JMenuItem menuItem, Attributes attrs) {
      // получаем поддерживаемые атрибуты
      String text = attrs.getValue("text");
      String mnemonic = attrs.getValue("mnemonic");
      String accelerator = attrs.getValue("accelerator");
      String enabled = attrs.getValue("enabled");
      // настраиваем свойства меню
      menuItem.setText(text);
      if (mnemonic != null) {
        menuItem.setMnemonic(mnemonic.charAt(0));
      }
      if (accelerator != null) {
        menuItem.setAccelerator(
            KeyStroke.getKeyStroke(accelerator));
      }
      if (enabled != null) {
        menuItem.setEnabled(Boolean.valueOf(enabled));
      }
    }
  }
}
