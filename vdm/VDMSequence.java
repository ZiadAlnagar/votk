
package vdm;

import java.util.Enumeration;
import java.util.Vector;

class VDMSequence {
  Vector theSequence;

  public VDMSequence() {
    this.theSequence = new Vector();
  }

  public VDMSequence(Object[] elementsIn) {
    this.theSequence = new Vector();
    if (elementsIn.length > 0) {
      for (int i = 0; i < elementsIn.length; i++) {
        this.theSequence.add(elementsIn[i]);
      }
    }
  }

  public VDMSequence(int[] elementsIn) {
    this.theSequence = new Vector();
    if (elementsIn.length > 0) {
      for (int i = 0; i < elementsIn.length; i++) {
        this.theSequence.add(new Integer(elementsIn[i]));
      }
    }
  }

  public VDMSequence(double[] elementsIn) {
    this.theSequence = new Vector();
    if (elementsIn.length > 0) {
      for (int i = 0; i < elementsIn.length; i++) {
        this.theSequence.add(new Double(elementsIn[i]));
      }
    }
  }

  public VDMSequence(char[] elementsIn) {
    this.theSequence = new Vector();
    if (elementsIn.length > 0) {
      for (int i = 0; i < elementsIn.length; i++) {
        this.theSequence.add(new Character(elementsIn[i]));
      }
    }
  }

  public VDMSequence(Object elementIn) {
    this.theSequence = new Vector();
    this.theSequence.add(elementIn);
  }

  public VDMSequence(int elementIn) {
    this.theSequence = new Vector();
    this.theSequence.add(new Integer(elementIn));
  }

  public VDMSequence(double elementIn) {
    this.theSequence = new Vector();
    this.theSequence.add(new Double(elementIn));
  }

  public VDMSequence(char elementIn) {
    this.theSequence = new Vector();
    this.theSequence.add(new Character(elementIn));
  }

  public static VDMSequence sequenceComp(VDMSet setIn, TestableInt t) {
    VDMSequence newSequence = new VDMSequence();
    int[] list = sortInt(setIn);
    for (int i = 0; i < list.length; i++) {
      if (t.test(list[i])) {
        newSequence.theSequence.add(new Integer(list[i]));
      }
    }
    return newSequence;
  }

  public static VDMSequence sequenceComp(ExpressionInt e, VDMSet setIn) {
    VDMSequence newSequence = new VDMSequence();
    int[] list = sortInt(setIn);
    for (int i = 0; i < list.length; i++) {
      newSequence.theSequence.add(e.action(list[i]));
    }
    return newSequence;
  }

  public static VDMSequence sequenceComp(ExpressionInt e, VDMSet setIn, TestableInt t) {
    VDMSequence newSequence = new VDMSequence();
    int[] list = sortInt(setIn);
    for (int i = 0; i < list.length; i++) {
      if (t.test(list[i])) {
        newSequence.theSequence.add(e.action(list[i]));
      }
    }
    return newSequence;
  }

  public static VDMSequence sequenceComp(VDMSet setIn, TestableChar t) {
    VDMSequence newSequence = new VDMSequence();
    char[] list = sortChar(setIn);
    for (int i = 0; i < list.length; i++) {
      if (t.test(list[i])) {
        newSequence.theSequence.add(new Character(list[i]));
      }
    }
    return newSequence;
  }

  public static VDMSequence sequenceComp(ExpressionChar e, VDMSet setIn) {
    VDMSequence newSequence = new VDMSequence();
    char[] list = sortChar(setIn);
    for (int i = 0; i < list.length; i++) {
      newSequence.theSequence.add(e.action(list[i]));
    }
    return newSequence;
  }

  public static VDMSequence sequenceComp(ExpressionChar e, VDMSet setIn, TestableChar t) {
    VDMSequence newSequence = new VDMSequence();
    char[] list = sortChar(setIn);
    for (int i = 0; i < list.length; i++) {
      if (t.test(list[i])) {
        newSequence.theSequence.add(e.action(list[i]));
      }
    }
    return newSequence;
  }

  public static VDMSequence sequenceComp(VDMSet setIn, TestableDouble t) {
    VDMSequence newSequence = new VDMSequence();
    double[] list = sortDouble(setIn);
    for (int i = 0; i < list.length; i++) {
      if (t.test(list[i])) {
        newSequence.theSequence.add(new Double(list[i]));
      }
    }
    return newSequence;
  }

  public static VDMSequence sequenceComp(ExpressionDouble e, VDMSet setIn) {
    VDMSequence newSequence = new VDMSequence();
    double[] list = sortDouble(setIn);
    for (int i = 0; i < list.length; i++) {
      newSequence.theSequence.add(e.action(list[i]));
    }
    return newSequence;
  }

  public static VDMSequence sequenceComp(ExpressionDouble e, VDMSet setIn, TestableDouble t) {
    VDMSequence newSequence = new VDMSequence();
    double[] list = sortDouble(setIn);
    for (int i = 0; i < list.length; i++) {
      if (t.test(list[i])) {
        newSequence.theSequence.add(e.action(list[i]));
      }
    }
    return newSequence;
  }

  public int len() {
    return this.theSequence.size();
  }

