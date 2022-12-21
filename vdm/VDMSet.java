
package vdm;

import java.util.Enumeration;
import java.util.Vector;

class VDMSet {
  Vector theSet;

  public VDMSet() {
    this.theSet = new Vector();
  }

  public VDMSet(Object[] elementsIn) {
    this.theSet = new Vector();
    if (elementsIn.length > 0) {
      for (int i = 0; i < elementsIn.length; i++) {
        this.theSet.addElement(elementsIn[i]);
        insert(elementsIn[i]);
      }
    }
  }

  public VDMSet(int[] elementsIn) {
    this.theSet = new Vector();
    if (elementsIn.length > 0) {
      for (int i = 0; i < elementsIn.length; i++) {
        insert(new Integer(elementsIn[i]));
      }
    }
  }

  public VDMSet(double[] elementsIn) {
    this.theSet = new Vector();
    if (elementsIn.length > 0) {
      for (int i = 0; i < elementsIn.length; i++) {
        insert(new Double(elementsIn[i]));
      }
    }
  }

  public VDMSet(char[] elementsIn) {
    this.theSet = new Vector();
    if (elementsIn.length > 0) {
      for (int i = 0; i < elementsIn.length; i++) {
        insert(new Character(elementsIn[i]));
      }
    }
  }

  public VDMSet(Object elementIn) {
    this.theSet = new Vector();
    this.theSet.add(elementIn);
  }

  public VDMSet(int elementIn) {
    this.theSet = new Vector();
    this.theSet.add(new Integer(elementIn));
  }

  public VDMSet(double elementIn) {
    this.theSet = new Vector();
    this.theSet.add(new Double(elementIn));
  }

  public VDMSet(char elementIn) {
    this.theSet = new Vector();
    this.theSet.add(new Character(elementIn));
  }

  public VDMSet(int i, int j) {
    this.theSet = new Vector();
    for (; i <= j; i++) {
      insert(new Integer(i));
    }
  }

