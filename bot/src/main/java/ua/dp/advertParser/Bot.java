package ua.dp.advertParser;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.logging.BotLogger;
import org.telegram.telegrambots.logging.BotsFileHandler;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

/**
 * Created by Denis Berezanskiy on 06.05.2018.
 */
//TODO : implement getting chatID and assign it into sendAdvertUrl() method
//TODO : attach chatId to User entity
public class Bot extends TelegramLongPollingBot
{
    private static final String LOGTAG_MAIN = "Main";
    private static final String LOGTAG_SEND_METHOD = "sendAdvertUrl() method";
    private static final String LOGTAG_UPDATE_RECEIVED = "onUpdateReceived() method";
    //TODO : replace to property file
    private final String BOT_TOKEN = "565078387:AAFUpv0SlYcHtcQ-HVB0wBA5VKPJtVNopRo";
    private final String BOT_NAME = "AdvertBot";
    
    
    @Override
    public void onUpdateReceived(Update update)
    {
        if (update.hasMessage() && update.getMessage().hasText())
        {
            if (update.getMessage().getText().equalsIgnoreCase("/start"))
            {
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                message.setText("Hello! Now I'm waiting for your search link" + update.getMessage().getChatId());
                try
                {
                    execute(message);
                }
                catch (TelegramApiException e)
                {
                    BotLogger.severe(LOGTAG_UPDATE_RECEIVED, e);
                }
            }
        }
    }
    
    @Override
    public String getBotUsername()
    {
        return BOT_NAME;
    }
    
    @Override
    public String getBotToken()
    {
        return BOT_TOKEN;
    }
    
    public void sendAdvertUrl(String url)
    {
        String link = url;
        //TODO : unhardcode getting chatID
        long chatId = 384614985;
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(url);
        
        try
        {
            execute(message);
        }
        catch (TelegramApiException e)
        {
            BotLogger.severe(LOGTAG_SEND_METHOD, e);
        }
        
    }
    public static void botInitialize()
    {
        BotLogger.setLevel(Level.ALL);
        BotLogger.registerLogger(new ConsoleHandler());
        try
        {
            BotLogger.registerLogger(new BotsFileHandler());
        }
        catch (IOException e)
        {
            BotLogger.severe(LOGTAG_MAIN, e);
        }
        ApiContextInitializer.init();
        
        TelegramBotsApi api = new TelegramBotsApi();
        try
        {
            api.registerBot(new Bot());
            
        }
        catch (TelegramApiRequestException e)
        {
            e.printStackTrace();
        }
        System.out.println("\n BOT SUCCESSFULLY STARTED \n");
    }
}