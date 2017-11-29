package defaulStation;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public enum SaintPetersburgUndergroundOrange {
    SPASSKAJA(SaintPetersburgUndergroundBlue.SPASSKAJA.getStation()),
    DOSTOEVSKAJA("Достоевская"),
    LIGOVSKII("Лиговский"),
    ALEKSANDRA_NEVSKOGO(SaintPetersburgUndergroundGreen.ALEKSANDRA_NEVSKOGO.getStation()),
    NOVOCHERKASKAJA("Новочеркаская"),
    LADOJSKAJA("Ладожская"),
    PROSPEKT_BOLSHEVIKOV("Проспект Большевиков"),
    DIBANKO("Дыбенко");

    private final String station;

    SaintPetersburgUndergroundOrange(String station) {
        this.station = station;
    }

    public String getStation() {
        return station;
    }
}
