import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Servlet implementation class pesquisaGif
 */
public class pesquisaGif extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String API_KEY = "AIzaSyB-Owztw2M8nPOGxmv_HMYDLY6gTrpY35I"; // Substitua com a chave real da API Tenor

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public pesquisaGif() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query"); // Supõe-se que 'query' é o nome do parâmetro que contém o termo de busca.
		String jsonResponse = searchGif(query);
		HttpSession session = request.getSession();
		session.setAttribute("gifJsonResponse", jsonResponse);
		response.sendRedirect("giphy.jsp"); // Envie para giphy.jsp que irá processar a resposta JSON
	}

	/**
	 * Realiza a busca de GIFs usando a API do Tenor.
	 */
	private String searchGif(String query) throws IOException {
		String urlStr = "https://g.tenor.com/v1/search?api_key=" + API_KEY + "&q=" + query + "&limit=1";
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String response = reader.lines().collect(Collectors.joining());
			reader.close();
			connection.disconnect();

			// Opcional: Extraia a URL do primeiro GIF da resposta
			JSONObject jsonResponse = new JSONObject(response);
			JSONArray results = jsonResponse.getJSONArray("results");
			if (results.length() > 0) {
				String gifUrl = results.getJSONObject(0).getJSONArray("media").getJSONObject(0).getJSONObject("gif").getString("url");
				return gifUrl; // Retorna apenas a URL do GIF
			}
			return "No results found.";
		} else {
			throw new IOException("Failed to fetch GIF: " + connection.getResponseMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST logic can be added here if needed
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

