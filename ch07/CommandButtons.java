// CommandButtons.java
// Создание панели командных кнопок
import javax.swing.*;
import java.awt.*;

public class CommandButtons extends JFrame {
	public CommandButtons() {
		super("CommandButtons");
		setSize(350, 250);
		setLocation(150, 100);
		setDefaultCloseOperation( EXIT_ON_CLOSE );    
		// создаем панель с табличным расположением для
		// выравнивания размеров кнопок
		JPanel grid = new JPanel(
			new GridLayout(1, 2, 5, 0) );
		// добавляем компоненты
		grid.add( new JButton("OK"));
		grid.add( new JButton("Отмена"));
		// помещаем полученное в панель с последовательным
		// расположением, выравненным по правому краю
		JPanel flow = new JPanel(
			new FlowLayout( FlowLayout.RIGHT ));
		flow.add(grid);
		// помещаем строку кнопок вниз окна
		add(flow, BorderLayout.SOUTH );
		// выводим окно на экран
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new CommandButtons(); } });
	}
}