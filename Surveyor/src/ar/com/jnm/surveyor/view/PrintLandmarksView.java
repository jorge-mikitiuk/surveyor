package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Reference;
import ar.com.jnm.surveyor.service.Service;

public class PrintLandmarksView extends AbstractView {

  public PrintLandmarksView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.println("Landmarks cargados:");
    for (Reference ref : getService().getLandmarks()) {
      System.out.println(ref);
    }
  }

  @Override
  public String getDescription() {
    return "Print Landmarks";
  }

}
