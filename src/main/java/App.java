import java.io.IOException;

public class App {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();

        userInput.getDateFromFromInput();
        userInput.getDateToFromInput();

        Http http = new Http();
        try {
            http.getData(userInput.getDateFrom(), userInput.getDateTo());
        } catch (IOException e) {
            System.out.println(e);
        }

        ExchangeRatePrinter.printExchangeRates();

    }
}
