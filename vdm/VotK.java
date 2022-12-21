package vdm;

/**
 * VotK
 */
enum TombStatus {
        Open, Closed, Maintenance, Humidity
};

enum WorkingStatus {
        Available, Busy
};

enum AccessType {
        General, Special
};

enum TicketType {
        General, General_with_Camera, Special
};

enum TombList {
        KV1_G, KV2_G, KV6_G, KV8_G, KV11_G, KV14_G, KV15_G, KV47_G, KV9_S, KV17_S, KV62_S
}

public class VotK implements InvariantCheck {
        public static int TourGuideID = 0;
        public static int VisitorGroupID = 0;
        public static int TourGroupID = 0;

        // Tourists
        public static Tourist[] VisitorGroup1Tourists = { new Tourist("Test1", "Arabic"),
                        new Tourist("Test2", "Arabic"),
                        new Tourist("Test3", "Arabic"), new Tourist("Test4", "Arabic"),
                        new Tourist("Test5", "Arabic") };
        public static Tourist[] TourGroup2Tourists = { new Tourist("Test1", "Arabic", true),
                        new Tourist("Test2", "Arabic", true),
                        new Tourist("Test3", "Arabic", true), new Tourist("Test4", "Arabic", true),
                        new Tourist("Test5", "Arabic", true) };
        // Tour Guides
        public static TourGuide tourGuide1 = new TourGuide(WorkingStatus.Available);
        public static TourGuide tourGuide2 = new TourGuide(WorkingStatus.Busy);
        public static TourGuide tourGuide3 = new TourGuide(WorkingStatus.Busy);

        // Visitor Groups
        public static VisitorGroup VisitorGroup1 = new VisitorGroup(new VDMSequence(VisitorGroup1Tourists),
                        new VDMSequence());
        // Tour Groups
        public static TourGroup tourGroup1 = new TourGroup(null, null, tourGuide2, new VDMSet(VisitorGroup1Tourists),
                        new VDMSet(), new VDMSet());
        public static TourGroup tourGroup2 = new TourGroup(TicketType.General, AccessType.General, tourGuide3,
                        new VDMSet(TourGroup2Tourists),
                        new VDMSet(), new VDMSet());

        // General Tombs
        public static Tomb tomb1_G = new Tomb(TombList.KV1_G, AccessType.General, TombStatus.Open, 30, 0, 100, 0, false,
                        new VDMSet(), new VDMSet(), new VDMSequence(tourGroup2), new VDMSet());
        public static Tomb tomb2_G = new Tomb(TombList.KV2_G, AccessType.General, TombStatus.Open, 30, 0, 100, 0, false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());
        public static Tomb tomb3_G = new Tomb(TombList.KV6_G, AccessType.General, TombStatus.Open, 30, 0, 100, 0, false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());
        public static Tomb tomb4_G = new Tomb(TombList.KV8_G, AccessType.General, TombStatus.Open, 30, 0, 100, 0, false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());
        public static Tomb tomb5_G = new Tomb(TombList.KV11_G, AccessType.General, TombStatus.Open, 30, 0, 100, 0,
                        false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());
        public static Tomb tomb6_G = new Tomb(TombList.KV14_G, AccessType.General, TombStatus.Closed, 30, 0, 100, 0,
                        false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());
        public static Tomb tomb7_G = new Tomb(TombList.KV15_G, AccessType.General, TombStatus.Closed, 30, 0, 100, 0,
                        false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());
        public static Tomb tomb8_G = new Tomb(TombList.KV47_G, AccessType.General, TombStatus.Closed, 30, 0, 100, 0,
                        false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());

        // Special Tombs
        public static Tomb tomb1_S = new Tomb(TombList.KV9_S, AccessType.Special, TombStatus.Open, 30, 0, 100, 0, false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());
        public static Tomb tomb2_S = new Tomb(TombList.KV17_S, AccessType.Special, TombStatus.Open, 30, 0, 100, 0,
                        false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());
        public static Tomb tomb3_S = new Tomb(TombList.KV62_S, AccessType.Special, TombStatus.Closed, 30, 0, 100, 0,
                        false,
                        new VDMSet(), new VDMSet(), new VDMSequence(), new VDMSet());

        // Start Variables
        // Tombs
        public static Tomb[] openGeneralTombs = { tomb1_G, tomb2_G, tomb3_G, tomb4_G, tomb5_G };
        public static Tomb[] closedGeneralTombs = { tomb6_G, tomb7_G, tomb8_G };
        public static Tomb[] openSpecialTombs = { tomb1_S, tomb2_S };
        public static Tomb[] closedSpecialTombs = { tomb3_S };
        // Tour Guides
        public static TourGuide[] registeredTourGuides = { tourGuide1, tourGuide2, tourGuide3 };
        public static TourGuide[] availableTourGuides = { tourGuide1 };
        public static TourGuide[] unAvailableTourGuides = { tourGuide2, tourGuide3 };
        // Visitor Groups
        public static VisitorGroup[] visitorGroups = { VisitorGroup1 };
        // Tour Groups
        public static TourGroup[] tourGroups = { tourGroup1, tourGroup2 };

