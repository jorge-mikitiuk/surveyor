package ar.com.jnm.surveyor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ar.com.jnm.surveyor.repository.Repository;
import ar.com.jnm.surveyor.service.Service;
import ar.com.jnm.surveyor.view.AddCrosslineView;
import ar.com.jnm.surveyor.view.AddLandmarkView;
import ar.com.jnm.surveyor.view.CircleToCircleIntersectionView;
import ar.com.jnm.surveyor.view.CircleToLineIntersectionView;
import ar.com.jnm.surveyor.view.DeleteCrosslineView;
import ar.com.jnm.surveyor.view.DeleteLandMarkView;
import ar.com.jnm.surveyor.view.ExitView;
import ar.com.jnm.surveyor.view.MenuView;
import ar.com.jnm.surveyor.view.PrintCrosslinesView;
import ar.com.jnm.surveyor.view.PrintLandmarksView;
import ar.com.jnm.surveyor.view.PrintReferencesView;
import ar.com.jnm.surveyor.view.TwoPointsLineView;
import ar.com.jnm.surveyor.view.View;

public class Application {

  private Repository repository;

  private String db;

  public Application(String db) {
    setDb(db);
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: Surveyor DBFile.ser");
      return;
    }
    Application application = new Application(args[0]);
    Service service = application.load();

    Scanner scanner = new Scanner(System.in);
    Map<String, View> views = new HashMap<>();
    views.put("alm", new AddLandmarkView(scanner, service));
    views.put("acl", new AddCrosslineView(scanner, service));
    views.put("dcl", new DeleteCrosslineView(scanner, service));
    views.put("dlm", new DeleteLandMarkView(scanner, service));
    views.put("plm", new PrintLandmarksView(scanner, service));
    views.put("pcl", new PrintCrosslinesView(scanner, service));
    views.put("pref", new PrintReferencesView(scanner, service));
    views.put("pp", new TwoPointsLineView(scanner, service));
    views.put("cc", new CircleToCircleIntersectionView(scanner, service));
    views.put("cl", new CircleToLineIntersectionView(scanner, service));
    views.put("exit", new ExitView(application, scanner));

    MenuView menuView = new MenuView(scanner, views);
    views.put("menu", menuView);
    menuView.show();
  }

  public Service load() throws Exception {
    return new Service(getRepository());

  }

  public void save() throws Exception {
    try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(new File(getDb())))) {
      oout.writeObject(getRepository());
    }
  }

  public void exit() {
    System.exit(0);
  }

  private Repository getRepository() throws Exception {
    if (repository == null) {
      File db = new File(getDb());
      if (!db.exists()) {
        repository = new Repository();
        return repository;
      }

      try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(db))) {
        repository = (Repository) oin.readObject();
      }
    }

    return repository;
  }

  private String getDb() {
    return db;
  }

  private void setDb(String db) {
    this.db = db;
  }
}
