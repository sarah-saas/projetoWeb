/*package trabalhoAv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class GiphyAPI {
    private static final String API_KEY = "AIzaSyB-Owztw2M8nPOGxmv_HMYDLY6gTrpY35I";

    public static void searchGif(String query) {
        String url = "https://api.tenor.com/v1/gifs/search?api_key=" + API_KEY + "&q=" + query;

        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = reader.lines().collect(Collectors.joining("\n"));
                reader.close();

                System.out.println(response);
            } else {
                System.err.println("Falha na solicitação: " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro durante a solicitação HTTP:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        searchGif("penguin");
    }
}

*/
import android.app.Application;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class App extends Application {

    private static final String API_KEY = "AIzaSyB-Owztw2M8nPOGxmv_HMYDLY6gTrpY35I";
    private static final String CLIENT_KEY = "my_test_app"
    private static final String LogTag = "TenorTest";

    @Override
    public void onCreate() {
        super.onCreate();

        new Thread() {
            @Override
            public void run() {

                final String searchTerm = "excited";

                // make initial search request for the first 8 items
                JSONObject searchResult = getSearchResults(searchTerm, 8);

                // load the results for the user
                Log.v(LogTag, "Search Results: " + searchResult.toString());

            }
        }.start();
    }

    /**
     * Get Search Result GIFs
     */
    public static JSONObject getSearchResults(String searchTerm, int limit) {

        // make search request - using default locale of EN_US

        final String url = String.format("https://tenor.googleapis.com/v2/search?q=%1$s&key=%2$s&client_key=%3$s&limit=%4$s",
                searchTerm, API_KEY, CLIENT_KEY, limit);
        try {
            return get(url);
        } catch (IOException | JSONException ignored) {
        }
        return null;
    }

    /**
     * Construct and run a GET request
     */
    private static JSONObject get(String url) throws IOException, JSONException {
        HttpURLConnection connection = null;
        try {
            // Get request
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            // Handle failure
            int statusCode = connection.getResponseCode();
            if (statusCode != HttpURLConnection.HTTP_OK && statusCode != HttpURLConnection.HTTP_CREATED) {
                String error = String.format("HTTP Code: '%1$s' from '%2$s'", statusCode, url);
                throw new ConnectException(error);
            }

            // Parse response
            return parser(connection);
        } catch (Exception ignored) {
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return new JSONObject("");
    }

    /**
     * Parse the response into JSONObject
     */
    private static JSONObject parser(HttpURLConnection connection) throws JSONException {
        char[] buffer = new char[1024 * 4];
        int n;
        InputStream stream = null;
        try {
            stream = new BufferedInputStream(connection.getInputStream());
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
            StringWriter writer = new StringWriter();
            while (-1 != (n = reader.read(buffer))) {
                writer.write(buffer, 0, n);
            }
            return new JSONObject(writer.toString());
        } catch (IOException ignored) {
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ignored) {
                }
            }
        }
        return new JSONObject("");
    }
}
