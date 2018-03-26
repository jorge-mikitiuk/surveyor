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
    System.out.print("Ingrese la coordenada X de p1: ");
    double x1 = getScanner().nextDouble();
    System.out.print("Ingrese la coordenada Y de p1: ");
    double y1 = getScanner().nextDouble();
    System.out.print("Ingrese la coordenada X de p2: ");
    double x2 = getScanner().nextDouble();
    System.out.print("Ingrese la coordenada Y de p2: ");
    double y2 = getScanner().nextDouble();
    System.out.println(new Point(x1, y1).getLine(new Point(x2, y2)));

  }

  @Override
  public String getDescription() {
    return "Print the line defined by two points";
  }
}
