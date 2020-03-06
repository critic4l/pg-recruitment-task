import java.io.IOException;

public class App {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();

        userInput.getDateFromFromInput();
        userInput.getDateToFromInput();

        ExchangeRateReciever exchangeRateReciever = new ExchangeRateReciever();
        try {
            exchangeRateReciever.getData(userInput.getDateFrom(), userInput.getDateTo());
        } catch (IOException e) {
            System.out.println(e);
        }

        ExchangeRatePrinter.printExchangeRates(exchangeRateReciever.parseData());

    }
}
