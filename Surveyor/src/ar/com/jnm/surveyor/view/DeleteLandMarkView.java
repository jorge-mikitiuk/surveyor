package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Service;

public class DeleteLandMarkView extends AbstractView {

  public DeleteLandMarkView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.print("Define the landmark ID:");
    String id = getScanner().nextLine();
    System.out.println(getService().removeLandmark(id) ? "Landmark deleted" : "Landmark not found");
  }

  @Override
  public String getDescription() {
    return "Delete Landmark";
  }
}
