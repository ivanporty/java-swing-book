// BoxAlignment.java
//  ак блочное расположение обеспечивает выравнивание
// компонентов по ос€м
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;

public class BoxAlignment extends JFrame {
	public BoxAlignment() {
		super("BoxAlignment");
		setSize(400, 150);
		setDefaultCloseOperation( EXIT_ON_CLOSE );    
		// вертикальна€ панель
		JPanel pv = BoxLayoutUtils.createVerticalPanel();
		// кнопка с выравниванием по левой границе
		JButton jb = new JButton("Ћева€ граница");
		jb.setAlignmentX(LEFT_ALIGNMENT);
		pv.add(jb);
		// копка с центральным выравниванием
		jb = new JButton("¬ыравнивание по центру");
		jb.setAlignmentX(CENTER_ALIGNMENT);
		pv.add(jb);
		// наконец, кнопка с выравниванием по правому краю
		jb = new JButton("ѕрава€ граница");
		jb.setAlignmentX(RIGHT_ALIGNMENT);
		pv.add(jb);
		// добавл€ем панель в центр окна
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
