// DBListModelTest.java
// Использование модели списка 
// для работы с базами данных
import javax.swing.*;
import java.sql.*;
import java.awt.*;

import com.porty.swing.*;

public class DBListModelTest {
  // параметры базы данных
  private static String
      dsn = "jdbc:odbc:Library",
      uid = "",
      pwd = "",
      query = "select * from readers.csv";
  public static void main(String[] args) throws Exception {
    // инициализация JDBC
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    // объект-соединение с базой данных
    Connection conn = DriverManager.getConnection(dsn, uid, pwd);
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    // создаем модель
    final DatabaseListModel dblm = new DatabaseListModel();
    // загружаем данные
    dblm.setDataSource(rs, "surname");
    rs.close();
    // интерфейс создаем в потоке рассылки событий
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // присоединяем список
            JList list = new JList(dblm);
            // помещаем список в окно
            JFrame frame = new JFrame("DBList");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
