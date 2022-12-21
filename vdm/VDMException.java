
package vdm;

public class VDMException
    extends RuntimeException {
  public VDMException() {
    super("VDM Error");
  }

  public VDMException(String msg) {
    super(msg);
  }
}
