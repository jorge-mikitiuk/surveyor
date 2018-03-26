package ar.com.jnm.surveyor.view;

import java.util.Scanner;
import java.util.Set;

import ar.com.jnm.surveyor.model.Circle;
import ar.com.jnm.surveyor.model.Point;
import ar.com.jnm.surveyor.service.Service;

public class CircleToCircleIntersectionView extends AbstractView {

  public CircleToCircleIntersectionView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.print("Ingrese la coordenada X de C1: ");
    double x1 = getScanner().nextDouble();
    System.out.print("Ingrese la coordenada Y de C1: ");
    double y1 = getScanner().nextDouble();
    System.out.print("Ingrese el radio de C1: ");
    double r1 = getScanner().nextDouble();
    System.out.print("Ingrese la coordenada X de C2: ");
    double x2 = getScanner().nextDouble();
    System.out.print("Ingrese la coordenada Y de C2: ");
    double y2 = getScanner().nextDouble();
    System.out.print("Ingrese el radio de C2: ");
    double r2 = getScanner().nextDouble();

    Set<Point> points = new Circle(new Point(x1, y1), r1).intersection(new Circle(new Point(x2, y2), r2));
    for (Point point : points) {
      System.out.println(point);
    }
  }

  @Override
  public String getDescription() {
    return "Print circles intersection points";
  }

}
