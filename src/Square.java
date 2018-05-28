import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

public class Square extends JComponent {
    private static final Color COLOR = Color.ORANGE;
    private static final int LENGTH = 50;

    private int xDirection = 1;
    private int yDirection = 1;
    private int xPos;
    private int yPos;

    public Square() {
        Random random = new Random();
        this.xPos = random.nextInt(800);
        this.yPos = random.nextInt(400);
    }

    public void move() {
        if (xPos + xDirection < 0) {
            xDirection = 1;
        } else  if (xPos + xDirection >= 750 - LENGTH){
            xDirection = -1;
        } else if (yPos + yDirection <= 50) {
            yDirection = 1;
        } else  if (yPos + yDirection >= 350 - LENGTH){
            yDirection = -1;
        }
        xPos = xPos + xDirection;
        yPos = yPos + yDirection;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(COLOR);
        g.fillRect(xPos, yPos,LENGTH,LENGTH);
    }
}
