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
    System.out.print("Define C1.x coordinate: ");
    double x1 = getScanner().nextDouble();
    System.out.print("Define C1.y coordinate: ");
    double y1 = getScanner().nextDouble();
    System.out.print("Define C1 radius: ");
    double r1 = getScanner().nextDouble();
    System.out.print("Define C2.x coordinate: ");
    double x2 = getScanner().nextDouble();
    System.out.print("Define C2.y coordinate: ");
    double y2 = getScanner().nextDouble();
    System.out.print("Define C2 radius: ");
    double r2 = getScanner().nextDouble();
    getScanner().nextLine();

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
