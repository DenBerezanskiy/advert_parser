package ua.dp.advertParser.bot;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Contact;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.logging.BotLogger;
import org.telegram.telegrambots.logging.BotsFileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

/**
 * Created by Denis Berezanskiy on 06.05.2018.
 */
public class Bot extends TelegramLongPollingBot
{
    private BotService botService;
    
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
                askForPhoneNumber(update);
            }
        }
        if (update.hasMessage() && update.getMessage().hasContact())
        {
            Contact contact = update.getMessage().getContact();
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            Bot bot = (Bot) context.getBean("bot");
            bot.botService.attachChatIdToUser(contact, update.getMessage().getChatId());
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
    
    public void sendAdvertUrl(String url, long chatId)
    {
        String link = url;
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
            BotLogger.severe(LOGTAG_MAIN, e);
        }
        System.out.println("\n BOT SUCCESSFULLY STARTED \n");
    }
    
    public void setBotService(BotService botService) {this.botService = botService;}
    
    public BotService getBotService() { return botService; }
    
    private void askForPhoneNumber(Update update)
    {
        KeyboardButton kb = new KeyboardButton("Give me your phone number, ok?");
        kb.setRequestContact(true);
        
        SendMessage phone_req = new SendMessage();
        phone_req.setParseMode("Markdown");
        ReplyKeyboardMarkup rkm = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<KeyboardRow>();
        KeyboardRow row = new KeyboardRow();
        row.add(kb);
        rows.add(row);
        rkm.setKeyboard(rows);
        rkm.setOneTimeKeyboard(true);
        phone_req.setReplyMarkup(rkm);
        phone_req.setChatId(update.getMessage().getChatId());
        phone_req.setText("Press button to share your phone number");
        try
        {
            execute(phone_req);
        }
        catch (TelegramApiException e)
        {
            BotLogger.severe(LOGTAG_UPDATE_RECEIVED, e);
        }
    }
}