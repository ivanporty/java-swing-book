// FlowLayoutSample.java
// Последовательное расположение
import java.awt.*;
import javax.swing.*;

public class FlowLayoutSample extends JFrame {
	public FlowLayoutSample() {
		super("FlowLayoutSample");
		setSize(400, 200);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// устанавливаем последовательное расположение с
		// выравниванием компонентов по центру
		setLayout( new FlowLayout( FlowLayout.CENTER ));
		// добавляем компоненты
		add( new JButton("Один"));
		add( new JButton("Два"));
		add( new JButton("Три"));
		// выводим окно на экран
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new FlowLayoutSample(); } });
	}
}