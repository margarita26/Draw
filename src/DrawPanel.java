import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

import Shapes.Shape;

/**
 * Class represents the board to draw on.
 */
public class DrawPanel extends JPanel implements ActionListener, MouseListener,
        MouseMotionListener {

  private Color c;
  private int widthS;
  private int heightS;
  private ArrayList<Shape> shapes;
  private int valueInPanel;


  public DrawPanel() {
    super();
    shapes = new ArrayList<>();
    this.setPreferredSize(new Dimension(1000, 1000));
    this.setBackground(Color.WHITE);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
    this.c = Color.BLACK;
    this.valueInPanel = 5;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Shape s : shapes) {
      g.setColor(s.getColor());
      g.fillOval((int)s.getPointX(),(int)s.getPointY(),s.getWidthS(),s.getHeightS());
    }
  }

  protected void changeS(int value) {
    valueInPanel = value;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
    shapes.add(new Shape(e.getPoint(),c, valueInPanel,valueInPanel));
    repaint();
  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public void mouseDragged(MouseEvent e) {
    shapes.add(new Shape(e.getPoint(),c, valueInPanel,valueInPanel));
    repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }

  public void restart() {
    shapes = new ArrayList<>();
    repaint();
  }

  //changes color of the drawing shape.
  public void setColor(String s) {
    Color newC;
    try {
      newC = (Color) Color.class.getField(s.toLowerCase()).get(null);
    } catch (Exception e) {
      newC = null; // Not defined
    }
    this.c = newC;
  }
}
