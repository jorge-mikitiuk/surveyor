package ar.com.jnm.surveyor.service;

import ar.com.jnm.surveyor.model.Point;

public class Reference implements Comparable<Reference> {

  private String name;

  private Point point;

  public Reference(String name, Point point) {
    setName(name);
    setPoint(point);
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public Point getPoint() {
    return point;
  }

  private void setPoint(Point point) {
    this.point = point;
  }

  @Override
  public String toString() {
    return getName() + " " + getPoint();
  }

  @Override
  public int compareTo(Reference o) {
    return getName().compareToIgnoreCase(o.getName());
  }
}
