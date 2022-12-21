package vdm;

public class VisitorGroup implements InvariantCheck {
    private int ID;
    private VDMSequence Tourist;
    private VDMSequence TourGuide;

    public VisitorGroup(VDMSequence Tourist, VDMSequence TourGuide) {
        this.ID = VotK.VisitorGroupID;
        this.Tourist = Tourist;
        this.TourGuide = TourGuide;
        VDM.invTest(this);
    }

    @Override
    public boolean inv() {
        if (Tourist.len() >= 1 && Tourist.len() <= 20 && TourGuide.len() >= 0 && TourGuide.len() <= 2 && ID >= 0) {
            VotK.VisitorGroupID = VotK.VisitorGroupID + 1;
            return true;
        } else {
            return false;
        }
    }

    public VDMSequence getTourist() {
        return Tourist;
    }

    public VDMSequence getTourGuide() {
        return TourGuide;
    }

    @Override
    public String toString() {
        return "{" + "Tour Group:" + "ID=" + ID + ", Tourist=" + Tourist + ", TourGuide=" + TourGuide + '\n';
    }

}
