
package vdm;

import java.util.Enumeration;
import java.util.Hashtable;

class VDMMap {
  private Hashtable theMap;

  public VDMMap() {
    this.theMap = new Hashtable();
  }

  public VDMMap(Maplet mapletIn) {
    this.theMap = new Hashtable();
    insert(mapletIn);
  }

  public VDMMap(Maplet[] elementsIn) {
    this.theMap = new Hashtable();
    if (elementsIn.length > 0) {
      for (int i = 0; i < elementsIn.length; i++) {
        insert(elementsIn[i]);
      }
    }
  }

  public Object applyTo(Object domainElementIn) {
    Object rangeElementOut = this.theMap.get(domainElementIn);
    if (rangeElementOut == null) {
      throw new VDMException();
    }
    return rangeElementOut;
  }

  public Object applyTo(int domainElementIn) {
    Object rangeElementOut = this.theMap.get(new Integer(domainElementIn));
    if (rangeElementOut == null) {
      throw new VDMException();
    }
    return rangeElementOut;
  }

  public Object applyTo(char domainElementIn) {
    Object rangeElementOut = this.theMap.get(new Character(domainElementIn));
    if (rangeElementOut == null) {
      throw new VDMException();
    }
    return rangeElementOut;
  }

  public Object applyTo(double domainElementIn) {
    Object rangeElementOut = this.theMap.get(new Double(domainElementIn));
    if (rangeElementOut == null) {
      throw new VDMException();
    }
    return rangeElementOut;
  }

  public VDMSet dom() {
    VDMSet set = new VDMSet();
    Enumeration enum1 = this.theMap.keys();
    while (enum1.hasMoreElements()) {
      set = set.union(new VDMSet(enum1.nextElement()));
    }
    return set;
  }

  public VDMSet rng() {
    VDMSet set = new VDMSet();
    Enumeration enum1 = this.theMap.elements();
    while (enum1.hasMoreElements()) {
      set = set.union(new VDMSet(enum1.nextElement()));
    }
    return set;
  }

  public VDMMap override(VDMMap mapIn) {
    VDMMap map = (VDMMap) clone();
    Enumeration enum1 = mapIn.theMap.keys();
    while (enum1.hasMoreElements()) {
      Object domElement = enum1.nextElement();
      Maplet maplet = new Maplet(domElement, mapIn.applyTo(domElement));
      map.insert(maplet);
    }
    return map;
  }

  public VDMMap union(VDMMap mapIn) {
    VDMMap map = (VDMMap) clone();
    Enumeration enum1 = mapIn.theMap.keys();
    while (enum1.hasMoreElements()) {
      Object domElement = enum1.nextElement();
      Maplet maplet = new Maplet(domElement, mapIn.applyTo(domElement));
      Object obj = map.insert(maplet);
      if (obj != null) {
        throw new VDMException("Union undefined when maps contain duplicate domain elements");
      }
    }
    return map;
  }

  public VDMMap domRestrict(VDMSet setIn) {
    VDMMap map = (VDMMap) clone();
    Enumeration enum1 = this.theMap.keys();
    while (enum1.hasMoreElements()) {
      Object obj = enum1.nextElement();
      if (!setIn.contains(obj)) {
        map.theMap.remove(obj);
      }
    }
    return map;
  }

  public VDMMap domDelete(VDMSet setIn) {
    VDMMap map = (VDMMap) clone();
    Enumeration enum1 = this.theMap.keys();
    while (enum1.hasMoreElements()) {
      Object obj = enum1.nextElement();
      if (setIn.contains(obj)) {
        map.theMap.remove(obj);
      }
    }
    return map;
  }

  public VDMMap rangeRestrict(VDMSet setIn) {
    VDMMap map = (VDMMap) clone();
    Enumeration enum1 = this.theMap.keys();
    while (enum1.hasMoreElements()) {
      Object obj = enum1.nextElement();
      if (!setIn.contains(applyTo(obj))) {
        map.theMap.remove(obj);
      }
    }
    return map;
  }

  public VDMMap rangeDelete(VDMSet setIn) {
    VDMMap map = (VDMMap) clone();
    Enumeration enum1 = this.theMap.keys();
    while (enum1.hasMoreElements()) {
      Object obj = enum1.nextElement();
      if (setIn.contains(applyTo(obj))) {
        map.theMap.remove(obj);
      }
    }
    return map;
  }

  public String toString() {
    String mapOut = "{";
    Enumeration enum1 = this.theMap.keys();
    if (enum1.hasMoreElements()) {
      Object domElement = enum1.nextElement();
      Object rangeElement = this.theMap.get(domElement);
      mapOut = String
          .valueOf(
              String.valueOf(String.valueOf(mapOut).concat(String.valueOf(domElement))).concat(String.valueOf(" |-> ")))
          .concat(String.valueOf(rangeElement));
    }
    while (enum1.hasMoreElements()) {
      Object domElement = enum1.nextElement();
      Object rangeElement = this.theMap.get(domElement);
      mapOut = String.valueOf(String
          .valueOf(
              String.valueOf(String.valueOf(mapOut).concat(String.valueOf(", "))).concat(String.valueOf(domElement)))
          .concat(String.valueOf(" |-> "))).concat(String.valueOf(rangeElement));
    }
    mapOut = String.valueOf(mapOut).concat(String.valueOf("}"));
    return mapOut;
  }

  public Enumeration getDomainElements() {
    return this.theMap.keys();
  }

  public Enumeration getRangeElements() {
    return this.theMap.elements();
  }

  public boolean isEmpty() {
    return this.theMap.isEmpty();
  }

  public boolean equals(Object objectIn) {
    VDMMap map = (VDMMap) objectIn;
    return this.theMap.equals(map.theMap);
  }

  private Object insert(Maplet mapletIn) {
    Object obj = this.theMap.put(mapletIn.getDomainElement(), mapletIn.getRangeElement());
    return obj;
  }

  public Object clone() {
    VDMMap map = new VDMMap();
    Enumeration enum1 = this.theMap.keys();
    while (enum1.hasMoreElements()) {
      Object domElement = enum1.nextElement();
      Maplet maplet = new Maplet(domElement, applyTo(domElement));
      map.insert(maplet);
    }
    return map;
  }
}
