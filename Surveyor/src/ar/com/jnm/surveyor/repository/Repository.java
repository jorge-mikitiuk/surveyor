package ar.com.jnm.surveyor.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ar.com.jnm.surveyor.model.Line;
import ar.com.jnm.surveyor.model.Point;

public class Repository implements Serializable {

  private static final long serialVersionUID = 1111515497719022005L;

  private Map<String, Point> landmarks = new HashMap<>();

  private Map<String, Set<Line>> crossLines = new HashMap<>();

  private transient boolean dirty = false;

  public Repository() {
    super();
  }

  public Map<String, Point> getLandmarks() {
    return landmarks;
  }

  public void setLandmarks(Map<String, Point> landmarks) {
    this.landmarks = landmarks;
  }

  public void addLandmark(String name, Point point) {
    getLandmarks().put(name, point);
    markAsDirty();
  }

  public void addCrossline(String id, String lm1, String lm2) {
    getCrossline(id).add(getLine(lm1, lm2));
    markAsDirty();
  }

  private Line getLine(String lm1, String lm2) {
    Point point1 = getLandmark(lm1);
    Point point2 = getLandmark(lm2);
    Line line = point1.getLine(point2);
    return line;
  }

  private void markAsDirty() {
    setDirty(true);
  }

  public Set<Line> getCrossline(String id) {
    Set<Line> set = getCrossLines().get(id);
    if (set == null) {
      set = new TreeSet<>();
      getCrossLines().put(id, set);
      markAsDirty();
    }
    return set;
  }

  public Point getLandmark(String lm1) {
    return getLandmarks().get(lm1);
  }

  public Map<String, Set<Line>> getCrossLines() {
    return crossLines;
  }

  public void setCrossLines(Map<String, Set<Line>> crossLines) {
    this.crossLines = crossLines;
  }

  public boolean removeLandmark(String id) {
    markAsDirty();
    return getLandmarks().remove(id) != null;
  }

  public boolean removeCrossline(String id) {
    markAsDirty();
    return getCrossLines().remove(id) != null;
  }

  public boolean isDirty() {
    return dirty;
  }

  public void setDirty(boolean dirty) {
    this.dirty = dirty;
  }

}