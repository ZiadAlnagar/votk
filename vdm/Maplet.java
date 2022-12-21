
package vdm;

class Maplet {
  private Object domainElement;
  private Object rangeElement;

  public Maplet(Object domainIn, Object rangeIn) {
    this.domainElement = domainIn;
    this.rangeElement = rangeIn;
  }

  public Maplet(Object domainIn, int rangeIn) {
    this.domainElement = domainIn;
    this.rangeElement = new Integer(rangeIn);
  }

  public Maplet(Object domainIn, char rangeIn) {
    this.domainElement = domainIn;
    this.rangeElement = new Character(rangeIn);
  }

  public Maplet(Object domainIn, double rangeIn) {
    this.domainElement = domainIn;
    this.rangeElement = new Double(rangeIn);
  }

  public Maplet(int domainIn, Object rangeIn) {
    this.domainElement = new Integer(domainIn);
    this.rangeElement = rangeIn;
  }

  public Maplet(int domainIn, int rangeIn) {
    this.domainElement = new Integer(domainIn);
    this.rangeElement = new Integer(rangeIn);
  }

  public Maplet(int domainIn, char rangeIn) {
    this.domainElement = new Integer(domainIn);
    this.rangeElement = new Character(rangeIn);
  }

  public Maplet(int domainIn, double rangeIn) {
    this.domainElement = new Integer(domainIn);
    this.rangeElement = new Double(rangeIn);
  }

  public Maplet(char domainIn, Object rangeIn) {
    this.domainElement = new Character(domainIn);
    this.rangeElement = rangeIn;
  }

  public Maplet(char domainIn, int rangeIn) {
    this.domainElement = new Character(domainIn);
    this.rangeElement = new Integer(rangeIn);
  }

  public Maplet(char domainIn, char rangeIn) {
    this.domainElement = new Character(domainIn);
    this.rangeElement = new Character(rangeIn);
  }

  public Maplet(char domainIn, double rangeIn) {
    this.domainElement = new Character(domainIn);
    this.rangeElement = new Double(rangeIn);
  }

  public Maplet(double domainIn, Object rangeIn) {
    this.domainElement = new Double(domainIn);
    this.rangeElement = rangeIn;
  }

  public Maplet(double domainIn, int rangeIn) {
    this.domainElement = new Double(domainIn);
    this.rangeElement = new Integer(rangeIn);
  }

  public Maplet(double domainIn, char rangeIn) {
    this.domainElement = new Double(domainIn);
    this.rangeElement = new Character(rangeIn);
  }

  public Maplet(double domainIn, double rangeIn) {
    this.domainElement = new Double(domainIn);
    this.rangeElement = new Double(rangeIn);
  }

  public Object getDomainElement() {
    return this.domainElement;
  }

  public Object getRangeElement() {
    return this.rangeElement;
  }

  public String toString() {
    return String.valueOf(
        String.valueOf(String.valueOf("").concat(String.valueOf(this.domainElement))).concat(String.valueOf(" |-> ")))
        .concat(String.valueOf(this.rangeElement));
  }
}
