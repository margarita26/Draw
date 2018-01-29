package Shapes;

import java.awt.*;

/**
 * Class represents the shape which holds the position of the click and its color.
 */
public class  Shape {

  private Point p;
  private Color c;

  public Shape(Point p, Color c) {
    this.p = p;
    this.c = c;
  }

  public double getPointX() {
    return p.getX();
  }

  public double getPointY() {
    return p.getY();
  }

  public Color getColor() {
    return c;
  }

}
