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
  }

  public Set<Line> getCrossline(String id) {
    Set<Line> set = getCrossLines().get(id);
    if (set == null) {
      set = new TreeSet<>();
      getCrossLines().put(id, set);
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

}