package trabalhoAv1;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class GiphyAPI {
	 java
	  

	   public class GiphyAPI {
	       private static final String API_KEY = "sua_chave_api";

	       public static void searchGif(String query) {
	           String url = "https://api.giphy.com/v1/gifs/search?api_key=j1EwkuvkfRQ0jEtrsIjhBmNdIBxayzkw" + API_KEY + "&q=" + query;
	           HttpResponse<JsonNode> response = Unirest.get(url)
	                   .header("accept", "application/json")
	                   .queryString("limit", "5")
	                   .asJson();

	           System.out.println(response.getBody().toString());
	       }

	       public static void main(String[] args) {
	           searchGif("funny cat");
	       }
	   }
}
