import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInput {

    private String dateFrom;
    private String dateTo;

    private DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private Scanner scanner = new Scanner(System.in);

    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public String getDateFromInput() throws ParseException {
        System.out.println("Enter date in provided format yyyy-MM-dd: ");
        String inputDate = scanner.nextLine();
        Date date = sdf.parse(inputDate);
        return sdf.format(date);
    }

    public void getDateFromFromInput() {
        System.out.println("Enter the date from which you want to receive USD exchange rates");
        try {
            dateFrom = getDateFromInput();
            checkDateAfterToday(sdf.parse(dateFrom));
        } catch (IllegalDateException | ParseException e) {
            e.printStackTrace();
            getDateFromFromInput();
        }
    }

    public void getDateToFromInput() {
        System.out.println("Enter the date to which you want to receive USD exchange rates");
        try {
            dateTo = getDateFromInput();
            checkDateToLowerThanFrom();
        } catch (IllegalDateException | ParseException e) {
            e.printStackTrace();
            getDateToFromInput();
        }
    }

    public void checkDateAfterToday(Date dateToCheck) throws IllegalDateException {
        Date today = new Date();
        if (dateToCheck.after(today)) {
            throw new IllegalDateException("Provided date did not happen yet, please insert valid one");
        }
    }

    public void checkDateToLowerThanFrom() throws IllegalDateException, ParseException {
        if (sdf.parse(dateFrom).after(sdf.parse(dateTo))) {
            throw new IllegalDateException("Provided date happens before starting date, please insert valid one");
        }
    }
}
