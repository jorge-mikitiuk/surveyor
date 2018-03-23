package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Service;

public class AddCrosslineView extends AbstractView {

  public AddCrosslineView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.print("Ingrese el ID del crossline: ");
    String id = getScanner().nextLine();
    System.out.print("Ingrese el ID del landmark(1): ");
    String lm1 = getScanner().nextLine();
    System.out.print("Ingrese el ID del landmark(2): ");
    String lm2 = getScanner().nextLine();
    getService().addCrossline(id, lm1, lm2);
    System.out.println("Referencia ingresada");
  }

  @Override
  public String getDescription() {
    return "Add Crossline";
  }

}
