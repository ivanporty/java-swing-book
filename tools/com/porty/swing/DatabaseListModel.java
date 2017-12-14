// DatabaseListModel.java
// РњРѕРґРµР»СЊ СЃРїРёСЃРєР°, СЂР°Р±РѕС‚Р°СЋС‰Р°СЏ СЃ Р±Р°Р·РѕР№ РґР°РЅРЅС‹С…
package com.porty.swing;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class DatabaseListModel extends AbstractListModel {
  // Р·РґРµСЃСЊ Р±СѓРґРµРј С…СЂР°РЅРёС‚СЊ РґР°РЅРЅС‹Рµ
  private ArrayList<String> data = new ArrayList<String>();
  // Р·Р°РіСЂСѓР·РєР° РёР· Р±Р°Р·С‹ РґР°РЅРЅС‹С…
  public void setDataSource(ResultSet rs, String column)
      throws SQLException {
    // РїРѕР»СѓС‡Р°РµРј РґР°РЅРЅС‹Рµ
    data.clear();
    while ( rs.next() ) {
      data.add(rs.getString(column));
    }
    // РѕРїРѕРІРµС‰Р°РµРј РІРёРґС‹ (РµСЃР»Рё РѕРЅРё РµСЃС‚СЊ)
    fireIntervalAdded(this, 0, data.size());
  }
  // РјРµС‚РѕРґС‹ РјРѕРґРµР»Рё РґР»СЏ РІС‹РґР°С‡Рё РґР°РЅРЅС‹С… СЃРїРёСЃРєСѓ
  public int getSize() {
    return data.size();
  }
  public Object getElementAt(int idx) {
    return data.get(idx);
  }
}
