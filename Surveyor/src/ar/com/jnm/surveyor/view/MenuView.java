package ar.com.jnm.surveyor.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

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
      }
    }

  }

  private void showOptions() {
    System.out.println("Menú:");
    for (Entry<String, View> view : getViews().entrySet()) {
      System.out.println(view.getKey() + ": " + view.getValue().getDescription());
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
    return "Menú";
  }
}