        // State Variables
        private VDMSequence WaitingTourGroups;
        private VDMSet RegisterdTourGuides;
        private VDMSet AvailableTourGuides;
        private VDMSet UnavailableTourGuides;
        private VDMSet VisitorGroups;
        private VDMSet TourGroups;
        private VDMSet OpenGeneralTomb;
        private VDMSet OpenSpecialTomb;
        private VDMSet ClosedGeneralTomb;
        private VDMSet ClosedSpecialTomb;

        public VotK() {
                this.WaitingTourGroups = new VDMSequence();
                this.RegisterdTourGuides = new VDMSet(registeredTourGuides);
                this.AvailableTourGuides = new VDMSet(availableTourGuides);
                this.UnavailableTourGuides = new VDMSet(unAvailableTourGuides);
                this.VisitorGroups = new VDMSet(visitorGroups);
                this.TourGroups = new VDMSet(tourGroups);
                this.OpenGeneralTomb = new VDMSet(openGeneralTombs);
                this.OpenSpecialTomb = new VDMSet(openSpecialTombs);
                this.ClosedGeneralTomb = new VDMSet(closedGeneralTombs);
                this.ClosedSpecialTomb = new VDMSet(closedSpecialTombs);
                VDM.invTest(this);
        }

        @Override
        public boolean inv() {
                if (AvailableTourGuides.isASubsetOf(RegisterdTourGuides)
                                && UnavailableTourGuides.isASubsetOf(RegisterdTourGuides)
                                && OpenGeneralTomb.card() >= 3 && OpenSpecialTomb.card() >= 1) {
                        return true;
                } else {
                        return false;
                }
        }

        // Yousef 191649
        public void AssignTourGuide(TourGroup TourGroup, TourGuide tourGuide) {
                VDM.preTest(AvailableTourGuides.contains(tourGuide)
                                && UnavailableTourGuides.doesNotContain(tourGuide)
                                && tourGuide.getAvailable() == WorkingStatus.Available
                                && TourGroup.getTourGuide() == null
                                && WaitingTourGroups.elems().doesNotContain(TourGroup));
                AvailableTourGuides = AvailableTourGuides.difference(new VDMSet(tourGuide));
                UnavailableTourGuides = UnavailableTourGuides.union(new VDMSet(tourGuide));
                tourGuide.setWorkingStatus(WorkingStatus.Busy);
                TourGroup.setTourGuide(tourGuide);
                VDM.postTest(TourGroup.getTourGuide() == tourGuide
                                && tourGuide.getAvailable() == WorkingStatus.Busy
                                && UnavailableTourGuides.contains(tourGuide)
                                && AvailableTourGuides.doesNotContain(tourGuide));
                VDM.invTest(this);

        }

        public void AssignTourGuideToWaitingGroup(TourGuide TourGuide) {
                VDM.preTest(AvailableTourGuides.contains(TourGuide)
                                && UnavailableTourGuides.doesNotContain(TourGuide)
                                && TourGuide.getAvailable() == WorkingStatus.Available
                                && WaitingTourGroups.isEmpty() == false);
                TourGuide.setWorkingStatus(WorkingStatus.Busy);
                AvailableTourGuides = AvailableTourGuides.difference(new VDMSet(TourGuide));
                UnavailableTourGuides = UnavailableTourGuides.union(new VDMSet(TourGuide));
                ((TourGroup) WaitingTourGroups.hd()).setTourGuide(TourGuide);
                TourGroup TempTourGroup = (TourGroup) WaitingTourGroups.hd();
                VDMSequence TempTourGroups = WaitingTourGroups.tl();
                WaitingTourGroups = WaitingTourGroups.tl();

                VDM.postTest(TourGuide.getAvailable() == WorkingStatus.Busy
                                && UnavailableTourGuides.contains(TourGuide)
                                && AvailableTourGuides.doesNotContain(TourGuide)
                                && TempTourGroup.getTourGuide() == TourGuide
                                && WaitingTourGroups.equals(TempTourGroups));
                VDM.invTest(this);
        }

        public void UnassignTourGuide(TourGroup TourGroup) {
                VDM.preTest(TourGroup.getTourGuide() != null);

                AvailableTourGuides = AvailableTourGuides.union(new VDMSet(TourGroup.getTourGuide()));
                UnavailableTourGuides = UnavailableTourGuides.difference(new VDMSet(TourGroup.getTourGuide()));
                TourGroup.getTourGuide().setWorkingStatus(WorkingStatus.Available);
                TourGuide TempTourGuide = TourGroup.getTourGuide();
                TourGroup.setTourGuide(null);
                VDM.postTest(TourGroup.getTourGuide() == null
                                && UnavailableTourGuides.doesNotContain(TempTourGuide)
                                && AvailableTourGuides.contains(TempTourGuide));
                VDM.invTest(this);
        }

