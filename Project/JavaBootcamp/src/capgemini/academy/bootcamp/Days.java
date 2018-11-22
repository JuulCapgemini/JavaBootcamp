package capgemini.academy.bootcamp;

public enum Days {
    MONDAY ("Maandag"),
    TUESDAY ("Dinsdag"),
    WEDNESDAY ("Woensdag"),
    THURSDAY ("Donderdag"),
    FRIDAY ("Vrijdag"),
    SATURDAY ("Zaterdag"),
    SUNDAY ("Zondag");

    private String name;

    Days(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}