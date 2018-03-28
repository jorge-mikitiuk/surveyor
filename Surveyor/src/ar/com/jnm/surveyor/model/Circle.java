package ar.com.jnm.surveyor.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Circle implements Serializable {

  private static final long serialVersionUID = -2024305310487540659L;

  private Point center;

  private double radius;

  public Circle(Point center, double radius) {
    setRadius(radius);
    setCenter(center);
  }

  public Point getCenter() {
    return center;
  }

  private void setCenter(Point center) {
    this.center = center;
  }

  public double getRadius() {
    return radius;
  }

  private void setRadius(double radius) {
    this.radius = radius;
  }

  @Override
  public String toString() {
    return String.format("C(x,y) -> (%1$.2f - X)^2 + (%2$.2f - Y)^2 == %3$.2f^2", getCenter().getX(),
        getCenter().getY(), getRadius());
  }

  public Set<Point> intersection(Line line) {
    Set<Point> points = new TreeSet<>();

    double a = line.getA();
    double a2 = a * a;
    double b = line.getB();
    double x = getCenter().getX();
    double x2 = x * x;
    double y = getCenter().getY();
    double r = getRadius();
    double r2 = r * r;

    double A = a2 + 1;
    double B = 2 * a * (b - y) - 2 * x;
    double C = x2 + Math.pow(y - b, 2) - r2;

    double aux2 = Math.pow(B, 2) - 4 * A * C;
    if (aux2 == 0) {
      double x_1 = -B / (2 * A);
      points.add(line.getPoint(x_1));
    }
    if (aux2 > 0) {

      double aux3 = Math.sqrt(aux2);

      double x_1 = (-B + aux3) / (2 * A);
      double x_2 = (-B - aux3) / (2 * A);

      points.add(line.getPoint(x_1));
      points.add(line.getPoint(x_2));
    }

    return points;
  }

  public Set<Point> intersection(Circle other) {
    double x1 = getCenter().getX();
    double x1_2 = x1 * x1;
    double y1 = getCenter().getY();
    double y1_2 = y1 * y1;
    double r1 = getRadius();
    double r1_2 = r1 * r1;

    double x2 = other.getCenter().getX();
    double x2_2 = x2 * x2;
    double y2 = other.getCenter().getY();
    double y2_2 = y2 * y2;
    double r2 = other.getRadius();
    double r2_2 = r2 * r2;

    double a = (x2 - x1) / (y1 - y2);
    double b = ((x1_2 - x2_2) + (y1_2 - y2_2) + (r2_2 - r1_2)) / (2 * (y1 - y2));

    return intersection(new Line(a, b));
  }
}
