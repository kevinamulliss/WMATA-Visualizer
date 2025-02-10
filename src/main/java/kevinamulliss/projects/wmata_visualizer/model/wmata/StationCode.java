package kevinamulliss.projects.wmata_visualizer.model.wmata;

public enum StationCode {
    J03("Franconia-Springfield", new LineCode[]{LineCode.BL}),
    J02("Van Dorn Street", new LineCode[]{LineCode.BL, LineCode.YL}),
    C13("King St-Old Town", new LineCode[]{LineCode.BL, LineCode.YL}),
    C12("Braddock Road", new LineCode[]{LineCode.BL, LineCode.YL}),
    C11("Potomac Yard", new LineCode[]{LineCode.BL, LineCode.YL}),
    C10("Ronald Reagan Washington National Airport", new LineCode[]{LineCode.BL, LineCode.YL}),
    C09("Crystal City", new LineCode[]{LineCode.BL, LineCode.YL}),
    C08("Pentagon City", new LineCode[]{LineCode.BL, LineCode.YL}),
    C07("Pentagon", new LineCode[]{LineCode.BL, LineCode.YL}),
    C06("Arlington Cemetery", new LineCode[]{LineCode.BL}),
    C05("Rosslyn", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    C04("Foggy Bottom-GWU", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    C03("Farragut West", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    C02("McPherson Square", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    C01("Metro Center", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    A01("Metro Center", new LineCode[]{LineCode.RD}),
    D01("Federal Triangle", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    D02("Smithsonian", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    D03("L'Enfant Plaza", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    F03("L'Enfant Plaza", new LineCode[]{LineCode.GR, LineCode.YL}),
    D04("Federal Center SW", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    D05("Capitol South", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    D06("Eastern Market", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    D07("Potomac Ave", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    D08("Stadium-Armory", new LineCode[]{LineCode.BL, LineCode.OR, LineCode.SV}),
    G01("Benning Road", new LineCode[]{LineCode.BL, LineCode.SV}),
    G02("Capitol Heights", new LineCode[]{LineCode.BL, LineCode.SV}),
    G03("Addison Road-Seat Pleasant", new LineCode[]{LineCode.BL, LineCode.SV}),
    G04("Morgan Boulevard", new LineCode[]{LineCode.BL, LineCode.SV}),
    G05("Downtown Largo", new LineCode[]{LineCode.BL, LineCode.SV}),
    F11("Branch Ave", new LineCode[]{LineCode.GR}),
    F10("Suitland", new LineCode[]{LineCode.GR}),
    F09("Naylor Road", new LineCode[]{LineCode.GR}),
    F08("Southern Avenue", new LineCode[]{LineCode.GR}),
    F07("Congress Heights", new LineCode[]{LineCode.GR}),
    F06("Anacostia", new LineCode[]{LineCode.GR}),
    F05("Navy Yard-Ballpark", new LineCode[]{LineCode.GR}),
    F04("Waterfront", new LineCode[]{LineCode.GR}),
    // F03 listed with D03 due to being same station but different platforms
    F02("Archives-Navy Memorial-Penn Quarter", new LineCode[]{LineCode.GR, LineCode.YL}),
    F01("Gallery Pl-Chinatown", new LineCode[]{LineCode.GR, LineCode.YL}),
    B01("Gallery Pl-Chinatown", new LineCode[]{LineCode.RD}),
    E01("Mt Vernon Sq 7th St-Convention Center", new LineCode[]{LineCode.GR, LineCode.YL}),
    E02("Shaw-Howard U", new LineCode[]{LineCode.GR}),
    E03("U Street/African-Amer Civl War Memorial/Cardozo", new LineCode[]{LineCode.GR}),
    E04("Columbia Heights", new LineCode[]{LineCode.GR}),
    E05("Georgia Ave-Petworth", new LineCode[]{LineCode.GR}),
    E06("Fort Totten", new LineCode[]{LineCode.GR}),
    B06("Fort Totten", new LineCode[]{LineCode.RD}),
    E07("West Hyattsville", new LineCode[]{LineCode.GR}),
    E08("Hyattsville Crossing", new LineCode[]{LineCode.GR}),
    E09("College Park-U of Md", new LineCode[]{LineCode.GR}),
    E10("Greenbelt", new LineCode[]{LineCode.GR}),
    K08("Vienna/Fairfax-GMU", new LineCode[]{LineCode.OR}),
    K07("Dunn Loring-Merrifield", new LineCode[]{LineCode.OR}),
    K06("West Falls Church", new LineCode[]{LineCode.OR}),
    K05("East Falls Church", new LineCode[]{LineCode.OR, LineCode.SV}),
    K04("Ballston-MU", new LineCode[]{LineCode.OR, LineCode.SV}),
    K03("Virginia Square-GMU", new LineCode[]{LineCode.OR, LineCode.SV}),
    K02("Clarendon", new LineCode[]{LineCode.OR, LineCode.SV}),
    K01("Court House", new LineCode[]{LineCode.OR, LineCode.SV}),
    D09("Minnesota Ave", new LineCode[]{LineCode.OR}),
    D10("Deanwood", new LineCode[]{LineCode.OR}),
    D11("Cheverly", new LineCode[]{LineCode.OR}),
    D12("Landover", new LineCode[]{LineCode.OR}),
    D13("New Carrollton", new LineCode[]{LineCode.OR}),
    A15("Shady Grove", new LineCode[]{LineCode.RD}),
    A14("Rockville", new LineCode[]{LineCode.RD}),
    A13("Twinbrook", new LineCode[]{LineCode.RD}),
    A12("North Bethesda", new LineCode[]{LineCode.RD}),
    A11("Grosvenor-Strathmore", new LineCode[]{LineCode.RD}),
    A10("Medical Center", new LineCode[]{LineCode.RD}),
    A09("Bethesda", new LineCode[]{LineCode.RD}),
    A08("Friendship Heights", new LineCode[]{LineCode.RD}),
    A07("Tenleytown-AU", new LineCode[]{LineCode.RD}),
    A06("Van Ness-UDC", new LineCode[]{LineCode.RD}),
    A05("Cleveland Park", new LineCode[]{LineCode.RD}),
    A04("Woodley Park-Zoo/Adams Morgan", new LineCode[]{LineCode.RD}),
    A03("Dupont Circle", new LineCode[]{LineCode.RD}),
    A02("Farragut North", new LineCode[]{LineCode.RD}),
    // A01 listed with C01 due to being same station but different platforms
    // B01 listed with F01 due to being same station but different platforms
    B02("Judiciary Square", new LineCode[]{LineCode.RD}),
    B03("Union Station", new LineCode[]{LineCode.RD}),
    // B35 is listed out of numerical order due to being an infill station
    B35("NoMa-Galludet U", new LineCode[]{LineCode.RD}),
    B04("Rhode Island Ave-Brentwood", new LineCode[]{LineCode.RD}),
    B05("Brookland-CUA", new LineCode[]{LineCode.RD}),
    // B06 listed with E06 due to being same station but different platforms
    B07("Taokma", new LineCode[]{LineCode.RD}),
    B08("Silver Spring", new LineCode[]{LineCode.RD}),
    B09("Forest Glen", new LineCode[]{LineCode.RD}),
    B10("Wheaton", new LineCode[]{LineCode.RD}),
    B11("Glenmont", new LineCode[]{LineCode.RD}),
    N12("Ashburn", new LineCode[]{LineCode.SV}),
    N11("Loudon Gateway", new LineCode[]{LineCode.SV}),
    N10("Washington Dulles Internatinoal Airport", new LineCode[]{LineCode.SV}),
    N09("Innovation Center", new LineCode[]{LineCode.SV}),
    N08("Herndon", new LineCode[]{LineCode.SV}),
    N07("Reston Town Center", new LineCode[]{LineCode.SV}),
    // N05 is skipped by api as far as I can tell. not sure why
    N06("Wiehle-Reston East", new LineCode[]{LineCode.SV}),
    N04("Spring Hill", new LineCode[]{LineCode.SV}),
    N03("Greensboro", new LineCode[]{LineCode.SV}),
    N02("Tysons", new LineCode[]{LineCode.SV}),
    N01("McLean", new LineCode[]{LineCode.SV}),
    C14("Eisenhower Avenue", new LineCode[]{LineCode.YL}),
    C15("Huntington", new LineCode[]{LineCode.YL});

    private final String displayName;
    private final LineCode[] lineCodes;

    StationCode(String name, LineCode[] lineCodes) {
        this.displayName = name;
        this.lineCodes = lineCodes;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(this.displayName + " (" + this.name() + ")");
        if (this.lineCodes.length >= 1) {
            output.append(" on the ");
            output.append(this.lineCodes[0].name());
            for (int i = 1; i < this.lineCodes.length; i++) {
                output.append(", ").append(this.lineCodes[i].name());
            }
            output.append(this.lineCodes.length > 1 ? " lines" : " line");
        }

        return output.toString();
    }
}
