import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {

    public void getData(String from, String to) throws IOException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://api.nbp.pl/api/exchangerates/rates/c/usd/"+ from + "/" + to + "/"))
                .GET()
                .build();
        try {
            HttpResponse response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(response.body().toString());
            var test = jsonObject.getJSONArray("rates");
            System.out.println(test.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
