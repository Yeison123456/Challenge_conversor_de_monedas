import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/b664c1e45917f07c53412e5a/latest/";

    public String hacerConversion(String moneda, String monedaSalida, double cantidad) {
        String ruta = API_URL + moneda;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ruta))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson= new Gson();
                JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
                jsonObject= (JsonObject) jsonObject.get("conversion_rates");
                var conversiones= jsonObject.get(monedaSalida);

                return STR."El valor \{cantidad} [\{moneda}] corresponde al valor final de =>> \{conversiones.getAsDouble() * cantidad} [\{monedaSalida}]";
            } else {
                System.err.println(STR."Error al realizar la solicitud: \{response.statusCode()}");
                return null;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
