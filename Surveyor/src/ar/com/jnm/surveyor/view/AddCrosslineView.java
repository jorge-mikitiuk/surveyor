package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Service;

public class AddCrosslineView extends AbstractView {

  public AddCrosslineView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.print("Define crossline ID: ");
    String id = getScanner().nextLine();
    System.out.print("Define landmark(1) ID: ");
    String lm1 = getScanner().nextLine();
    System.out.print("Define landmark(2) ID: ");
    String lm2 = getScanner().nextLine();
    getService().addCrossline(id, lm1, lm2);
    System.out.println("Referece added");
  }

  @Override
  public String getDescription() {
    return "Add Crossline";
  }

}
