package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Reference;
import ar.com.jnm.surveyor.service.Service;

public class PrintReferencesView extends AbstractView {

  public PrintReferencesView(Scanner scanner, Service service) {
    super(scanner, service);
  }

  @Override
  public void show() {
    System.out.println("Referencias cargadas:");
    for (Reference ref : getService().getReferences()) {
      System.out.println(ref);
    }
  }

  @Override
  public String getDescription() {
    return "Print References";
  }

}
