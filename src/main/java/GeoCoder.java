import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GeoCoder {
	private static String token = 
			"/*insert token here*/";
	
	//Returns latitude and longitude of search.
	public static String getLatLong(String search) {
		
		String json = getJSON(search);
		
		JsonParser parse = new JsonParser();
		
		JsonObject obj = parse.parse(json).getAsJsonObject();
		
		JsonArray features = obj.getAsJsonArray("features");
		
		JsonArray coordinates = features.get(0).getAsJsonObject().getAsJsonArray("center");
		
		return "[" + coordinates.get(1).toString() + "," + coordinates.get(0).toString() +"]";	//reverse output of jsonarray to get lat and long
	}
	
	//Downloads json data
	private static String getJSON(String search) {
		search = search.replace(" ", "%20");
		String preurl = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + search + ".json?access_token="
				+ token;
		
		try {
			URL url = new URL(preurl);
			URLConnection con = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF8"));
			
			StringBuilder sb = new StringBuilder();
			
			String line;
			
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			
			return sb.toString();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
