import java.util.List;

public class ExchangeRatePrinter {

    public static void printExchangeRates(List<Rate> rates) {
        for (var rate : rates) {
            System.out.print(String.format("Exchange rate for %s: ask: %.4f, bid: %.4f", rate.getDate(), rate.getAsk(), rate.getBid()));
            System.out.print(String.format(", day to day change: ask: %.4f, bid: %.4f", rate.getAskChange(), rate.getBidChange()));
            System.out.println();
        }
    }
}
