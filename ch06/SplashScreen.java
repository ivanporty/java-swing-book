// SplashScreen.java
// Создание заставки для приложения
import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
	public SplashScreen() {
		super();
    // размер и положение окна на экране
		setLocation(200, 100);
		setSize(300, 300);
		// снимаем экранную копию
		try {
			Robot robot = new Robot();
			capture = robot.createScreenCapture(
				new Rectangle(200, 100, 500, 400));
		} catch (Exception ex) { ex.printStackTrace(); }
		// добавляем компонент-заставку
		getContentPane().add(new Splash());
		// выводим окно на экран
		setVisible(true);
		// заканчиваем работу по истечении некоторого времени
/*
		try {
			Thread.sleep(10000);
		} catch (Exception e) {  }
*/
		//System.exit(0);
	}
	// необходимые нам изображения
	private Image capture;
	private Image splash = 
		getToolkit().getImage("splash.gif");
	// компонент рисует заставку
	class Splash extends JComponent {
		public void paintComponent(Graphics g) {
			// рисуем копию экрана
			g.drawImage(capture, 0, 0, this);
			// и поверх нее - рисунок с заставкой
			g.drawImage(splash, 0, 0, this);
		}
	}
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new SplashScreen(); } });
	}
}
