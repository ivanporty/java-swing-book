// BoxStruts.java
// Использование распорок при блочном расположении
import javax.swing.*;
// используем наш новый класс
import com.porty.swing.BoxLayoutUtils;

public class BoxStruts extends JFrame {
	public BoxStruts() {
		super("BoxStruts");
		setSize(250, 200);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// панель с вертикальным блочным расположением
		JPanel p = BoxLayoutUtils.createVerticalPanel();
		p.add(new JButton("Один"));
		// создание вертикальной распорки
		p.add(Box.createVerticalStrut(15));
		// новый компонент и распорка другого размера
		p.add(new JButton("Два"));
		p.add(Box.createVerticalStrut(5));
		p.add(new JButton("Три"));
		// панель с горизонтальным блочным расположением
		JPanel p2 = BoxLayoutUtils.createHorizontalPanel();
		// распорки можно ставить и перед компонентами
		p2.add(Box.createHorizontalStrut(10));
		p2.add(new JButton("Один"));
		// создание горизонтальной распорки
		p2.add(Box.createHorizontalStrut(25));
		p2.add(new JButton("Два"));
		// добавляем панели на север и юг окна
		add(p, "North");
		add(p2, "South");
		// выводим окно на экран
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BoxStruts(); } });
	}
}
