import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
      String title = "Title";
      int width = 800;
      int height = 400;

      JFrame frame = new JFrame(title);
      JComboBox figuresList = new JComboBox();
      figuresList.addItem("Circles");
      figuresList.addItem("Squares");
      JPanel mainPanel = new JPanel();
      JPanel circlePane = new JPanel();
      JPanel squarePane = new JPanel();
      JButton addFigure = new JButton("+");
      JButton removeFigure = new JButton("-");

      CircleRunner circles = new CircleRunner();
      SquareRunner squares = new SquareRunner();

      frame.setSize(width, height);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);


      frame.add(figuresList, null);
      figuresList.setBounds(100, 0, 75, 25);
      frame.add(addFigure);
      addFigure.setBounds(200, 0, 50, 25);
      frame.add(removeFigure);
      removeFigure.setBounds(275, 0, 50, 25);
//    frame.add(mainPanel);
//    mainPanel.add(circlePane);
//    circlePane.add(circles);
//    frame.add(circlePane);
//    circlePane.setVisible(true);




          addFigure.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  switch (figuresList.getSelectedIndex()) {
                      case 0:
                          circles.addCircle();
                          break;
                      case 1:
                          squares.addSquare();
                          break;
                  }
              }
          });
          removeFigure.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  switch (figuresList.getSelectedIndex()) {
                      case 0:
                          circles.removeCircle();
                          break;
                      case 1:
                          squares.removeSquare();
                          break;
                  }
              }
          });

      while (true) {
          switch (figuresList.getSelectedIndex()) {
              case 0:
                  frame.remove(squares);
                  frame.add(circles, BoxLayout.Y_AXIS);
                  break;
              case 1:
                  frame.remove(circles);
                  frame.add(squares, BoxLayout.Y_AXIS);
                  break;
          }
          frame.setVisible(true);
          //break;
      }
          //addFigure.addActionListener(new );

      }

  }
