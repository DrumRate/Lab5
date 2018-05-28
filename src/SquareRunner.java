    import java.awt.Graphics;
    import java.util.ArrayList;
    import java.util.List;
    import javax.swing.JComponent;

    public class SquareRunner extends JComponent implements Runnable {

        private List<Square> squares = new ArrayList<>();

        public SquareRunner() {
            super();
            for (int i = 0; i < 3; i++) {
                addSquare();
            }
            new Thread(this).start();
        }

        public void addSquare() {
            squares.add(new Square());
        }

        public void removeSquare() {
            squares.remove(squares.size()-1);
        }

        @Override
        public void paintComponent(Graphics g) {
            for (Square square : squares) {
                square.move();
                square.paintComponent(g);
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
