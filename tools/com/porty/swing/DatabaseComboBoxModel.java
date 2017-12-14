// com/porty/swing/DatabaseComboBoxModel.java
// РњРѕРґРµР»СЊ СЂР°СЃРєСЂС‹РІР°СЋС‰РµРіРѕСЃСЏ СЃРїРёСЃРєР° РґР»СЏ СЂР°Р±РѕС‚С‹ СЃ Р±Р°Р·Р°РјРё РґР°РЅРЅС‹С…
package com.porty.swing;

import javax.swing.*;
import java.sql.*;

public class DatabaseComboBoxModel
    extends DefaultComboBoxModel {
  // РїРѕР»СѓС‡РµРЅРёРµ РґР°РЅРЅС‹С… РёР· Р·Р°РїСЂРѕСЃР° ResultSet
  public void setDataSource(ResultSet rs, int column)
      throws SQLException {
    // РѕС‡РёСЃС‚РёРј СЃРїРёСЃРѕРє
    removeAllElements();
    // РґРѕР±Р°РІРёРј РЅРѕРІС‹Рµ СЌР»РµРјРµРЅС‚С‹ РёР· Р±Р°Р·С‹ РґР°РЅРЅС‹С…
    while ( rs.next() ) {
      // РїРѕР»СѓС‡Р°РµРј СЃС‚СЂРѕРєРё РёР· СЃС‚РѕР»Р±С†Р° column
      addElement(rs.getString(column));
    }
  }
}
