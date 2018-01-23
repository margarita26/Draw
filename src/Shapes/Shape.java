package Shapes;

import java.awt.*;

public class  Shape {

  private Point p;
  private Color c;

  public Shape(Point p, Color c) {
    this.p = p;
    this.c = c;
  }

  public void setPoint(Point newP) {
    p = newP;
  }

  public void setColor(Color newC) {
    c = newC;
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