        // Bassem 182869
        public void RemoveFromWaitingTomb(Tomb Tomb) {

                VDM.preTest(Tomb.getWaitingtourgroup().isEmpty() == false
                                && Tomb.getStatus() == TombStatus.Open);

                TourGroup TempTourGroup = (TourGroup) Tomb.getWaitingtourgroup().hd();
                int tempHumidity = Tomb.getCurrentHumidity();
                if (CanAccessTomb(TempTourGroup, Tomb) == true) {
                        if (Tomb.getType() == AccessType.General) {
                                if (TempTourGroup.getTourGuide() != null) {
                                        OpenGeneralTomb = OpenGeneralTomb.difference(new VDMSet(Tomb));
                                        Tomb.setCurrentCapacity(
                                                        Tomb.getCurrentCapacity() + TempTourGroup.getTourists().card());
                                        Tomb.setCurrentHumidity(Tomb.getCurrentHumidity() + 1);
                                        Tomb.setTotalTourGroup(
                                                        Tomb.getTotalTourGroup().union(new VDMSet(TempTourGroup)));
                                        Tomb.setTourGroupInTomb(
                                                        Tomb.getTourGroupInTomb().union(new VDMSet(TempTourGroup)));
                                        Tomb.setWaitingtourgroup(Tomb.getWaitingtourgroup().tl());
                                        Tomb.setWaitingTourGuides(Tomb.getWaitingTourGuides().union(
                                                        new VDMSet(TempTourGroup.getTourGuide())));

                                        OpenGeneralTomb = OpenGeneralTomb.union(new VDMSet(Tomb));

                                } else {
                                        OpenGeneralTomb = OpenGeneralTomb.difference(new VDMSet(Tomb));
                                        Tomb.setCurrentCapacity(
                                                        Tomb.getCurrentCapacity() + TempTourGroup.getTourists().card());
                                        Tomb.setCurrentHumidity(Tomb.getCurrentHumidity() + 1);
                                        Tomb.setTotalTourGroup(
                                                        Tomb.getTotalTourGroup().union(new VDMSet(TempTourGroup)));
                                        Tomb.setTourGroupInTomb(
                                                        Tomb.getTourGroupInTomb().union(new VDMSet(TempTourGroup)));
                                        Tomb.setWaitingtourgroup(Tomb.getWaitingtourgroup().tl());

                                        OpenGeneralTomb = OpenGeneralTomb.union(new VDMSet(Tomb));
                                }

                        } else {
                                if (TempTourGroup.getTourGuide() != null) {
                                        OpenSpecialTomb = OpenSpecialTomb.difference(new VDMSet(Tomb));

                                        Tomb.setCurrentCapacity(
                                                        Tomb.getCurrentCapacity() + TempTourGroup.getTourists().card());
                                        Tomb.setCurrentHumidity(Tomb.getCurrentHumidity() + 1);
                                        Tomb.setTotalTourGroup(
                                                        Tomb.getTotalTourGroup().union(new VDMSet(TempTourGroup)));
                                        Tomb.setTourGroupInTomb(
                                                        Tomb.getTourGroupInTomb().union(new VDMSet(TempTourGroup)));
                                        Tomb.setWaitingtourgroup(Tomb.getWaitingtourgroup().tl());
                                        Tomb.setWaitingTourGuides(Tomb.getWaitingTourGuides().union(
                                                        new VDMSet(TempTourGroup.getTourGuide())));

                                        OpenSpecialTomb = OpenSpecialTomb.union(new VDMSet(Tomb));

                                } else {
                                        OpenSpecialTomb = OpenSpecialTomb.difference(new VDMSet(Tomb));

                                        Tomb.setCurrentCapacity(
                                                        Tomb.getCurrentCapacity() + TempTourGroup.getTourists().card());
                                        Tomb.setCurrentHumidity(Tomb.getCurrentHumidity() + 1);
                                        Tomb.setTotalTourGroup(
                                                        Tomb.getTotalTourGroup().union(new VDMSet(TempTourGroup)));
                                        Tomb.setTourGroupInTomb(
                                                        Tomb.getTourGroupInTomb().union(new VDMSet(TempTourGroup)));
                                        Tomb.setWaitingtourgroup(Tomb.getWaitingtourgroup().tl());
                                        OpenSpecialTomb = OpenSpecialTomb.union(new VDMSet(Tomb));

                                }

                        }
                }
                VDM.postTest(Tomb.getWaitingtourgroup().elems().doesNotContain(TempTourGroup)
                                && Tomb.getTourGroupInTomb().contains(TempTourGroup)
                                && Tomb.getCurrentHumidity() == tempHumidity + 1);
                VDM.invTest(this);
        }

