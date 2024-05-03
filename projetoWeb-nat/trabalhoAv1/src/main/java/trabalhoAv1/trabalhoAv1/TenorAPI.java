package trabalhoAv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import org.json.JSONObject;

public class TenorAPI {
    private static final String API_KEY = "AIzaSyB-Owztw2M8nPOGxmv_HMYDLY6gTrpY35I";

    public static void searchGif(String query) {
        String url = "https://g.tenor.com/v1/search?api_key=" + API_KEY + "&q=" + query + "&limit=10";

        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = reader.lines().collect(Collectors.joining());
                reader.close();

                // Vamos imprimir apenas o URL dos GIFs para manter o console limpo
                JSONObject jsonResponse = new JSONObject(response);
                jsonResponse.getJSONArray("results").forEach(item -> {
                    JSONObject gif = (JSONObject) item;
                    System.out.println(gif.getJSONObject("media").getJSONArray("gif").getJSONObject(0).getString("url"));
                });
            } else {
                System.err.println("Falha na solicitação: " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro durante a solicitação HTTP:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erro ao processar a resposta JSON:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        searchGif("penguin");
    }
}