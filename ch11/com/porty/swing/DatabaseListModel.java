// DatabaseListModel.java
// Модель списка, работающая с базой данных
package com.porty.swing;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class DatabaseListModel extends AbstractListModel {
  // здесь будем хранить данные
  private ArrayList<String> data = new ArrayList<String>();
  // загрузка из базы данных
  public void setDataSource(ResultSet rs, String column)
      throws SQLException {
    // получаем данные
    data.clear();
    while ( rs.next() ) {
      data.add(rs.getString(column));
    }
    // оповещаем виды (если они есть)
    fireIntervalAdded(this, 0, data.size());
  }
  // методы модели для выдачи данных списку
  public int getSize() {
    return data.size();
  }
  public Object getElementAt(int idx) {
    return data.get(idx);
  }
}
