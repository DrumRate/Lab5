import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

public class CircleRunner extends JComponent implements Runnable {

  private List<Circle> circles = new ArrayList<>();

  public CircleRunner() {
    super();
    for (int i = 0; i < 3; i++) {
      addCircle();
    }
    new Thread(this).start();
  }

  public void addCircle() {
    circles.add(new Circle());
  }

  public void removeCircle() {
    circles.remove(circles.size()-1);
  }

  @Override
  public void paintComponent(Graphics g) {
    for (Circle circle : circles) {
      circle.move();
      circle.paintComponent(g);
    }
  }

  @Override
  public void run() {
    while (true) {
      repaint();
      try {
        Thread.sleep(5);
      } catch (InterruptedException ex) {}
    }
  }
}