        public Boolean CanAccessTomb(TourGroup TourGroup, Tomb Tomb) {

                VDM.preTest(TourGroup.getGeneralVisitedTombs().doesNotContain(Tomb)
                                &&
                                TourGroup.getSpecialVisitedTombs().doesNotContain(Tomb));

                for (int i = 0; TourGroup.getTourists().card() > i; i++) {

                        if (((Tourist) TourGroup.getTourists().theSet.elementAt(i)).isPaid() == false) {
                                return false;
                        }
                }
                if (Tomb.getWaitingtourgroup().hd().equals(TourGroup)) {
                        if (Tomb.getMaximumCapacity()
                                        - (Tomb.getCurrentCapacity() + (TourGroup.getTourists().card())) >= 0
                                        && Tomb.getMaximumHumidity() - (Tomb.getCurrentHumidity() + 1) > 0) {
                                return true;
                        } else {
                                return false;
                        }
                } else {

                        return false;
                }

        }

        // Bothaina 181483
        public void DivideVisitorGroup(VisitorGroup VG) {
                VDM.preTest(true);

                TourGroup Group1;
                VDMSet TouristSet = VG.getTourist().elems();
                int Separator = TouristSet.card() / 2;
                VDMSequence SplitTourist1 = VG.getTourist().subseq(1, Separator);
                System.out.println(" Split1: " + SplitTourist1);

                VDMSequence SplitTourist2 = VG.getTourist().subseq(Separator, VG.getTourist().len());
                TourGroup Group2;
                switch (VG.getTourGuide().len()) {
                        case 2: {
                                TourGuide T1 = (TourGuide) VG.getTourGuide().index(1);
                                TourGuide T2 = (TourGuide) VG.getTourGuide().index(2);

                                Group1 = new TourGroup(null, null, T1, SplitTourist1.elems(), new VDMSet(),
                                                new VDMSet());

                                Group2 = new TourGroup(null, null, T2, SplitTourist2.elems(), new VDMSet(),
                                                new VDMSet());
                                TourGroups = TourGroups.union(new VDMSet(Group1));
                                TourGroups = TourGroups.union(new VDMSet(Group2));
                                break;
                        }
                        case 1: {
                                System.out.println(WaitingTourGroups.elems().card());
                                TourGuide T1 = (TourGuide) VG.getTourGuide().index(1);

                                Group1 = new TourGroup(null, null, T1, SplitTourist1.elems(), new VDMSet(),
                                                new VDMSet());
                                Group2 = new TourGroup(null, null, null, SplitTourist2.elems(), new VDMSet(),
                                                new VDMSet());
                                TourGroups = TourGroups.union(new VDMSet(Group1));

                                WaitingTourGroups = WaitingTourGroups.concat(new VDMSequence(Group2));
                                System.out.println(WaitingTourGroups.elems().card());
                                break;
                        }
                        default:
                                Group1 = new TourGroup(null, null, null, SplitTourist1.elems(), new VDMSet(),
                                                new VDMSet());
                                Group2 = new TourGroup(null, null, null, SplitTourist2.elems(), new VDMSet(),
                                                new VDMSet());
                                WaitingTourGroups = WaitingTourGroups.concat(new VDMSequence(Group1));
                                WaitingTourGroups = WaitingTourGroups.concat(new VDMSequence(Group2));
                                break;
                }
                boolean a = false;
                if (TourGroups.contains(Group1) && TourGroups.contains(Group2)
                                && VG.getTourGuide().elems().isASubsetOf(RegisterdTourGuides))
                        a = true;
                boolean b = false;
                if (TourGroups.contains(Group1) && VG.getTourGuide().elems().isASubsetOf(RegisterdTourGuides)
                                && WaitingTourGroups.elems().contains(Group2))
                        b = true;
                System.out.println(b);
                boolean c = false;
                if (WaitingTourGroups.elems().contains(Group2) && WaitingTourGroups.elems().contains(Group1))
                        c = true;
                VDM.postTest(a == true || b == true || c == true);
                VDM.invTest(this);
        }

        public void ChangeVisitorGroup(VisitorGroup VG) {
                boolean divison = false;
                VDM.preTest(VisitorGroups.isEmpty() == false);
                VDMSet TouristSet = VG.getTourist().elems();
                int TouristCount = TouristSet.card();
                if (TouristCount > 10) {
                        DivideVisitorGroup(VG);
                        divison = true;

                } else
                        TourGroups = TourGroups.union(new VDMSet(
                                        new TourGroup(null, null, null, TouristSet, new VDMSet(), new VDMSet())));
                VDM.postTest(TourGroups.contains(TouristSet) || divison);
                VDM.invTest(this);
        }

        // belal
        public void RegisterTourGuide(TourGuide NewTourGuide) {
                VDM.preTest(RegisterdTourGuides.doesNotContain(NewTourGuide)
                                && AvailableTourGuides.doesNotContain(NewTourGuide));
                RegisterdTourGuides = RegisterdTourGuides.union(new VDMSet(NewTourGuide));
                AvailableTourGuides = AvailableTourGuides.union(new VDMSet(NewTourGuide));
                VDM.postTest(RegisterdTourGuides.contains(NewTourGuide) && AvailableTourGuides.contains(NewTourGuide));
                VDM.invTest(this);
        }

