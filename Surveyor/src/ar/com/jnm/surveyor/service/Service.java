package ar.com.jnm.surveyor.service;

import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import ar.com.jnm.surveyor.model.Line;
import ar.com.jnm.surveyor.model.Point;
import ar.com.jnm.surveyor.repository.Repository;

public class Service {

  private Repository repository;

  public Service(Repository repository) {
    setRepository(repository);
  }

  public void addLandmark(String id, double x, double y) {
    getRepository().addLandmark(id, new Point(x, y));
  }

  public void addCrossline(String id, String lm1, String lm2) {
    getRepository().getCrossline(id).add(getLine(lm1, lm2));
  }

  private Line getLine(String lm1, String lm2) {
    Point point1 = getRepository().getLandmark(lm1);
    Point point2 = getRepository().getLandmark(lm2);
    Line line = point1.getLine(point2);
    return line;
  }

  public Set<Reference> getReferences() {
    Set<Reference> references = new TreeSet<>();

    for (Entry<String, Set<Line>> crosslines : getRepository().getCrossLines().entrySet()) {
      if (crosslines.getValue().size() >= 2) {
        Set<Line> set = crosslines.getValue();
        Line[] lines = set.toArray(new Line[set.size()]);
        addReference(references, crosslines.getKey(), lines[0], lines[lines.length - 1]);
      } else {
        System.err.println("Insufficient information: " + crosslines.getKey());
      }

    }

    return references;
  }

  private void addReference(Set<Reference> references, String name, Line line, Line line2) {
    Optional<Point> intersection = line.intersection(line2);
    if (intersection.isPresent()) {
      references.add(new Reference(name, intersection.get()));
    }
  }

  private Repository getRepository() {
    return repository;
  }

  private void setRepository(Repository repository) {
    this.repository = repository;
  }

  public Set<Reference> getLandmarks() {
    Set<Reference> references = new TreeSet<>();
    for (Entry<String, Point> landmark : getRepository().getLandmarks().entrySet()) {
      references.add(new Reference(landmark.getKey(), landmark.getValue()));
    }

    return references;
  }

  public void printCrosslines() {
    for (Entry<String, Set<Line>> cl : getRepository().getCrossLines().entrySet()) {
      System.out.println("  " + cl.getKey());
      for (Line line : cl.getValue()) {
        System.out.println("    " + line);
      }
    }
  }

  public boolean removeLandmark(String id) {
    return getRepository().removeLandmark(id);
  }

  public boolean removeCrossline(String id) {
    return getRepository().removeCrossline(id);
  }
}