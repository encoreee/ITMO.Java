import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherRequest {

    public String makeRequest(String location) throws IOException {

        StringBuilder weatherCall = new StringBuilder();

        weatherCall.append("q=");
        weatherCall.append(location);
        weatherCall.append("&");
        weatherCall.append("lang=ru&");
        weatherCall.append("appid=fc3cd123bc29efe2fc92c6400250a878");

        weatherCall.toString();
        System.out.println(weatherCall.toString());

        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?" + weatherCall.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        connection.disconnect();
        return response.toString();
    }

}
