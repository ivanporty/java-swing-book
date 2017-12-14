// com/porty/swing/DatabaseTableModel.java
// ћодель данных таблицы, работающа€
// с запросами к базам данных
package com.porty.swing;

import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class DatabaseTableModel
    extends AbstractTableModel {
  // здесь мы будем хранить названи€ столбцов
  private ArrayList<String> columnNames = new ArrayList<String>();
  // список типов столбцов
  private ArrayList<Class> columnTypes = new ArrayList<Class>();
  // хранилище дл€ полученных данных из базы данных
  private ArrayList<ArrayList<Object>> data
      = new ArrayList<ArrayList<Object>>();
  // признак редактировани€ таблицы
  private boolean editable;
  // конструктор позвол€ет задать возможность редактировани€
  public DatabaseTableModel(boolean editable) {
    this.editable = editable;
  }
  // количество строк
  public int getRowCount() {
    return data.size();
  }
  // количество столбцов
  public int getColumnCount() {
    return columnNames.size();
  }
  // тип данных столбца
  public Class getColumnClass(int column) {
    return columnTypes.get(column);
  }
  // название столбца
  public String getColumnName(int column) {
    return columnNames.get(column);
  }
  // данные в €чейке
  public Object getValueAt(int row, int column) {
    return (data.get(row)).get(column);
  }
  // возможность редактировани€
  public boolean isCellEditable(int row, int column) {
    return editable;
  }
  // замена значени€ €чейки
  public void setValueAt(
      Object value, int row, int column){
    (data.get(row)).set(column, value);
  }
  // получение данных из объекта ResultSet
  public void setDataSource(
      ResultSet rs) throws Exception {
    // удал€ем прежние данные
    data.clear();
    columnNames.clear();
    columnTypes.clear();
    // получаем вспомогательную информацию о столбцах
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    for ( int i=0; i<columnCount; i++) {
      // название столбца
      columnNames.add(rsmd.getColumnName(i+1));
      // тип столбца
      Class type =
          Class.forName(rsmd.getColumnClassName(i+1));
      columnTypes.add(type);
    }
    // получаем данные
    while ( rs.next() ) {
      // здесь будем хранить €чейки одной строки
      ArrayList<Object> row = new ArrayList<Object>();
      for ( int i=0; i<columnCount; i++) {
        row.add(rs.getObject(i+1));
      }
      data.add(row);
    }
    // сообщаем об изменени€х в структуре данных
    fireTableStructureChanged();
  }
}