  public static VDMSet setComp(Expression e, VDMSet setIn, Testable t) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object x = enum1.nextElement();
      if (t.test(x)) {
        newSet.insert(e.action(x));
      }
    }
    return newSet;
  }

  public static VDMSet setComp(ExpressionInt e, VDMSet setIn, TestableInt t) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object x = enum1.nextElement();
      int y = ((Integer) x).intValue();
      if (t.test(y)) {
        newSet.insert(e.action(y));
      }
    }
    return newSet;
  }

  public static VDMSet setComp(ExpressionDouble e, VDMSet setIn, TestableDouble t) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object x = enum1.nextElement();
      double y = ((Double) x).doubleValue();
      if (t.test(y)) {
        newSet.insert(e.action(y));
      }
    }
    return newSet;
  }

  public static VDMSet setComp(ExpressionChar e, VDMSet setIn, TestableChar t) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object x = enum1.nextElement();
      char y = ((Character) x).charValue();
      if (t.test(y)) {
        newSet.insert(e.action(y));
      }
    }
    return newSet;
  }

  public static VDMSet setComp(VDMSet setIn, Testable t) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object x = enum1.nextElement();
      if (t.test(x)) {
        newSet.insert(x);
      }
    }
    return newSet;
  }

  public static VDMSet setComp(VDMSet setIn, TestableInt t) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object element = enum1.nextElement();
      Integer elementInt = (Integer) element;
      int x = elementInt.intValue();
      if (t.test(x)) {
        newSet.insert(elementInt);
      }
    }
    return newSet;
  }

  public static VDMSet setComp(VDMSet setIn, TestableDouble t) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object element = enum1.nextElement();
      Double elementInt = (Double) element;
      double x = elementInt.doubleValue();
      if (t.test(x)) {
        newSet.insert(elementInt);
      }
    }
    return newSet;
  }

  public static VDMSet setComp(VDMSet setIn, TestableChar t) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object element = enum1.nextElement();
      Character elementInt = (Character) element;
      char x = elementInt.charValue();
      if (t.test(x)) {
        newSet.insert(elementInt);
      }
    }
    return newSet;
  }

  public static VDMSet setComp(Expression e, VDMSet setIn) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object x = enum1.nextElement();
      newSet.insert(e.action(x));
    }
    return newSet;
  }

  public static VDMSet setComp(ExpressionInt e, VDMSet setIn) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object element = enum1.nextElement();
      Integer elementInt = (Integer) element;
      int x = elementInt.intValue();
      newSet.insert(e.action(x));
    }
    return newSet;
  }

  public static VDMSet setComp(ExpressionDouble e, VDMSet setIn) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object element = enum1.nextElement();
      Double elementInt = (Double) element;
      double x = elementInt.doubleValue();
      newSet.insert(e.action(x));
    }
    return newSet;
  }

  public static VDMSet setComp(ExpressionChar e, VDMSet setIn) {
    VDMSet newSet = new VDMSet();
    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object element = enum1.nextElement();
      Character elementInt = (Character) element;
      char x = elementInt.charValue();
      newSet.insert(e.action(x));
    }
    return newSet;
  }

  public int card() {
    return this.theSet.size();
  }

  public VDMSet union(VDMSet setIn) {
    VDMSet set2 = new VDMSet();
    Enumeration enum1 = getElements();
    Enumeration enumIn = setIn.getElements();
    while (enum1.hasMoreElements()) {
      set2.insert(enum1.nextElement());
    }
    while (enumIn.hasMoreElements()) {
      set2.insert(enumIn.nextElement());
    }
    return set2;
  }

  public VDMSet intersection(VDMSet setIn) {
    VDMSet set2 = new VDMSet();

    Enumeration enum1 = setIn.getElements();
    while (enum1.hasMoreElements()) {
      Object temp = enum1.nextElement();
      if (contains(temp)) {
        set2.insert(temp);
      }
    }
    return set2;
  }

  public VDMSet difference(VDMSet setIn) {
    VDMSet set2 = new VDMSet();

    Enumeration enum1 = getElements();
    while (enum1.hasMoreElements()) {
      Object temp = enum1.nextElement();
      if (!setIn.contains(temp)) {
        set2.insert(temp);
      }
    }
    return set2;
  }

  public boolean contains(Object elementIn) {
    return this.theSet.contains(elementIn);
  }

  public boolean contains(int elementIn) {
    return this.theSet.contains(new Integer(elementIn));
  }

  public boolean contains(double elementIn) {
    return this.theSet.contains(new Double(elementIn));
  }

  public boolean contains(char elementIn) {
    return this.theSet.contains(new Character(elementIn));
  }

  public boolean doesNotContain(Object elementIn) {
    return !this.theSet.contains(elementIn);
  }

  public boolean doesNotContain(int elementIn) {
    return !this.theSet.contains(new Integer(elementIn));
  }

  public boolean doesNotContain(double elementIn) {
    return !this.theSet.contains(new Double(elementIn));
  }

  public boolean doesNotContain(char elementIn) {
    return !this.theSet.contains(new Character(elementIn));
  }

  public boolean isASubsetOf(VDMSet setIn) {
    Enumeration enum1 = getElements();
    while (enum1.hasMoreElements()) {
      if (!setIn.contains(enum1.nextElement())) {
        return false;
      }
    }
    return true;
  }

  public boolean isAProperSubsetOf(VDMSet setIn) {
    if (setIn.card() == card()) {
      return false;
    }
    Enumeration enum1 = getElements();
    while (enum1.hasMoreElements()) {
      if (!setIn.contains(enum1.nextElement())) {
        return false;
      }
    }
    return true;
  }

  public Enumeration getElements() {
    return this.theSet.elements();
  }

  public boolean isEmpty() {
    return card() == 0;
  }

  public String toString() {
    String setOut = "{";
    Enumeration enum1 = getElements();
    if (enum1.hasMoreElements()) {
      setOut = String.valueOf(setOut).concat(String.valueOf(enum1.nextElement()));
    }
    while (enum1.hasMoreElements()) {
      setOut = String.valueOf(String.valueOf(setOut).concat(String.valueOf(", ")))
          .concat(String.valueOf(enum1.nextElement()));
    }
    setOut = String.valueOf(setOut).concat(String.valueOf("}"));
    return setOut;
  }

  public boolean equals(VDMSet setIn) {
    if ((isASubsetOf(setIn)) && (setIn.isASubsetOf(this))) {
      return true;
    }
    return false;
  }

  public Object clone() {
    VDMSet set = new VDMSet();
    Enumeration enum1 = getElements();
    while (enum1.hasMoreElements()) {
      set = set.union(new VDMSet(enum1.nextElement()));
    }
    return set;
  }

  public Object chooseElement()
      throws VDMException {
    if (card() > 0) {
      return this.theSet.elementAt(0);
    }
    throw new VDMException("cannot choose element from an empty set");
  }

  public int chooseIntElement()
      throws VDMException {
    if (card() > 0) {
      Object item = this.theSet.elementAt(0);
      Integer x = (Integer) item;
      return x.intValue();
    }
    throw new VDMException("cannot choose element from an empty set");
  }

  public double chooseDoubleElement()
      throws VDMException {
    if (card() > 0) {
      Object item = this.theSet.elementAt(0);
      Double x = (Double) item;
      return x.doubleValue();
    }
    throw new VDMException("cannot choose element from an empty set");
  }

  public char chooseCharElement()
      throws VDMException {
    if (card() > 0) {
      Object item = this.theSet.elementAt(0);
      Character x = (Character) item;
      return x.charValue();
    }
    throw new VDMException("cannot choose element from an empty set");
  }

  private void insert(Object elementIn) {
    if (!this.theSet.contains(elementIn)) {
      this.theSet.add(elementIn);
    }
  }
}