        public void WaitForTourGuide(TourGroup TG) {
                VDM.preTest(WaitingTourGroups.elems().doesNotContain(TG));
                WaitingTourGroups = WaitingTourGroups.concat(new VDMSequence(TG));
                VDM.postTest(WaitingTourGroups.elems().contains(TG));
        }

        // Zeyad 189714
        public Boolean OpenedTomb(Tomb Tomb) {
                if (OpenGeneralTomb.contains(Tomb) || OpenSpecialTomb.contains(Tomb)) {
                        return true;
                } else
                        return false;
        }

        public Boolean CanStillAccessGeneralTomb(TourGroup TourGroup) {
                if (TourGroup.getGeneralVisitedTombs().card() < 3) {
                        return true;
                } else
                        return false;
        }

        public Boolean CanStillAccessSpecialTomb(TourGroup TourGroup) {
                if (TourGroup.getSpecialVisitedTombs().card() < OpenSpecialTomb.card()
                                && TourGroup.getAccess() == AccessType.Special) {
                        return true;
                } else
                        return false;
        }

        public void EnterTomb(TourGroup TourGroup, Tomb Tomb) {
                VDM.preTest(TourGroup.getAccess() != null
                                && TourGroup.getTicket() != null
                                && Tomb.getWaitingtourgroup().elems().doesNotContain(TourGroup));

                int tempHumidity = Tomb.getCurrentHumidity();
                if (OpenedTomb(Tomb) == true) {
                        if (TourGroup.getAccess() != null) {
                                if (CanStillAccessGeneralTomb(TourGroup) == true) {
                                        Tomb.setWaitingtourgroup(
                                                        Tomb.getWaitingtourgroup().concat(new VDMSequence(TourGroup)));
                                        if (CanAccessTomb(TourGroup, Tomb) == true) {
                                                if (TourGroup.getTourGuide() != null) {
                                                        Tomb.setTotalTourGroup(
                                                                        Tomb.getTotalTourGroup()
                                                                                        .union(new VDMSet(TourGroup)));
                                                        Tomb.setTourGroupInTomb(
                                                                        Tomb.getTourGroupInTomb()
                                                                                        .union(new VDMSet(TourGroup)));
                                                        Tomb.setWaitingTourGuides(
                                                                        Tomb.getWaitingTourGuides().union(new VDMSet(
                                                                                        TourGroup.getTourGuide())));
                                                        Tomb.setCurrentHumidity(
                                                                        Tomb.getCurrentHumidity() + 1);
                                                } else {
                                                        Tomb.setTotalTourGroup(
                                                                        Tomb.getTotalTourGroup()
                                                                                        .union(new VDMSet(TourGroup)));
                                                        Tomb.setTourGroupInTomb(
                                                                        Tomb.getTourGroupInTomb()
                                                                                        .union(new VDMSet(TourGroup)));
                                                        Tomb.setCurrentHumidity(
                                                                        Tomb.getCurrentHumidity() + 1);
                                                }
                                                OpenGeneralTomb = OpenGeneralTomb.difference(new VDMSet(Tomb));
                                                OpenGeneralTomb = OpenGeneralTomb.union(new VDMSet(Tomb));
                                                TourGroups = TourGroups.difference(new VDMSet(TourGroup));
                                                TourGroups = TourGroups.union(new VDMSet(TourGroup));
                                        } else {
                                                Tomb.setWaitingtourgroup(
                                                                Tomb.getWaitingtourgroup()
                                                                                .concat(new VDMSequence(TourGroup)));
                                                OpenGeneralTomb = OpenGeneralTomb.difference(new VDMSet(Tomb));
                                                OpenGeneralTomb = OpenGeneralTomb.union(new VDMSet(Tomb));
                                        }
                                } else if (CanStillAccessSpecialTomb(TourGroup) == true) {
                                        if (CanAccessTomb(TourGroup, Tomb) == true) {
                                                if (TourGroup.getTourGuide() != null) {
                                                        Tomb.setTotalTourGroup(
                                                                        Tomb.getTotalTourGroup()
                                                                                        .union(new VDMSet(TourGroup)));
                                                        Tomb.setTourGroupInTomb(
                                                                        Tomb.getTourGroupInTomb()
                                                                                        .union(new VDMSet(TourGroup)));
                                                        Tomb.setWaitingTourGuides(
                                                                        Tomb.getWaitingTourGuides().union(new VDMSet(
                                                                                        TourGroup.getTourGuide())));
                                                        Tomb.setCurrentHumidity(
                                                                        Tomb.getCurrentHumidity() + 1);
                                                } else {
                                                        Tomb.setTotalTourGroup(
                                                                        Tomb.getTotalTourGroup()
                                                                                        .union(new VDMSet(TourGroup)));
                                                        Tomb.setTourGroupInTomb(
                                                                        Tomb.getTourGroupInTomb()
                                                                                        .union(new VDMSet(TourGroup)));
                                                        Tomb.setCurrentHumidity(
                                                                        Tomb.getCurrentHumidity() + 1);
                                                }
                                                TourGroup.setSpecialVisitedTombs(
                                                                Tomb.getTotalTourGroup().union(new VDMSet(TourGroup)));
                                                OpenSpecialTomb = OpenSpecialTomb.difference(new VDMSet(Tomb));
                                                OpenSpecialTomb = OpenSpecialTomb.union(new VDMSet(Tomb));
                                                TourGroups = TourGroups.difference(new VDMSet(TourGroup));
                                                TourGroups = TourGroups.union(new VDMSet(TourGroup));
                                        } else {
                                                Tomb.setWaitingtourgroup(
                                                                Tomb.getWaitingtourgroup()
                                                                                .concat(new VDMSequence(TourGroup)));
                                                OpenSpecialTomb = OpenSpecialTomb.difference(new VDMSet(Tomb));
                                                OpenSpecialTomb = OpenSpecialTomb.union(new VDMSet(Tomb));
                                        }
                                }
                        }
                }

                VDM.postTest(Tomb.getWaitingtourgroup().elems().contains(TourGroup)
                                || Tomb.getTourGroupInTomb().contains(TourGroup)
                                                && Tomb.getTotalTourGroup().contains(TourGroup)
                                                && Tomb.getWaitingTourGuides().contains(TourGroup.getTourGuide())
                                                && TourGroup.getGeneralVisitedTombs().contains(Tomb)
                                                && Tomb.getCurrentHumidity() == tempHumidity + 1
                                || TourGroup.getSpecialVisitedTombs().contains(Tomb)
                                                && Tomb.getTourGroupInTomb().contains(TourGroup)
                                                && Tomb.getTotalTourGroup().contains(TourGroup)
                                                && Tomb.getWaitingTourGuides().contains(TourGroup.getTourGuide())
                                                && Tomb.getCurrentHumidity() == tempHumidity + 1);
                VDM.invTest(this);
        }

