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
    System.out.print("Define C1.x coordinate: ");
    double x1 = getScanner().nextDouble();
    System.out.print("Define C1.y coordinate: ");
    double y1 = getScanner().nextDouble();
    System.out.print("Define C1 radius: ");
    double r1 = getScanner().nextDouble();
    System.out.print("Define R.A: ");
    double a = getScanner().nextDouble();
    System.out.print("Define R.B: ");
    double b = getScanner().nextDouble();
    getScanner().nextLine();

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
