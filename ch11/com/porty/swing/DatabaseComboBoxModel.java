// com/porty/swing/DatabaseComboBoxModel.java
// Модель раскрывающегося списка для работы с базами данных
package com.porty.swing;

import javax.swing.*;
import java.sql.*;

public class DatabaseComboBoxModel
    extends DefaultComboBoxModel {
  // получение данных из запроса ResultSet
  public void setDataSource(ResultSet rs, int column)
      throws SQLException {
    // очистим список
    removeAllElements();
    // добавим новые элементы из базы данных
    while ( rs.next() ) {
      // получаем строки из столбца column
      addElement(rs.getString(column));
    }
  }
}
