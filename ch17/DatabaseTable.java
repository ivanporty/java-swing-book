// DatabaseTable.java
// Таблица, работающая с базой данных
// посредством специальной модели
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import com.porty.swing.*;

public class DatabaseTable {
  // параметры подключения
  private static String
      dsn = "jdbc:odbc:Library",
      uid = "",
      pwd = "";
  public static void main(String[] args) throws Exception {
    // инициализация JDBC
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    // объект-соединение с БД
    Connection conn = DriverManager.getConnection(dsn, uid, pwd);
    Statement st = conn.createStatement();
    // выполняем запрос
    ResultSet rs = st.executeQuery(
        "select * from readers.csv");
    // наша модель
    final DatabaseTableModel dbm =
        new DatabaseTableModel(true);
    // считываем данные в таблицу
    dbm.setDataSource(rs);
    // таблица и окно
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            JTable table = new JTable(dbm);
            JFrame frame = new JFrame("DatabaseTable");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(new JScrollPane(table));
            frame.setVisible(true);
          }});
    rs.close();
    conn.close();
  }
}