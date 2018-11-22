package capgemini.academy.bootcamp.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeTest {
    public TimeTest() {
        LocalDate date = LocalDate.of(2018, Month.NOVEMBER, 22);
        System.out.println(date);

        LocalTime time = LocalTime.of(9, 0);
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);

        LocalDate localDate = date.plusYears(50);
        System.out.println("Assigned plusyear 50: " + localDate);
        localDate = localDate.plusDays(4);
        localDate = localDate.plusWeeks(7);
        localDate = localDate.plusMonths(2);
        System.out.println(localDate);

        LocalTime localTime = time.plusHours(2);
        localTime = localTime.plusMinutes(114);
        System.out.println(localTime + "\n");
        System.out.println("Current date and time: ");
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());


        System.out.println(Period.between(date, localDate));
        Period period = Period.ofYears(2);

        System.out.println(date.plus(period));

        Duration duration = Duration.between(time, localTime);
        System.out.println(duration);
        time.plus(duration);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd   MMMM   yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(dateFormatter.format(localDate));
        System.out.println(timeFormatter.format(localTime));
        dateFormatter = DateTimeFormatter.ofPattern("d   MMM   yy");
        System.out.println(dateFormatter.format(localDate));
        System.out.println(timeFormatter.format(localTime));
        dateFormatter = DateTimeFormatter.ofPattern("dd - MM - yyy");
        System.out.println(dateFormatter.format(localDate));

        System.out.println("Parse: ");
        dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parseDate = LocalDate.parse("14-02-1995", dateFormatter);
        System.out.println(parseDate);

        LocalTime parseTime = LocalTime.parse("23:23:55", timeFormatter);
        System.out.println(parseTime);
    }
}
