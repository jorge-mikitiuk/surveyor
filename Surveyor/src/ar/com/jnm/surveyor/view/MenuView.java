package ar.com.jnm.surveyor.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class MenuView implements View {

  private Scanner scanner;

  private Map<String, View> views;

  public MenuView(Scanner scanner) {
    this(scanner, new HashMap<>());
  }

  public MenuView(Scanner scanner, Map<String, View> views) {
    setScanner(scanner);
    setViews(views);
  }

  @Override
  public void show() {
    showOptions();

    while (true) {
      String option = getScanner().nextLine();
      View view = getViews().get(option);
      if (view != null) {
        view.show();
      } else {
        System.out.println("Command not found");
      }
    }

  }

  private void showOptions() {
    System.out.println("Menú:");

    for (String id : new TreeSet<>(getViews().keySet())) {
      System.out.printf("%1$6s: %2$s\n", id, getViews().get(id).getDescription());
    }
  }

  private Scanner getScanner() {
    return scanner;
  }

  private void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }

  private Map<String, View> getViews() {
    return views;
  }

  private void setViews(Map<String, View> views) {
    this.views = views;
  }

  @Override
  public String getDescription() {
    return "Menu";
  }
}
