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

    public String getDateFromInput() {
        System.out.println("Prosze podac date w formacie yyyy-MM-dd: ");
        String inputDate = scanner.nextLine();
        return inputDate;
    }

    public void getDateFromFromInput() {
        System.out.println("Wprowadz date od ktorej chcesz otrzymac kursy USD");
        dateFrom = getDateFromInput();
        try {
            checkDateAfterToday(sdf.parse(dateFrom));
        } catch (IllegalDateException | ParseException e) {
            e.printStackTrace();
            getDateFromFromInput();
        }
    }

    public void getDateToFromInput() {
        System.out.println("Wprowadz date do ktore chcesz otrzymac kursy USD");
        dateTo = getDateFromInput();
        try {
            checkDateToLowerThanFrom();
        } catch (IllegalDateException e) {
            e.printStackTrace();
            getDateToFromInput();
        }
    }

    public void checkDateAfterToday(Date dateToCheck) throws IllegalDateException {
        Date today = new Date();
        if (dateToCheck.after(today)) {
            throw new IllegalDateException("Wprowadzono date ktora jeszcze sie nie wydarzyla");
        }
    }

    public void checkDateToLowerThanFrom() throws IllegalDateException {
        try {
            if (sdf.parse(dateFrom).after(sdf.parse(dateTo))) {
                throw new IllegalDateException("Wprowadzono date wystepujaca przed data od kiedy mam szukac");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
