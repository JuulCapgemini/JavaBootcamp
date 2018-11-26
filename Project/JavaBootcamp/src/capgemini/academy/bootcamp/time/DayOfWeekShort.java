package capgemini.academy.bootcamp.time;

public enum DayOfWeekShort {
    MONDAY("Ma"),
    TUESDAY("Di"),
    WEDNESDAY("Wo"),
    THURSDAY("Do"),
    FRIDAY("Vr"),
    SATURDAY("Za"),
    SUNDAY("Zo"),
    NODAY("NODAY");

    private String name;

    DayOfWeekShort(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    static public DayOfWeekShort of(int i) {
        DayOfWeekShort dayOfWeek;
        switch (i) {
            case 1:
                dayOfWeek = DayOfWeekShort.MONDAY;
                break;
            case 2:
                dayOfWeek = DayOfWeekShort.TUESDAY;
                break;
            case 3:
                dayOfWeek = DayOfWeekShort.WEDNESDAY;
                break;
            case 4:
                dayOfWeek = DayOfWeekShort.THURSDAY;
                break;
            case 5:
                dayOfWeek = DayOfWeekShort.FRIDAY;
                break;
            case 6:
                dayOfWeek = DayOfWeekShort.SATURDAY;
                break;
            case 7:
                dayOfWeek = DayOfWeekShort.SUNDAY;
                break;
            default:
                dayOfWeek = DayOfWeekShort.NODAY;
                break;
        }

        return dayOfWeek;
    }
}
