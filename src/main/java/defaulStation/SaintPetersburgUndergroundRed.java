package defaulStation;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public enum  SaintPetersburgUndergroundRed {
    DEVJATKINO("Девяткино"),
    GRAJDANSKII_PROSPEKT("Гражданский проспект"),
    AKADEMICHESKAJA("Академическая"),
    POLITEXNICHESKAJA("Политехническая"),
    MUGESTVA("Площадь Мужества"),
    LESNAJA("Лесная"),
    VIBORGSKAJA("Выборгская"),
    LENINA("Ленина"),
    VOSSTANIJA(SaintPetersburgUndergroundGreen.VOSTANIJA.getStation()),
    DOSTOEVSKAJA(SaintPetersburgUndergroundOrange.DOSTOEVSKAJA.getStation()),
    PUSHKINSKAJA(SaintPetersburgUndergroundPurple.PUSHKINSKAJA.getStation()),
    TEHNOLOJKA(SaintPetersburgUndergroundBlue.TECHNOLOJKA.getStation()),
    BALTIISKAJA("Балтийская"),
    NARVSKAJA("Нарвская"),
    KIROVSKII_ZAVOD("Кировский завод"),
    AVTOVO("Автово"),
    LENINSKII_PROSPEKT("Ленинский проспект"),
    PROSPECT_VETERANOV("Проспект Ветеранов");


    private final String station;

    SaintPetersburgUndergroundRed(String station) {
        this.station = station;
    }

    public String getStation() {
        return station;
    }
}
