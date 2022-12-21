package vdm;

public class TourGroup implements InvariantCheck {

    private int ID;
    private TicketType Ticket;
    private AccessType Access;
    private TourGuide TourGuide;
    private VDMSet Tourists;
    private VDMSet GeneralVisitedTombs;
    private VDMSet SpecialVisitedTombs;

    public TourGroup(TicketType Ticket, AccessType Access, TourGuide TourGuide, VDMSet Tourists,
            VDMSet GeneralVisitedTombs, VDMSet SpecialVisitedTombs) {
        this.ID = VotK.TourGroupID;
        this.Ticket = Ticket;
        this.Access = Access;
        this.TourGuide = TourGuide;
        this.Tourists = Tourists;
        this.GeneralVisitedTombs = GeneralVisitedTombs;
        this.SpecialVisitedTombs = SpecialVisitedTombs;
        VDM.invTest(this);
    }

    public TourGuide getTourGuide() {
        return TourGuide;
    }

    public void setTourGuide(TourGuide tourGuide) {
        this.TourGuide = tourGuide;
        VDM.invTest(this);
    }

    @Override
    public boolean inv() {
        if (ID >= 0 && Tourists.card() <= 10 && Tourists.card() >= 1) {
            VotK.TourGroupID = VotK.TourGroupID + 1;
            return true;
        } else {
            return false;
        }
    }

    public int getID() {
        return this.ID;
    }

    public TicketType getTicket() {
        return this.Ticket;
    }

    public AccessType getAccess() {
        return this.Access;
    }

    public VDMSet getTourists() {
        return this.Tourists;
    }

    public VDMSet getGeneralVisitedTombs() {
        return this.GeneralVisitedTombs;
    }

    public VDMSet getSpecialVisitedTombs() {
        return this.SpecialVisitedTombs;
    }

    public void setSpecialVisitedTombs(VDMSet SpecialVisitedTombs) {
        this.SpecialVisitedTombs = SpecialVisitedTombs;
        VDM.invTest(this);
    }

    @Override
    public String toString() {
        return "{" +
                " ID='" + getID() + "'" +
                ", Ticket='" + getTicket() + "'" +
                ", Access='" + getAccess() + "'" +
                ", TourGuide='" + getTourGuide() + "'" +
                ", Tourists='" + getTourists() + "'" +
                ", GeneralVisitedTombs='" + getGeneralVisitedTombs() + "'" +
                ", SpecialVisitedTombs='" + getSpecialVisitedTombs() + "'" +
                "}";
    }

}
