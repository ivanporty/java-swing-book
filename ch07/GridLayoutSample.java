// GridLayoutSample.java
// Табличное расположение
import java.awt.*;
import javax.swing.*;

public class GridLayoutSample extends JFrame {
	public GridLayoutSample() {
		super("GridLayoutSample");
		setSize(300, 200);
		setLocation(100, 100);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// вспомогательная панель
		JPanel grid = new JPanel();
		// первые два параметра конструктора GridLayout -
		// количество строк и столбцов в таблице
		// вторые два - расстояние между ячейками по X и Y
		GridLayout gl = new GridLayout(2, 0, 5, 12);
		grid.setLayout(gl);
		// создаем 8 кнопок
		for (int i=0; i<8; i++) {
			grid.add(new JButton("Кнопка " + i));
		}
		// помещаем нашу панель в центр окна
		add(grid);
		// устанавливаем оптимальный размер
		pack();
		// показываем окно
		setVisible(true);
	}
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new GridLayoutSample(); } });
	}
}
