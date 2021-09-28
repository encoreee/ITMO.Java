import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

import jsonResponse.*;

public class Bot extends TelegramLongPollingBot {

    public Bot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotUsername() {
        return "@weatheralexraykov_bot";
    }

    @Override
    public String getBotToken() {
        return "2014200237:AAF93pWFmiLaglyFPO2fM410inS24znVWjY";
    }


    public void onUpdateReceived(Update update) {

        WeatherRequest weatherRequest = new WeatherRequest();

        if (update.hasMessage() && update.getMessage().hasText()) {

            Message message = update.getMessage();
            String message_text = message.getText();
            switch (message_text) {
                case "/start" -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Hello, this is Alex's weather bot\n");
                    stringBuilder.append("Type your region to know forecast\n");

                    message.setText(stringBuilder.toString());
                }
                default -> {
                    String response = null;
                    try {
                        response = weatherRequest.makeRequest(message_text);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    WeatherResponse weatherResponse = gson.fromJson(response.toString(), WeatherResponse.class);

                    try {
                        execute((SendMessage.builder()
                                .chatId(message.getChatId().toString())
                                .text(regionReply(weatherResponse))
                                .build()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static String regionReply(WeatherResponse response) {

        StringBuilder weatherDesc = new StringBuilder();
        for (Weather weather : response.getWeather()) {
            weatherDesc.append(weather.getDescription());
        }

        String locationName = response.getName();
        long temp = Math.round(response.getMain().getTemp());
        long windSpeed = Math.round(response.getWind().getSpeed());
        Integer humidity = response.getMain().getHumidity();
        long pressure = Math.round((response.getMain().getPressure() * 0.75));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Region: " + locationName + "\n");
        stringBuilder.append("Temperature: " + (293 - temp) + "\n");
        stringBuilder.append("Wind: " + windSpeed + "\n");
        stringBuilder.append("Humidity: " + humidity + "\n");
        stringBuilder.append("Pressure: " + pressure + "\n");

        return stringBuilder.toString();
    }
}