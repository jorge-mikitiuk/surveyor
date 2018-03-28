package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Service;

public class PrintCrosslinesView extends AbstractView {

  public PrintCrosslinesView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    getService().printCrosslines();
  }

  @Override
  public String getDescription() {
    return "Prints the crossline data";
  }
}
