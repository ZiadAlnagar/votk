package vdm;

public class Tomb implements InvariantCheck {
    private TombList Name;
    private AccessType Type;
    private TombStatus Status;
    private int MaximumCapacity;
    private int CurrentCapacity;
    private int MaximumHumidity;
    private int CurrentHumidity;
    private boolean Maintenance;
    private VDMSet TotalTourGroup;
    private VDMSet TourGroupInTomb;
    private VDMSequence Waitingtourgroup;
    private VDMSet WaitingTourGuides;

    public Tomb(TombList Name, AccessType Type, TombStatus Status, int MaximumCapacity, int CurrentCapacity,
            int MaximumHumidity, int CurrentHumidity, boolean Maintenance, VDMSet TotalTourGroup,
            VDMSet TourGroupInTomb,
            VDMSequence Waitingtourgroup, VDMSet WaitingTourGuides) {
        this.Name = Name;
        this.Type = Type;
        this.Status = Status;
        this.MaximumCapacity = MaximumCapacity;
        this.CurrentCapacity = CurrentCapacity;
        this.MaximumHumidity = MaximumHumidity;
        this.CurrentHumidity = CurrentHumidity;
        this.Maintenance = Maintenance;
        this.TotalTourGroup = TotalTourGroup;
        this.TourGroupInTomb = TourGroupInTomb;
        this.Waitingtourgroup = Waitingtourgroup;
        this.WaitingTourGuides = WaitingTourGuides;
        VDM.invTest(this);
    }

    @Override
    public boolean inv() {
        if (MaximumCapacity >= 0
                && MaximumHumidity >= 0
                && CurrentHumidity >= 0
                && CurrentCapacity >= 0
                && CurrentHumidity <= MaximumHumidity
                && CurrentCapacity <= MaximumCapacity) {
            return true;
        } else {
            return false;
        }
    }

    public TombList getName() {
        return this.Name;
    }

    public AccessType getType() {
        return this.Type;
    }

    public TombStatus getStatus() {
        return this.Status;
    }

    public int getMaximumCapacity() {
        return this.MaximumCapacity;
    }

    public int getCurrentCapacity() {
        return this.CurrentCapacity;
    }

    public int getMaximumHumidity() {
        return this.MaximumHumidity;
    }

    public int getCurrentHumidity() {
        return this.CurrentHumidity;
    }

    public boolean getMaintenance() {
        return this.Maintenance;
    }

    public boolean isMaintenance() {
        return this.Maintenance;
    }

    public VDMSet getTotalTourGroup() {
        return this.TotalTourGroup;
    }

    public VDMSet getTourGroupInTomb() {
        return this.TourGroupInTomb;
    }

    public VDMSequence getWaitingtourgroup() {
        return this.Waitingtourgroup;
    }

    public VDMSet getWaitingTourGuides() {
        return this.WaitingTourGuides;
    }

    public void setName(TombList Name) {
        this.Name = Name;
        VDM.invTest(this);

    }

    public void setType(AccessType Type) {
        this.Type = Type;
        VDM.invTest(this);

    }

    public void setStatus(TombStatus Status) {
        this.Status = Status;
        VDM.invTest(this);

    }

    public void setMaximumCapacity(int MaximumCapacity) {
        this.MaximumCapacity = MaximumCapacity;
        VDM.invTest(this);

    }

    public void setCurrentCapacity(int CurrentCapacity) {
        this.CurrentCapacity = CurrentCapacity;
        VDM.invTest(this);

    }

    public void setMaximumHumidity(int MaximumHumidity) {
        this.MaximumHumidity = MaximumHumidity;
        VDM.invTest(this);

    }

    public void setCurrentHumidity(int CurrentHumidity) {
        this.CurrentHumidity = CurrentHumidity;
        VDM.invTest(this);

    }

    public void setMaintenance(boolean Maintenance) {
        this.Maintenance = Maintenance;
        VDM.invTest(this);

    }

    public void setTotalTourGroup(VDMSet TotalTourGroup) {
        this.TotalTourGroup = TotalTourGroup;
        VDM.invTest(this);

    }

    public void setTourGroupInTomb(VDMSet TourGroupInTomb) {
        this.TourGroupInTomb = TourGroupInTomb;
        VDM.invTest(this);

    }

    public void setWaitingtourgroup(VDMSequence Waitingtourgroup) {
        this.Waitingtourgroup = Waitingtourgroup;
        VDM.invTest(this);

    }

    public void setWaitingTourGuides(VDMSet WaitingTourGuides) {
        this.WaitingTourGuides = WaitingTourGuides;
        VDM.invTest(this);

    }

    @Override
    public String toString() {
        return "{" +
            " Name='" + getName() + "'" +
            ", Type='" + getType() + "'" +
            ", Status='" + getStatus() + "'" +
            ", MaximumCapacity='" + getMaximumCapacity() + "'" +
            ", CurrentCapacity='" + getCurrentCapacity() + "'" +
            ", MaximumHumidity='" + getMaximumHumidity() + "'" +
            ", CurrentHumidity='" + getCurrentHumidity() + "'" +
            ", Maintenance='" + isMaintenance() + "'" +
            ", TotalTourGroup='" + getTotalTourGroup() + "'" +
            ", TourGroupInTomb='" + getTourGroupInTomb() + "'" +
            ", Waitingtourgroup='" + getWaitingtourgroup() + "'" +
            ", WaitingTourGuides='" + getWaitingTourGuides() + "'" +
            "}";
    }


}
