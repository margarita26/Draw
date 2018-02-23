package Shapes;

import java.awt.*;

/**
 * Class represents the shape which holds the position of the click and its color.
 */
public class  Shape {

  private Point p;
  private Color c;
  private int widthS;
  private int heightS;

  public Shape(Point p, Color c, int widthS, int heightS) {
    this.p = p;
    this.c = c;
    this.widthS = widthS;
    this.heightS = heightS;
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

  public void setS(int value) {
    this.widthS = value;
    this.heightS = value;
  }

  public int getWidthS() {
    return widthS;
  }

  public int getHeightS() {
    return heightS;
  }

}
