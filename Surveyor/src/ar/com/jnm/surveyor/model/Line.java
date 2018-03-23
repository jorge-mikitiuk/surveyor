package ar.com.jnm.surveyor.model;

import java.io.Serializable;
import java.util.Optional;

public class Line implements Comparable<Line>, Serializable {

  private static final long serialVersionUID = -4099175601919188512L;

  private double a;

  private double b;

  public Line(double a, double b) {
    setA(a);
    setB(b);
  }

  public double getA() {
    return a;
  }

  private void setA(double a) {
    this.a = a;
  }

  public double getB() {
    return b;
  }

  private void setB(double b) {
    this.b = b;
  }

  @Override
  public String toString() {
    return String.format("y= %1$.2fX %2$+.2f", getA(), getB());
  }

  public Optional<Point> intersection(Line other) {

    double deltaA = (getA() - other.getA());
    if (deltaA == 0)
      return Optional.empty();

    double x = (other.getB() - getB()) / deltaA;

    return Optional.of(getPoint(x));
  }

  public Point getPoint(double x) {
    double y = getA() * x + getB();
    return new Point(x, y);
  }

  @Override
  public int compareTo(Line o) {
    int i;

    return (i = Double.compare(getA(), o.getA())) == 0 ? Double.compare(getB(), o.getB()) : i;
  }
}
