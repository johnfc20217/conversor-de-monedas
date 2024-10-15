import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    private final int opcion;
    private final double cantidad;
    private final String url;
    private final String valores;
    private double resultado;

    public ApiRequest(int opcion, double cantidad) {
        this.opcion = opcion;
        this.cantidad = cantidad;
        this.valores = asignarValores(opcion);
        this.url = generarUrl(opcion, cantidad);
    }

    private String asignarValores(int opcion) {
        return switch (opcion) {
            case 1 -> "Dólar a Peso Colombiano.";
            case 2 -> "Peso Colombiano a Dólar";
            case 3 -> "Dólar a Real Brasileño";
            case 4 -> "Real Brasileño a Dólar";
            case 5 -> "Dólar a Peso Argentino";
            case 6 -> "Peso Argentino a Dóla";
            default -> "Opción no válida";
        };








    }

    private String generarUrl(int opcion, double cantidad) {
        return switch (opcion) {
            //https://v6.exchangerate-api.com/v6/1631737d50df1615f040fa18/latest/USD
            case 1 -> "https://v6.exchangerate-api.com/v6/1631737d50df1615f040fa18/latest/USD" + cantidad;
            //case 1 -> "https://v6.exchangerate-api.com/v6/510f47cef98309e1c058d381/pair/USD/ARS/" + cantidad;
            case 2 -> "https://v6.exchangerate-api.com/v6/1631737d50df1615f040fa18/latest/USD" + cantidad;
            case 3 -> "https://v6.exchangerate-api.com/v6/1631737d50df1615f040fa18/latest/USD/" + cantidad;
            case 4 -> "https://v6.exchangerate-api.com/v6/1631737d50df1615f040fa18/latest/USD" + cantidad;
            case 5 -> "https://v6.exchangerate-api.com/v6/1631737d50df1615f040fa18/latest/USD" + cantidad;
            case 6 -> "https://v6.exchangerate-api.com/v6/1631737d50df1615f040fa18/latest/USD" + cantidad;
            default -> "";
        };
    }

    public void llamadaRequest() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            ConsultaAPI consultaAPI = gson.fromJson(json, ConsultaAPI.class);
            this.resultado = consultaAPI.conversionResult();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la solicitud: " + e.getMessage());
        }
    }

    public String getValores() {
        return valores;
    }

    public double getResultado() {
        return resultado;
    }
}
