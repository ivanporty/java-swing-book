// BoxAlignment.java
// Как блочное расположение обеспечивает выравнивание
// компонентов по осям
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;

public class BoxAlignment extends JFrame {
	public BoxAlignment() {
		super("BoxAlignment");
		setSize(400, 150);
		setDefaultCloseOperation( EXIT_ON_CLOSE );    
		// вертикальная панель
		JPanel pv = BoxLayoutUtils.createVerticalPanel();
		// кнопка с выравниванием по левой границе
		JButton jb = new JButton("Левая граница");
		jb.setAlignmentX(LEFT_ALIGNMENT);
		pv.add(jb);
		// копка с центральным выравниванием
		jb = new JButton("Выравнивание по центру");
		jb.setAlignmentX(CENTER_ALIGNMENT);
		pv.add(jb);
		// наконец, кнопка с выравниванием по правому краю
		jb = new JButton("Правая граница");
		jb.setAlignmentX(RIGHT_ALIGNMENT);
		pv.add(jb);
		// добавляем панель в центр окна
		add(pv);
		// выводим окно на экран
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BoxAlignment(); } });
	}
}
