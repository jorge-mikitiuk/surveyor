package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Service;

public class DeleteCrosslineView extends AbstractView {

  public DeleteCrosslineView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.print("Define the crossline ID: ");
    String id = getScanner().nextLine();
    System.out.println(getService().removeCrossline(id) ? "Deleted crossline" : "Crossline not found");
  }

  @Override
  public String getDescription() {
    return "Delete Crossline";
  }

}
