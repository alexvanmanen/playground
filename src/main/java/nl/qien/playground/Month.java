package nl.qien.playground;

public enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE;

    public Month findByOrdinal(int i) {
        for(Month month: Month.values()) {
            if(month.ordinal() == i) {
                return month;
            }
        }

        return null;
    }
}
