// WindowDecorations.java
// Специальное оформление окон Swing
import javax.swing.*;

public class WindowDecorations {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // включим украшения для окон
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            // окно с рамкой
            JFrame frame = new JFrame("Окно с рамкой");
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.setVisible(true);
            // диалоговое окно
            JDialog dialog = new JDialog(frame, "Диалог");
            dialog.setDefaultCloseOperation(
                JDialog.DISPOSE_ON_CLOSE);
            dialog.setSize(150, 100);
            // так можно задавать тип оформления окна
            dialog.getRootPane().setWindowDecorationStyle(
                JRootPane.INFORMATION_DIALOG);
            dialog.setVisible(true);
          }
        });
  }
}
