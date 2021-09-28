package lesson13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Scanner;


public class MyRequest {
    public static void main(String[] argv) throws IOException {
        String url = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";

        System.out.println("Search for:");
        Scanner input = new Scanner(System.in);
        String searchQuery = url + input.next();

        URL obj = new URL(searchQuery);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        WikiResponse wikiResponse = gson.fromJson(response.toString(), WikiResponse.class);
        Query query = wikiResponse.getQuery();
        List<Search> searches = query.getSearch();

        System.out.println(searches);

    }
}