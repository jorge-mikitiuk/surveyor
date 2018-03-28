package ar.com.jnm.surveyor.view;

import java.util.Scanner;

import ar.com.jnm.surveyor.Application;

public class ExitView implements View {

  private Application application;

  private Scanner scanner;

  public ExitView(Application application, Scanner scanner) {
    setApplication(application);
    setScanner(scanner);
  }

  @Override
  public void show() {
    boolean saved = false;
    boolean ignoreErrors = false;

    while (!saved && !ignoreErrors) {
      try {
        getApplication().save();
        saved = true;
      } catch (Exception e) {
        System.err.println(e);
        System.out.println("Exit without save? [Y|N]");
        ignoreErrors = getScanner().nextLine().trim().startsWith("Y");
      }
    }
    getScanner().close();
    getApplication().exit();
  }

  private Application getApplication() {
    return application;
  }

  private void setApplication(Application application) {
    this.application = application;
  }

  private Scanner getScanner() {
    return scanner;
  }

  private void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public String getDescription() {
    return "Save and Exit";
  }

}
