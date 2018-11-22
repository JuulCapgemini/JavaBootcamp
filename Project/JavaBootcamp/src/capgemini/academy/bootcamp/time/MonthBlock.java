package capgemini.academy.bootcamp.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

public class MonthBlock extends capgemini.academy.bootcamp.time.CalenderText {

    private int month;
    private String monthName;
    private int year = 2018;
    private LocalDate startOfMonth;
    private String[] monthDays;
    private String title;
    private final int titleWidth = 26;
    private final int blockWidth = 32;

    public MonthBlock(int monthNr) {
        month = monthNr;
        monthName = Month.of(monthNr).toString();
        monthName = CapitalStart(monthName);
        monthDays = new String[4];
        startOfMonth = LocalDate.of(year, monthNr, 1);

        MonthTitle();
        MonthContent();

    }

    private void MonthTitle() {
        StringBuilder sbTitle = new StringBuilder(monthName);

        sbTitle = SetLengthString(sbTitle, titleWidth);

        sbTitle.append(year);
        sbTitle.append("  ");//gap between blocks
        title = sbTitle.toString();
        //System.out.println(title);
    }

    private void MonthContent() {
        YearMonth thisMonth = YearMonth.of(year, month);
        int daysInMonth = thisMonth.lengthOfMonth();

        StringBuilder sbMonthDays = new StringBuilder();
        int j = 0;
        int k = 0;
        for (int i = 1; i <= daysInMonth; i++) {
            //Same sized strings
            if (i < 10)
                sbMonthDays.append("0");
            sbMonthDays.append(i);
            sbMonthDays.append("  ");

            //New line
            if (j >= 7/*Math.round(daysInMonth/monthDays.length)*/) {
                j = 0;
                sbMonthDays = SetLengthString(sbMonthDays, blockWidth);
                monthDays[k] = sbMonthDays.toString();
                sbMonthDays.delete(0, sbMonthDays.length());
                k++;
            } else
                j++;
        }
        //Unfinished lists
        if (j != 0) {
            sbMonthDays = SetLengthString(sbMonthDays, blockWidth);
            monthDays[k] = sbMonthDays.toString();
        }
    }

    private StringBuilder SetLengthString(StringBuilder sbText, int stringLength) {
        while (sbText.length() < stringLength)
            sbText.append(" ");

        return sbText;
    }

    public String GetTitle() {
        return title;
    }

    public String[] GetMonthDays() {
        return monthDays;
    }
}
