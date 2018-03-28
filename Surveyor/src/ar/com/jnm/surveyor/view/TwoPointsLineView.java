package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.model.Point;
import ar.com.jnm.surveyor.service.Service;

public class TwoPointsLineView extends AbstractView {

  public TwoPointsLineView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.print("Define p1.x coordinate: ");
    double x1 = getScanner().nextDouble();
    System.out.print("Define p1.y coordinate: ");
    double y1 = getScanner().nextDouble();
    System.out.print("Define p2.x coordinate: ");
    double x2 = getScanner().nextDouble();
    System.out.print("Define p2.y coordinate: ");
    double y2 = getScanner().nextDouble();
    getScanner().nextLine();
    System.out.println(new Point(x1, y1).getLine(new Point(x2, y2)));
  }

  @Override
  public String getDescription() {
    return "Print the line defined by two points";
  }
}
