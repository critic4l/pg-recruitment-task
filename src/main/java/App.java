import java.io.IOException;

public class App {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();

        userInput.getDateFromFromInput();
        userInput.getDateToFromInput();

        ExchangeRateReceiver exchangeRateReceiver = new ExchangeRateReceiver();
        try {
            if (exchangeRateReceiver.getData(userInput.getDateFrom(), userInput.getDateTo())) {
                ExchangeRatePrinter.printExchangeRates(exchangeRateReceiver.parseData());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
