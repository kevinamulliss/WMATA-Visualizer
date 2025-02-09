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
    E01("Mt Vernon Sq 7th St-Convention Center", new LineCode[]{LineCode.GR, LineCode.YL}),
    E02("Shaw-Howard U", new LineCode[]{LineCode.GR}),
    E03("U Street/African-Amer Civl War Memorial/Cardozo", new LineCode[]{LineCode.GR}),
    E04("Columbia Heights", new LineCode[]{LineCode.GR}),
    E05("Georgia Ave-Petworth", new LineCode[]{LineCode.GR}),
    E06("Fort Totten", new LineCode[]{LineCode.GR}),
    E07("West Hyattsville", new LineCode[]{LineCode.GR}),
    E08("Hyattsville Crossing", new LineCode[]{LineCode.GR}),
    E09("College Park-U of Md", new LineCode[]{LineCode.GR}),
    E10("Greenbelt", new LineCode[]{LineCode.GR}),
    K08("Vienna/Fairfax-GMU")


    private final String name;
    private final LineCode[] lineCodes;

    StationCode(String name, LineCode[] lineCodes) {
        this.name = name;
        this.lineCodes = lineCodes;
    }
}
