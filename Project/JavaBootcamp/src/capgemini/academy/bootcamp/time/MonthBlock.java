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
        //Make sure there is no null but just spaces
        for (int i = 0; i < monthDays.length; i++) {
            monthDays[i] = "  ";
        }
        for (int i = 1; i <= daysInMonth; i++) {

            //Clear stringbuilder
            sbMonthDays.delete(0, sbMonthDays.length());
            //Get previous string
            sbMonthDays.append(monthDays[j]);
            //String of blockwidth length
            sbMonthDays = SetLengthString(sbMonthDays, blockWidth);//TODO: maybe only at the end conversions back n forth?
            //Same sized strings
            if (i < 10)
                sbMonthDays.append("0");
            sbMonthDays.append(i);
            sbMonthDays.append("  ");
            monthDays[j] = sbMonthDays.toString();


            //New line
            if (j > 2/*Math.round(daysInMonth/monthDays.length)*/) {
                j = 0;
            } else
                j++;
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
