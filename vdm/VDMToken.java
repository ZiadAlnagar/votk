
package vdm;

class VDMToken {
  private String value;

  public VDMToken(String valueIn) {
    this.value = valueIn;
  }

  public boolean equals(Object objIn) {
    VDMToken valueIn = (VDMToken) objIn;
    return this.value.equals(valueIn.value);
  }

  public String toString() {
    return this.value;
  }

  public int hashCode() {
    return this.value.hashCode();
  }
}
