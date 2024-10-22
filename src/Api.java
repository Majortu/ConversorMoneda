import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    private final String apiKey;
    private final HttpClient cliente;

    public Api(String apiKey) {
        this.apiKey = apiKey;
        this.cliente = HttpClient.newHttpClient();
    }

    public double getConversionRate(Money fromMoney, Money toMoney) throws Exception {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + fromMoney;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
        return conversionRates.get(toMoney.name()).getAsDouble();
    }

    public double convertir(Money fromMoney, Money toMoney, double monto) throws Exception {
        double rate = getConversionRate(fromMoney, toMoney);
        return monto * rate;
    }
}

