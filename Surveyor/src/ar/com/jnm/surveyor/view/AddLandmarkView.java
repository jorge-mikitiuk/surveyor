package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Service;

public class AddLandmarkView extends AbstractView {

  public AddLandmarkView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.print("Defina landmark ID:");
    String id = getScanner().nextLine();
    System.out.print("Define x coordinate:");
    double x = getScanner().nextDouble();
    System.out.print("Defina y coordinate:");
    double y = getScanner().nextDouble();
    getService().addLandmark(id, x, y);
    System.out.println("Reference added");
  }

  @Override
  public String getDescription() {
    return "Add Landmark";
  }

}
