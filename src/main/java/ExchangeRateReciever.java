import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateReciever {

    private JSONArray ratesFromJSON;

    public void getData(String from, String to) throws IOException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format("http://api.nbp.pl/api/exchangerates/rates/c/usd/%s/%s", from, to)))
                .GET()
                .build();
        try {
            HttpResponse response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(response.body().toString());
            ratesFromJSON = jsonObject.getJSONArray("rates");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public List<Rate> parseData() {
        List<Rate> rates = new ArrayList<>();
        for (var rate : ratesFromJSON) {
            var rateJSON = new JSONObject(rate.toString());
            var myRate = new Rate(
                    rateJSON.getString("effectiveDate"),
                    rateJSON.getFloat("bid"),
                    rateJSON.getFloat("ask")
            );
            rates.add(myRate);
        }
        return rates;
    }
}
