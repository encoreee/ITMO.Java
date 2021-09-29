
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
        if (update.hasMessage()) {
            try {
                handleMessage(update.getMessage());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleMessage(Message message) throws TelegramApiException {
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity = message.getEntities()
                    .stream()
                    .filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (commandEntity.isPresent()) {
                String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                switch (command) {

                    case "/start" -> {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Hello, this is Alex's weather bot\n");
                        stringBuilder.append("Type your region to know forecast\n");

                        message.setText(stringBuilder.toString());
                    }

                    case "/subscribe" -> {

                        String lastName = message.getChat().getLastName();
                        String name = message.getChat().getFirstName();
                        long chatId = message.getChatId();
                        String fullName = lastName.concat(" ").concat(name);

                        try {
                            DbHandler dbHandler = DbHandler.getInstance();
                            List<Subscribe> subscribes = dbHandler.getAllSubscreibes();

                            if(subscribes.isEmpty()){
                                dbHandler.addSubscribe(new Subscribe(0, fullName, chatId, true));
                                execute(
                                        SendMessage.builder()
                                                .text("Subscribed")
                                                .chatId(message.getChatId().toString()).build());
                            }

                            for (Subscribe subscribe : subscribes) {


                                if (subscribe.id == chatId && subscribe.enable == true) {
                                    execute(
                                            SendMessage.builder()
                                                    .text("Already subscribed")
                                                    .chatId(message.getChatId().toString()).build());
                                } else {
                                    dbHandler.addSubscribe(new Subscribe(0, fullName, chatId, true));
                                    execute(
                                            SendMessage.builder()
                                                    .text("Subscribed")
                                                    .chatId(message.getChatId().toString()).build());
                                }
                            }

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }

                    case "/unsubscribe" -> {

                        long chatId = message.getChatId();

                        try {
                            DbHandler dbHandler = DbHandler.getInstance();
                            List<Subscribe> subscribes = dbHandler.getAllSubscreibes();
                            for (Subscribe subscribe : subscribes) {
                                if (subscribe.telegram_id == chatId && subscribe.enable == true) {
                                    dbHandler.deleteSubscribe(chatId);
                                    execute(
                                            SendMessage.builder()
                                                    .text("Unsubscribed")
                                                    .chatId(message.getChatId().toString()).build());
                                } else {
                                    execute(
                                            SendMessage.builder()
                                                    .text("You are not subscribed")
                                                    .chatId(message.getChatId().toString()).build());
                                }
                            }

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }


                    }
                }
            }
        }

        if (!message.hasEntities()) {

            String message_text = message.getText();
            switch (message_text) {

                default -> {
                    WThread wThread = new WThread("WeatherThread");
                    wThread.setMessage(message_text);
                    wThread.start();
                    try {
                        wThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    WeatherResponse weatherResponse = wThread.getResponse();

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

    public static void executeSchedule(){}
}