  public VDMSet elems() {
    VDMSet set = new VDMSet();
    for (int i = 0; i < this.theSequence.size(); i++) {
      set = set.union(new VDMSet(this.theSequence.elementAt(i)));
    }
    return set;
  }

  public VDMSequence concat(VDMSequence seqIn) {
    VDMSequence seq = new VDMSequence(this.theSequence.toArray());
    for (int i = 0; i < seqIn.len(); i++) {
      seq.theSequence.add(seqIn.theSequence.get(i));
    }
    return seq;
  }

  public VDMSequence override(VDMMap mapIn) {
    VDMSequence seq = new VDMSequence(this.theSequence.toArray());
    Enumeration domElements = mapIn.getDomainElements();
    Enumeration rangeElements = mapIn.getRangeElements();
    while (domElements.hasMoreElements()) {
      Integer index = (Integer) domElements.nextElement();
      Object element = rangeElements.nextElement();
      if ((index.intValue() < 1) || (index.intValue() > len())) {
        throw new VDMException("Invalid Index");
      }
      seq.theSequence.setElementAt(element, index.intValue() - 1);
    }
    return seq;
  }

  public Object hd() {
    if (len() == 0) {
      throw new VDMException("The sequence is empty");
    }
    return this.theSequence.elementAt(0);
  }

  public VDMSequence tl() {
    VDMSequence seq = new VDMSequence();
    if (len() == 0) {
      throw new VDMException("The sequence is empty");
    }
    for (int i = 1; i < len(); i++) {
      seq.theSequence.add(this.theSequence.elementAt(i));
    }
    return seq;
  }

  public VDMSet inds() {
    VDMSet set = new VDMSet();
    for (int i = 1; i <= len(); i++) {
      set = set.union(new VDMSet(i));
    }
    return set;
  }

  public VDMSequence subseq(int index1, int index2) {
    VDMSequence seq = new VDMSequence();
    if (((index1 == 1) && (index2 == 0)) || ((index1 == len() + 1) && (index2 == len()))) {
      return seq;
    }
    if ((index2 < index1) || (index1 < 1) || (index2 > len())) {
      throw new VDMException("invalid indices");
    }
    for (int i = index1; i <= index2; i++) {
      seq.theSequence.addElement(this.theSequence.elementAt(i - 1));
    }
    return seq;
  }

  public Object index(int indexIn) {
    if ((indexIn < 1) || (indexIn > len())) {
      throw new VDMException("invalid index");
    }
    return this.theSequence.elementAt(indexIn - 1);
  }

  public Enumeration getElements() {
    return this.theSequence.elements();
  }

  public boolean isEmpty() {
    return len() == 0;
  }

  public String toString() {
    return this.theSequence.toString();
  }

  public boolean equals(VDMSequence sequenceIn) {
    return this.theSequence.equals(sequenceIn.theSequence);
  }

  private static int[] sortInt(VDMSet setIn) {
    int length = setIn.card();
    int j = 0;

    boolean finished = false;
    Enumeration enum1 = setIn.getElements();

    int[] array = new int[length];
    while (enum1.hasMoreElements()) {
      Integer element = (Integer) enum1.nextElement();
      array[j] = element.intValue();
      j++;
    }
    while (!finished) {
      finished = true;
      for (int i = 0; i <= length - 2; i++) {
        if (array[i] > array[(i + 1)]) {
          int temp = array[i];
          array[i] = array[(i + 1)];
          array[(i + 1)] = temp;
          finished = false;
        }
      }
    }
    return array;
  }

  private static char[] sortChar(VDMSet setIn) {
    int length = setIn.card();
    int j = 0;

    boolean finished = false;
    Enumeration enum1 = setIn.getElements();

    char[] array = new char[length];
    while (enum1.hasMoreElements()) {
      Character element = (Character) enum1.nextElement();
      array[j] = element.charValue();
      j++;
    }
    while (!finished) {
      finished = true;
      for (int i = 0; i <= length - 2; i++) {
        if (array[i] > array[(i + 1)]) {
          char temp = array[i];
          array[i] = array[(i + 1)];
          array[(i + 1)] = temp;
          finished = false;
        }
      }
    }
    return array;
  }

  private static double[] sortDouble(VDMSet setIn) {
    int length = setIn.card();
    int j = 0;

    boolean finished = false;
    Enumeration enum1 = setIn.getElements();

    double[] array = new double[length];
    while (enum1.hasMoreElements()) {
      Double element = (Double) enum1.nextElement();
      array[j] = element.doubleValue();
      j++;
    }
    while (!finished) {
      finished = true;
      for (int i = 0; i <= length - 2; i++) {
        if (array[i] > array[(i + 1)]) {
          double temp = array[i];
          array[i] = array[(i + 1)];
          array[(i + 1)] = temp;
          finished = false;
        }
      }
    }
    return array;
  }

  public boolean equals(Object objectIn) {
    VDMSequence seq = (VDMSequence) objectIn;
    return this.theSequence.equals(seq.theSequence);
  }

  public Object clone() {
    VDMSequence seq = new VDMSequence();
    Enumeration enum1 = getElements();
    while (enum1.hasMoreElements()) {
      seq = seq.concat(new VDMSequence(enum1.nextElement()));
    }
    return seq;
  }
}
