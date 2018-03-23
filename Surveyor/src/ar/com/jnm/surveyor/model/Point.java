package ar.com.jnm.surveyor.model;

import java.io.Serializable;

public class Point implements Comparable<Point>, Serializable {

  private static final long serialVersionUID = -3251459317294901671L;

  private double x;

  private double y;

  public Point(double x, double y) {
    setX(x);
    setY(y);
  }

  public double getX() {
    return x;
  }

  private void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  private void setY(double y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("( %1$.2f ; %2$.2f )", getX(), getY());
  }

  public double distance(Point other) {
    return Math.hypot(getDelta(getX(), other.getX()), getDelta(getY(), other.getY()));
  }

  private double getDelta(double v1, double v2) {
    return Math.abs(v1 - v2);
  }

  public Line getLine(Point other) {
    if (Math.abs(getX() - other.getX()) < 0.001) {
      throw new IllegalArgumentException("Linea vertical...");
    }

    double a = (other.getY() - getY()) / (other.getX() - getX());
    double b = getY() - a * getX();

    return new Line(a, b);
  }

  @Override
  public int compareTo(Point o) {
    int i;
    return (i = Double.compare(getX(), o.getX())) == 0 ? Double.compare(getY(), o.getY()) : i;
  }
}
