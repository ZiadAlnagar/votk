package vdm;

public class TourGuide implements InvariantCheck {
    private int ID;
    private WorkingStatus Available;

    public TourGuide(WorkingStatus Available) {
        this.ID = VotK.TourGuideID;
        this.Available = Available;
        VDM.invTest(this);
    }

    public void setWorkingStatus(WorkingStatus Available) {
        this.Available = Available;
        VDM.invTest(this);
    }

    public WorkingStatus getAvailable() {
        return this.Available;
    }

    @Override
    public boolean inv() {
        if (ID >= 0) {
            VotK.TourGuideID = VotK.TourGuideID + 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "{" +
                " ID='" + getID() + "'" +
                ", Available='" + getAvailable() + "'" +
                "}";
    }

    public int getID() {
        return this.ID;
    }

}
