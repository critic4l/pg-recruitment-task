import java.util.List;

public class ExchangeRatePrinter {

    public static void printExchangeRates(List<Rate> rates) {
        int counter = 0;
        for (var rate : rates) {
            System.out.print(String.format("Kurs dla dnia %s: ask: %.4f, bid: %.4f", rate.getDate(), rate.getAsk(), rate.getBid()));
            System.out.print(String.format(", zmiana wzgledem poprzedniego dnia: ask: %.4f, bid: %.4f", rate.getAskChange(), rate.getBidChange()));
            System.out.println();
        }
    }
}
