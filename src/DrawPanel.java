import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.*;

import Shapes.Shape;


public class DrawPanel extends JPanel implements ActionListener, MouseListener,
        MouseMotionListener {

  private Color c;
  private ArrayList<Shape> shapes;


  public DrawPanel() {
    super();
    shapes = new ArrayList<>();
    this.setPreferredSize(new Dimension(600, 600));
    this.setBackground(Color.WHITE);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
    this.c = Color.BLACK;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Shape s : shapes) {
      g.setColor(s.getColor());
      g.fillOval((int)s.getPointX(),(int)s.getPointY(),5,5);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
    shapes.add(new Shape(e.getPoint(),c));
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
    shapes.add(new Shape(e.getPoint(),c));
    repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }

  public void restart() {
    shapes = new ArrayList<>();
    repaint();
  }

  public void setColor(String s) {
    Color newC;
    try {
      Field field = Color.class.getField(s);
      newC = (Color)field.get(null);
    } catch (Exception e) {
      newC = null; // Not defined
    }
    this.c = newC;
  }
}