        public void ExitTomb(TourGroup TourGroup, Tomb Tomb) {
                VDM.preTest(Tomb.getTourGroupInTomb().contains(TourGroup));

                if (TourGroup.getTourGuide() != null) {
                        Tomb.setTourGroupInTomb(
                                        Tomb.getTourGroupInTomb().difference(new VDMSet(TourGroup)));
                        Tomb.setWaitingTourGuides(
                                        Tomb.getWaitingTourGuides().difference(new VDMSet(TourGroup.getTourGuide())));
                } else {
                        Tomb.setTourGroupInTomb(
                                        Tomb.getTourGroupInTomb().difference(new VDMSet(TourGroup)));
                }

                VDM.postTest(Tomb.getTourGroupInTomb().doesNotContain(TourGroup));
                VDM.invTest(this);
        }

        // Ahmed 182923
        public Tomb InspectTomb(Tomb Tomb) {
                VDM.preTest(OpenGeneralTomb.contains(Tomb)
                                || OpenSpecialTomb.contains(Tomb)
                                || ClosedGeneralTomb.contains(Tomb)
                                || ClosedSpecialTomb.contains(Tomb));

                if (Tomb.getCurrentHumidity() == Tomb.getMaximumHumidity()) {
                        Tomb.setStatus(TombStatus.Humidity);
                } else if (Tomb.getStatus() == TombStatus.Maintenance) {
                        Tomb.setStatus(TombStatus.Maintenance);
                } else if (Tomb.getStatus() == TombStatus.Closed) {
                        Tomb.setStatus(TombStatus.Open);
                        Tomb.setCurrentHumidity(0);
                        Tomb.setMaintenance(false);

                } else if (Tomb.getStatus() == TombStatus.Humidity) {
                        Tomb.setStatus(TombStatus.Open);
                        Tomb.setCurrentHumidity(0);
                        Tomb.setMaintenance(false);

                } else if (Tomb.getStatus() == TombStatus.Maintenance) {
                        Tomb.setStatus(TombStatus.Open);
                        Tomb.setCurrentHumidity(0);
                        Tomb.setMaintenance(false);

                } else {
                        Tomb.setStatus(TombStatus.Closed);
                }

                VDM.postTest(Tomb.getStatus() == TombStatus.Closed
                                || Tomb.getStatus() == TombStatus.Open
                                || Tomb.getStatus() == TombStatus.Maintenance
                                || Tomb.getStatus() == TombStatus.Humidity);
                VDM.invTest(this);
                return Tomb;
        }

