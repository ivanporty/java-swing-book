// com/porty/swing/DatabaseTableModel.java
// РњРѕРґРµР»СЊ РґР°РЅРЅС‹С… С‚Р°Р±Р»РёС†С‹, СЂР°Р±РѕС‚Р°СЋС‰Р°СЏ
// СЃ Р·Р°РїСЂРѕСЃР°РјРё Рє Р±Р°Р·Р°Рј РґР°РЅРЅС‹С…
package com.porty.swing;

import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class DatabaseTableModel
    extends AbstractTableModel {
  // Р·РґРµСЃСЊ РјС‹ Р±СѓРґРµРј С…СЂР°РЅРёС‚СЊ РЅР°Р·РІР°РЅРёСЏ СЃС‚РѕР»Р±С†РѕРІ
  private ArrayList<String> columnNames = new ArrayList<String>();
  // СЃРїРёСЃРѕРє С‚РёРїРѕРІ СЃС‚РѕР»Р±С†РѕРІ
  private ArrayList<Class> columnTypes = new ArrayList<Class>();
  // С…СЂР°РЅРёР»РёС‰Рµ РґР»СЏ РїРѕР»СѓС‡РµРЅРЅС‹С… РґР°РЅРЅС‹С… РёР· Р±Р°Р·С‹ РґР°РЅРЅС‹С…
  private ArrayList<ArrayList<Object>> data
      = new ArrayList<ArrayList<Object>>();
  // РїСЂРёР·РЅР°Рє СЂРµРґР°РєС‚РёСЂРѕРІР°РЅРёСЏ С‚Р°Р±Р»РёС†С‹
  private boolean editable;
  // РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ РїРѕР·РІРѕР»СЏРµС‚ Р·Р°РґР°С‚СЊ РІРѕР·РјРѕР¶РЅРѕСЃС‚СЊ СЂРµРґР°РєС‚РёСЂРѕРІР°РЅРёСЏ
  public DatabaseTableModel(boolean editable) {
    this.editable = editable;
  }
  // РєРѕР»РёС‡РµСЃС‚РІРѕ СЃС‚СЂРѕРє
  public int getRowCount() {
    return data.size();
  }
  // РєРѕР»РёС‡РµСЃС‚РІРѕ СЃС‚РѕР»Р±С†РѕРІ
  public int getColumnCount() {
    return columnNames.size();
  }
  // С‚РёРї РґР°РЅРЅС‹С… СЃС‚РѕР»Р±С†Р°
  public Class getColumnClass(int column) {
    return columnTypes.get(column);
  }
  // РЅР°Р·РІР°РЅРёРµ СЃС‚РѕР»Р±С†Р°
  public String getColumnName(int column) {
    return columnNames.get(column);
  }
  // РґР°РЅРЅС‹Рµ РІ СЏС‡РµР№РєРµ
  public Object getValueAt(int row, int column) {
    return (data.get(row)).get(column);
  }
  // РІРѕР·РјРѕР¶РЅРѕСЃС‚СЊ СЂРµРґР°РєС‚РёСЂРѕРІР°РЅРёСЏ
  public boolean isCellEditable(int row, int column) {
    return editable;
  }
  // Р·Р°РјРµРЅР° Р·РЅР°С‡РµРЅРёСЏ СЏС‡РµР№РєРё
  public void setValueAt(
      Object value, int row, int column){
    (data.get(row)).set(column, value);
  }
  // РїРѕР»СѓС‡РµРЅРёРµ РґР°РЅРЅС‹С… РёР· РѕР±СЉРµРєС‚Р° ResultSet
  public void setDataSource(
      ResultSet rs) throws Exception {
    // СѓРґР°Р»СЏРµРј РїСЂРµР¶РЅРёРµ РґР°РЅРЅС‹Рµ
    data.clear();
    columnNames.clear();
    columnTypes.clear();
    // РїРѕР»СѓС‡Р°РµРј РІСЃРїРѕРјРѕРіР°С‚РµР»СЊРЅСѓСЋ РёРЅС„РѕСЂРјР°С†РёСЋ Рѕ СЃС‚РѕР»Р±С†Р°С…
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    for ( int i=0; i<columnCount; i++) {
      // РЅР°Р·РІР°РЅРёРµ СЃС‚РѕР»Р±С†Р°
      columnNames.add(rsmd.getColumnName(i+1));
      // С‚РёРї СЃС‚РѕР»Р±С†Р°
      Class type =
          Class.forName(rsmd.getColumnClassName(i+1));
      columnTypes.add(type);
    }
    // РїРѕР»СѓС‡Р°РµРј РґР°РЅРЅС‹Рµ
    while ( rs.next() ) {
      // Р·РґРµСЃСЊ Р±СѓРґРµРј С…СЂР°РЅРёС‚СЊ СЏС‡РµР№РєРё РѕРґРЅРѕР№ СЃС‚СЂРѕРєРё
      ArrayList<Object> row = new ArrayList<Object>();
      for ( int i=0; i<columnCount; i++) {
        row.add(rs.getObject(i+1));
      }
      data.add(row);
    }
    // СЃРѕРѕР±С‰Р°РµРј РѕР± РёР·РјРµРЅРµРЅРёСЏС… РІ СЃС‚СЂСѓРєС‚СѓСЂРµ РґР°РЅРЅС‹С…
    fireTableStructureChanged();
  }
}