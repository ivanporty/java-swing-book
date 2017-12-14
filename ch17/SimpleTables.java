// SimpleTables.java
// ������� ������� � ������� ������� �������������
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleTables extends JFrame {
  // ������ ��� ������
  private Object[][] colors = new String[][] {
      { "�������", "�������", "�����" },
      { "������", "���������", "�����" },
  };
  // �������� ���������� ��������
  private Object[] colorsHeader = new String[] {
      "����", "��� ����", "���� ����"
  };
  public SimpleTables() {
    super("SimpleTables");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ��������� ������� ������
    JTable table1 = new JTable(colors, colorsHeader);
    JTable table2 = new JTable(5, 5);
    // ������� �� ������ �������, ���������� �� ��������
    Vector<Vector<String>> data =
        new Vector<Vector<String>>();
    Vector<String> row1 = new Vector<String>();
    Vector<String> row2 = new Vector<String>();
    // ������ � ����������� ��������
    Vector<String> columnNames = new Vector<String>();
    // ���������� �������
    for (int i=0; i<3; i++) {
      row1.add("������ 1." + i);
      row2.add("������ 2." + i);
      columnNames.add("������� #" + i);
    }
    data.add(row1);
    data.add(row2);
    JTable table3 = new JTable(data, columnNames);
    // ��������� ������� � ������ � ����� ������
    setLayout(new GridLayout(3, 1));
    add(new JScrollPane(table1));
    add(new JScrollPane(table2));
    add(table3);
    // ������� ���� �� �����
    setSize(350, 400);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTables(); } });
  }
}