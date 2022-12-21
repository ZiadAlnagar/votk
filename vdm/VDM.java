
package vdm;

import java.util.Enumeration;

class VDM {
  public static void preTest(boolean testIn) {
    if (!testIn) {
      throw new VDMException("Pre-condition violation");
    }
  }

  public static void postTest(boolean testIn) {
    if (!testIn) {
      throw new VDMException("Post-condition violation");
    }
  }

  public static void invTest(InvariantCheck sys) {
    if (!sys.inv()) {
      throw new VDMException("Invariant violation");
    }
  }

  public static boolean implies(boolean a, boolean b) {
    return (!a) || (b);
  }

  public static boolean equivalence(boolean a, boolean b) {
    return ((!a) || (b)) && ((!b) || (a));
  }

  public static boolean forall(VDMSet set, Testable obj) {
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object x = enum1.nextElement();
      if (!obj.test(x)) {
        return false;
      }
    }
    return true;
  }

  public static boolean forall(VDMSet set, TestableInt obj) {
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object elem = enum1.nextElement();
      Integer xObj = (Integer) elem;
      int x = xObj.intValue();
      if (!obj.test(x)) {
        return false;
      }
    }
    return true;
  }

  public static boolean forall(VDMSet set, TestableDouble obj) {
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object elem = enum1.nextElement();
      Double xObj = (Double) elem;
      double x = xObj.doubleValue();
      if (!obj.test(x)) {
        return false;
      }
    }
    return true;
  }

  public static boolean forall(VDMSet set, TestableChar obj) {
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object elem = enum1.nextElement();
      Character xObj = (Character) elem;
      char x = xObj.charValue();
      if (!obj.test(x)) {
        return false;
      }
    }
    return true;
  }

  public static boolean exists(VDMSet set, Testable obj) {
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object x = enum1.nextElement();
      if (obj.test(x)) {
        return true;
      }
    }
    return false;
  }

  public static boolean exists(VDMSet set, TestableInt obj) {
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object elem = enum1.nextElement();
      Integer xObj = (Integer) elem;
      int x = xObj.intValue();
      if (obj.test(x)) {
        return true;
      }
    }
    return false;
  }

  public static boolean exists(VDMSet set, TestableDouble obj) {
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object elem = enum1.nextElement();
      Double xObj = (Double) elem;
      double x = xObj.doubleValue();
      if (obj.test(x)) {
        return true;
      }
    }
    return false;
  }

  public static boolean exists(VDMSet set, TestableChar obj) {
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object elem = enum1.nextElement();
      Character xObj = (Character) elem;
      char x = xObj.charValue();
      if (obj.test(x)) {
        return true;
      }
    }
    return false;
  }

  public static boolean uniqueExists(VDMSet set, Testable obj) {
    int total = 0;
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object x = enum1.nextElement();
      if (obj.test(x)) {
        total++;
        if (total > 1) {
          return false;
        }
      }
    }
    return total == 1;
  }

  public static boolean uniqueExists(VDMSet set, TestableInt obj) {
    int total = 0;
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object elem = enum1.nextElement();
      Integer xObj = (Integer) elem;
      int x = xObj.intValue();
      if (obj.test(x)) {
        total++;
        if (total > 1) {
          return false;
        }
      }
    }
    return total == 1;
  }

  public static boolean uniqueExists(VDMSet set, TestableDouble obj) {
    int total = 0;
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object elem = enum1.nextElement();
      Double xObj = (Double) elem;
      double x = xObj.doubleValue();
      if (obj.test(x)) {
        total++;
        if (total > 1) {
          return false;
        }
      }
    }
    return total == 1;
  }

  public static boolean uniqueExists(VDMSet set, TestableChar obj) {
    int total = 0;
    Enumeration enum1 = set.getElements();
    while (enum1.hasMoreElements()) {
      Object elem = enum1.nextElement();
      Character xObj = (Character) elem;
      char x = xObj.charValue();
      if (obj.test(x)) {
        total++;
        if (total > 1) {
          return false;
        }
      }
    }
    return total == 1;
  }
}
