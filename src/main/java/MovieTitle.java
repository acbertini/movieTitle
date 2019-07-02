

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieTitle {
	
	public static void main(String[] args) throws Exception {
		
		MovieTitle http = new MovieTitle();
		for (String valueString : args) {
			http.sendGet(valueString);
		}
		
	}

	private void sendGet(String substr) throws Exception {

		int pageNumber = 1;
		int totalPageNumbers = Integer.MAX_VALUE;
		List<String> titles = new ArrayList<String>();
		
		while (pageNumber <= totalPageNumbers) {

			String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + pageNumber;

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONObject myResponse = new JSONObject(response.toString());
			JSONArray arr = myResponse.getJSONArray("data");
			totalPageNumbers = myResponse.getInt("total_pages");

			ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();

			for (int i = 0; i < arr.length(); i++) {
				JSONObject json = arr.getJSONObject(i);
				arrays.add(json);

				String title = json.get("Title").toString();
				titles.add(title);

			}
			pageNumber++;
		}

		Collections.sort(titles);
		for (int i = 0; i < titles.size(); i++) {
			System.out.println(titles.get(i));
		}	
	}
}

