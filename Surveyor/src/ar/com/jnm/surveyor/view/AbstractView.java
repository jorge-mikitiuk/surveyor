package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.service.Service;

public abstract class AbstractView implements View {

  private Service service;

  private Scanner scanner;

  public AbstractView(Scanner scanner, Service service) {
    setScanner(scanner);
    setService(service);
  }

  public Service getService() {
    return service;
  }

  private void setService(Service service) {
    this.service = service;
  }

  public Scanner getScanner() {
    return scanner;
  }

  private void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }

}