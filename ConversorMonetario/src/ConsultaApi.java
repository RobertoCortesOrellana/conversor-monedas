import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import io.github.cdimascio.dotenv.Dotenv;

public class ConsultaApi {
    public Moneda buscaCambio(String cadena1, String cadena2){
        System.out.println("Cadena1= ****" + cadena1);
        System.out.println("Cadena2= ****" + cadena2);
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey +"/pair/" + cadena1 + "/" + cadena2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda de cambio.");
        }


    }
}
