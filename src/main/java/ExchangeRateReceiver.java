import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateReceiver {

    private JSONArray ratesFromJSON;

    public void getData(String from, String to) throws IOException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format("http://api.nbp.pl/api/exchangerates/rates/c/usd/%s/%s", from, to)))
                .GET()
                .build();
        try {
            HttpResponse response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200) {
                JSONObject jsonObject = new JSONObject(response.body().toString());
                ratesFromJSON = jsonObject.getJSONArray("rates");
            } else {
                System.out.println("Couldn't fetch data from server, please try again later");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public List<Rate> parseData() {
        List<Rate> rates = new ArrayList<>();
        int counter = 0;
        for (var rate : ratesFromJSON) {
            var rateJSON = new JSONObject(rate.toString());
            var bid = rateJSON.getFloat("bid");
            var ask = rateJSON.getFloat("ask");
            var askChange = counter > 0 ? ask - rates.get(counter - 1).getAsk() : 0;
            var bidChange = counter > 0 ? bid - rates.get(counter - 1).getBid() : 0;
            var myRate = new Rate(
                    rateJSON.getString("effectiveDate"),
                    bid,
                    ask,
                    askChange,
                    bidChange);
            rates.add(myRate);
            counter++;
        }
        return rates;
    }
}
