package ar.com.jnm.surveyor.view;

import java.util.Scanner;
import java.util.Set;

import ar.com.jnm.surveyor.model.Circle;
import ar.com.jnm.surveyor.model.Line;
import ar.com.jnm.surveyor.model.Point;
import ar.com.jnm.surveyor.service.Service;

public class CircleToLineIntersectionView extends AbstractView {

  public CircleToLineIntersectionView(Scanner scanner, Service service) {
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
    System.out.print("Ingrese el valor A de R: ");
    double a = getScanner().nextDouble();
    System.out.print("Ingrese el valor B de R: ");
    double b = getScanner().nextDouble();

    Set<Point> points = new Circle(new Point(x1, y1), r1).intersection(new Line(a, b));
    for (Point point : points) {
      System.out.println(point);
    }
  }

  @Override
  public String getDescription() {
    return "Print circle to line intersection points";
  }

}
