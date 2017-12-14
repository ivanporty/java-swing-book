// BoxGlues.java
// Использование заполнителей
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;

public class BoxGlues extends JFrame {
  public BoxGlues() {
    super("BoxGlues");
    setSize(250, 200);
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // панель с вертикальным блочным расположением
    // в нее поместим все остальные панели
    JPanel main = BoxLayoutUtils.createVerticalPanel();
    // вертикальная панель
    JPanel pVert = BoxLayoutUtils.createVerticalPanel();
    // заполнитель перед компонентами отодвинет
    // их вниз
    pVert.add(Box.createVerticalGlue());
    pVert.add(new JButton("Один"));
    pVert.add(new JButton("Два"));
    // горизонтальная панель
    // теперь можно разместить компоненты по центру
    JPanel pHor = BoxLayoutUtils.createHorizontalPanel();
    pHor.add(Box.createHorizontalGlue());
    pHor.add(new JButton("Три"));
    pHor.add(new JButton("Четыре"));
    pHor.add(Box.createHorizontalGlue());
    // укладываем панели вертикально
    main.add(pVert);
    main.add(Box.createVerticalStrut(15));
    main.add(pHor);
    // добавляем панель в центр окна
    add(main);
    // выводим окно на экран
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new BoxGlues(); } });
  }
}