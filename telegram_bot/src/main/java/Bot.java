import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by Denis Berezanskiy on 13.03.2018.
 */
public class Bot extends TelegramLongPollingBot
{
    final String helpCommand = "/help";
    final String startCommand = "/start";
    final String stopCommand = "/stop";
    static String searchUrl;
    
    @Override
    public void onUpdateReceived(Update update)
    {
        if (update.hasMessage() && update.getMessage().hasText())
        {
            
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equalsIgnoreCase(helpCommand))
            {
                String helpAnswer = "Available commands: \n" + "/start - start sending ads \n" + "/stop  - stop sending ads \n" + "/help  - view list of commands. \n" + "To begin get latest ads from me  - " + "please send me a search link from olx ua fallowing after /start command.";
                SendMessage message = new SendMessage().setChatId(chat_id).setText(helpAnswer);
                try
                {
                    execute(message);
                }
                catch (TelegramApiException e)
                {
                    e.printStackTrace();
                }
            }
            else if (message_text.equalsIgnoreCase(startCommand) || message_text.equalsIgnoreCase(stopCommand))
            {
                String startAnswer = "Will be implemented soon";
                SendMessage message = new SendMessage().setChatId(chat_id).setText(startAnswer);
                try
                {
                    execute(message);
                }
                catch (TelegramApiException e)
                {
                    e.printStackTrace();
                }
            }
            else if (message_text.contains("https://"))
            {
                searchUrl = message_text;
                String afterLinkAnswer = "Хорошая ссылка,работать по ней я конечно не буду :)";
                SendMessage message = new SendMessage().setChatId(chat_id).setText(afterLinkAnswer);
                try
                {
                    execute(message);
                }
                catch (TelegramApiException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                SendMessage message = new SendMessage().setChatId(chat_id).setText("Sorry, you doing something wrong . Try to use /help command to know more .");
                try
                {
                    execute(message);
                }
                catch (TelegramApiException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public String getBotUsername()
    {
        
        return "your_adverts_bot";
    }
    
    @Override
    public String getBotToken()
    {
        
        return "495934068:AAH_9kRnx1vhztUZJpaRw3FZXXIlIoREzo8";
    }
    
}
