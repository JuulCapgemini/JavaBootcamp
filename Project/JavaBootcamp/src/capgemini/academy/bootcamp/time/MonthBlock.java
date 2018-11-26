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

    private final int blockWidth = 24;
    private final int titleWidth = blockWidth - 6;//26;

    public MonthBlock(int monthNr) {
        month = monthNr;
        monthName = Month.of(monthNr).toString();
        monthName = CapitalStart(monthName);
        monthDays = new String[7];
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
            monthDays[i] = "";
        }
//i=1;
        //int k = 0;
        LocalDate firstOfMonth = LocalDate.of(year, month, 1);
        //System.out.println(firstOfMonth.getDayOfWeek());
        //System.out.println(firstOfMonth.getDayOfWeek().getValue());
        //System.out.println(Calendar.DAY_OF_WEEK_IN_MONTH);
        int printStart = firstOfMonth.getDayOfWeek().getValue();//1;
        int dayNr = 1;
        for (int i = 1; i <= 42; i++) {//35
            //Clear stringbuilder
            sbMonthDays.delete(0, sbMonthDays.length());
            //Get previous string
            sbMonthDays.append(monthDays[j]);
            //When to start printing
            if (i >= printStart && dayNr<=daysInMonth) {
                //Same sized strings
                if (dayNr < 10)
                    sbMonthDays.append("0");
                sbMonthDays.append(dayNr);
                sbMonthDays.append("  ");
                dayNr++;
            } else {
                sbMonthDays.append("  ");
                sbMonthDays.append("  ");
            }
            monthDays[j] = sbMonthDays.toString();


            //New line
            if (j > 5) {
                j = 0;
            } else
                j++;

        }

        //Loop through strings and set correct length
        StringBuilder buildMonthDays[] = new StringBuilder[monthDays.length];
        for (int i = 0; i < monthDays.length; i++) {
            buildMonthDays[i] = new StringBuilder(monthDays[i]);
            buildMonthDays[i] = SetLengthString(buildMonthDays[i], blockWidth);
            monthDays[i] = buildMonthDays[i].toString();
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
