package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Service;

public class AddLandmarkView extends AbstractView {

  public AddLandmarkView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.print("Ingrese el ID del landmark:");
    String id = getScanner().nextLine();
    System.out.print("Ingrese la coordenada X:");
    double x = getScanner().nextDouble();
    System.out.print("Ingrese la coordenada Y:");
    double y = getScanner().nextDouble();
    getService().addLandmark(id, x, y);
    System.out.println("Referencia ingresada");
  }

  @Override
  public String getDescription() {
    return "Add Landmark";
  }

}
