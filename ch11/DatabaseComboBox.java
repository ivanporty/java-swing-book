// DatabaseComboBox.java
// ѕример использовани€ модели DatabaseComboBoxModel
import javax.swing.*;
import com.porty.swing.DatabaseComboBoxModel;
import java.sql.*;
import java.awt.*;

public class DatabaseComboBox extends JFrame {
  // параметры подключени€ к базе данных
  private static String
      dsn = "jdbc:odbc:Library",
      uid = "",
      pwd = "";
  // наша модель
  private DatabaseComboBoxModel cbm;
  public DatabaseComboBox() {
    super("DatabaseComboBox");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // настраиваем соединение с базой данных
    Connection conn = null;
    try {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      // объект-соединение с базой данных
      conn = DriverManager.getConnection(dsn, uid, pwd);
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(
          "select * from readers.csv");
      // передаем данные в модель
      cbm = new DatabaseComboBoxModel();
      cbm.setDataSource(rs, 2);
      rs.close();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
    // присоедин€ем модель к списку
    setLayout(new FlowLayout());
    add(new JComboBox(cbm));
    // выводим окно на экран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new DatabaseComboBox(); } });
  }
}