        public int GetTombCapacity(Tomb Tomb) {
                int RESULT = 0;
                VDM.preTest(true);
                RESULT = Tomb.getMaximumCapacity();
                VDM.postTest(RESULT == Tomb.getMaximumCapacity());
                return RESULT;
        }

        // Testing Functions
        public static void main(String[] args) {
                VotK VotKSystem = new VotK();
                Tourist TestingTourist = new Tourist("TestTourist", "English");
                Tourist T1 = new Tourist("TestTourist1", "English");
                Tourist T2 = new Tourist("TestTourist2", "Arabic");
                Tourist T3 = new Tourist("TestTourist3", "Japanese");
                Tourist T4 = new Tourist("TestTourist4", "Chinesse");
                Tourist T5 = new Tourist("TestTourist5", "Arabic");
                Tourist T6 = new Tourist("TestTourist6", "Arabic");
                Tourist T7 = new Tourist("TestTourist7", "Arabic");
                Tourist T8 = new Tourist("TestTourist8", "Arabic");
                Tourist T9 = new Tourist("TestTourist9", "Arabic");
                Tourist T10 = new Tourist("TestTourist10", "Arabic");
                Tourist T11 = new Tourist("TestTourist11", "Arabic");
                Tourist T12 = new Tourist("TestTourist12", "Arabic");
                Tourist T13 = new Tourist("TestTourist13", "Arabic");
                Tourist T14 = new Tourist("TestTourist14", "Arabic");
                Tourist T15 = new Tourist("TestTourist14", "Arabic", true);
                TourGuide TestingTourGuide5 = new TourGuide(WorkingStatus.Busy);

                TourGroup TestingTourGroup = new TourGroup(null, null, null, new VDMSet(TestingTourist),
                                new VDMSet(), new VDMSet());
                TourGroup TestingTourGroup2 = new TourGroup(null, null, null, new VDMSet(TestingTourist),
                                new VDMSet(), new VDMSet());
                TourGroup TestingTourGroup3 = new TourGroup(TicketType.Special, AccessType.Special, TestingTourGuide5,
                                new VDMSet(T15),
                                new VDMSet(), new VDMSet());
                TourGroup WaitingTestingTourGroup = new TourGroup(null, null, null, new VDMSet(TestingTourist),
                                new VDMSet(), new VDMSet());
                TourGuide TestingTourGuide = new TourGuide(WorkingStatus.Available);
                TourGuide TestingTourGuide2 = new TourGuide(WorkingStatus.Available);
                TourGuide TestingTourGuide3 = new TourGuide(WorkingStatus.Busy);
                TourGuide TestingRegisterTourGuide4 = new TourGuide(WorkingStatus.Available);

                VotKSystem.TourGroups = VotKSystem.TourGroups.union(new VDMSet(TestingTourGroup));
                VotKSystem.RegisterdTourGuides = VotKSystem.RegisterdTourGuides.union(new VDMSet(TestingTourGuide));
                VotKSystem.RegisterdTourGuides = VotKSystem.RegisterdTourGuides.union(new VDMSet(TestingTourGuide2));
                VotKSystem.RegisterdTourGuides = VotKSystem.RegisterdTourGuides.union(new VDMSet(TestingTourGuide3));
                VotKSystem.RegisterdTourGuides = VotKSystem.RegisterdTourGuides.union(new VDMSet(TestingTourGuide5));
                VotKSystem.AvailableTourGuides = VotKSystem.AvailableTourGuides.union(new VDMSet(TestingTourGuide));
                VotKSystem.AvailableTourGuides = VotKSystem.AvailableTourGuides.union(new VDMSet(TestingTourGuide2));
                VotKSystem.UnavailableTourGuides = VotKSystem.UnavailableTourGuides
                                .union(new VDMSet(TestingTourGuide3));
                VotKSystem.UnavailableTourGuides = VotKSystem.UnavailableTourGuides
                                .union(new VDMSet(TestingTourGuide5));
                VotKSystem.WaitingTourGroups = VotKSystem.WaitingTourGroups
                                .concat(new VDMSequence(WaitingTestingTourGroup));
                VDMSequence TestingVG = new VDMSequence(T1);
                TestingVG = TestingVG.concat(new VDMSequence(T2));
                TestingVG = TestingVG.concat(new VDMSequence(T3));
                TestingVG = TestingVG.concat(new VDMSequence(T4));
                TestingVG = TestingVG.concat(new VDMSequence(T5));
                TestingVG = TestingVG.concat(new VDMSequence(T6));
                TestingVG = TestingVG.concat(new VDMSequence(T7));
                TestingVG = TestingVG.concat(new VDMSequence(T8));
                TestingVG = TestingVG.concat(new VDMSequence(T9));
                TestingVG = TestingVG.concat(new VDMSequence(T10));
                TestingVG = TestingVG.concat(new VDMSequence(T11));
                TestingVG = TestingVG.concat(new VDMSequence(T12));
                TestingVG = TestingVG.concat(new VDMSequence(T13));
                TestingVG = TestingVG.concat(new VDMSequence(T14));
                VDMSequence TestingVGTG = new VDMSequence(TestingTourGuide3);
                VisitorGroup a = new VisitorGroup(TestingVG, TestingVGTG);
                // Yousef 191649
                System.out.println("Before Assigning Tour Guide");
                System.out.println("Tour Guide");
                System.out.println(TestingTourGuide.toString());
                System.out.println("Tour Group");
                System.out.println(TestingTourGroup.toString());
                VotKSystem.AssignTourGuide(TestingTourGroup, TestingTourGuide);
                System.out.println("After Assigning Tour Guide");
                System.out.println("Tour Guide");
                System.out.println(TestingTourGuide.toString());
                System.out.println("Tour Group");
                System.out.println(TestingTourGroup.toString());
                System.out.println("Before Unassigning Tour Guide");
                System.out.println("Tour Guide");
                System.out.println(TestingTourGuide.toString());
                System.out.println("Tour Group");
                System.out.println(TestingTourGroup.toString());
                VotKSystem.UnassignTourGuide(TestingTourGroup);
                System.out.println("After Unassigning Tour Guide");
                System.out.println("Tour Guide");
                System.out.println(TestingTourGuide.toString());
                System.out.println("Tour Group");
                System.out.println(TestingTourGroup.toString());
                System.out.println("Before Assigning Tour Guide to Waiting Tour Group");
                System.out.println("Tour Guide");
                System.out.println(TestingTourGuide2.toString());
                System.out.println("Tour Group");
                System.out.println(WaitingTestingTourGroup.toString());
                System.out.println("After Assigning Tour Guide to Waiting Tour Group");
                VotKSystem.AssignTourGuideToWaitingGroup(TestingTourGuide2);
                System.out.println("Tour Guide");
                System.out.println(TestingTourGuide2.toString());
                System.out.println("Tour Group");
                System.out.println(WaitingTestingTourGroup.toString());
                // Bassem 182869
                System.out.println("Before Removing Tour Group From Tomb Queue");
                System.out.println(tomb1_G.toString());
                VotKSystem.RemoveFromWaitingTomb(tomb1_G);
                System.out.println("After Removing Tour Group From Tomb Queue");
                System.out.println(tomb1_G.toString());
                // Bothaina 181483
                System.out.println("Before Changing VisitorGroup");
                System.out.println("Visitor Group:\n " + a.toString());
                System.out.println("Waiting Tour Groups: \n" + VotKSystem.WaitingTourGroups);
                System.out.println("Tour Groups:\n " + VotKSystem.TourGroups);
                VotKSystem.ChangeVisitorGroup(a);
                System.out.println("After Changing VisitorGroup");
                System.out.println("Waiting Tour Groups: \n" + VotKSystem.WaitingTourGroups);
                System.out.println("Tour Groups: \n" + VotKSystem.TourGroups);
                // belal
                System.out.println("before registering tour guide");
                System.out.println("regiserd tour Guide: \n" + registeredTourGuides.toString());
                VotKSystem.RegisterTourGuide(TestingRegisterTourGuide4);
                System.out.println("after regertering tour Guide");
                System.out.println("regiserd tour Guide: \n" + registeredTourGuides.toString());
                System.out.println("before waiting for tour Guide");
                System.out.println("regiserd tour Guide: \n" + WaitingTestingTourGroup.toString());
                VotKSystem.WaitForTourGuide(TestingTourGroup2);
                System.out.println("after Witing for tour Guide");
                System.out.println("regiserd tour Guide: \n" + WaitingTestingTourGroup.toString());
                // Zeyad 189714
                // Enter Tomb
                System.out.println("Before Entering Tomb");
                System.out.println("Tour Group");
                System.out.println(TestingTourGroup3.toString());
                System.out.println("Tomb");
                System.out.println(tomb5_G.toString());
                VotKSystem.EnterTomb(TestingTourGroup3, tomb5_G);
                System.out.println("After Entering Tomb");
                System.out.println("Tour Group");
                System.out.println(TestingTourGroup3.toString());
                System.out.println("Tomb");
                System.out.println(tomb5_G.toString());
                // Exit Tomb
                System.out.println("Before Exiting Tomb");
                System.out.println("Tour Group");
                System.out.println(TestingTourGroup3.toString());
                System.out.println("Tomb");
                System.out.println(tomb5_G.toString());
                VotKSystem.ExitTomb(TestingTourGroup3, tomb5_G);
                System.out.println("After Exiting Tomb");
                System.out.println("Tour Group");
                System.out.println(TestingTourGroup3.toString());
                System.out.println("Tomb");
                System.out.println(tomb5_G.toString());
                // Ahmed 182923
                System.out.println("Before Tomb Inspection : ");
                System.out.println(tomb6_G.toString());
                System.out.println("After Inspection : ");
                VotKSystem.InspectTomb(tomb6_G);
                System.out.println(tomb6_G.toString());
        }
}