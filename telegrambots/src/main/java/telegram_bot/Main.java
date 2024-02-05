package telegram_bot;

import java.util.Scanner;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


class Bot extends TelegramLongPollingBot {
  @Override
  public String getBotUsername() {
      return "BotWise1000Bot";
  }

  @Override
  public String getBotToken() {
      return "6428731501:AAFKzXU8b5xplHCblFvciWoMX3IDVkLE3eo";
  }

   @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            Long chat_id = update.getMessage().getChatId();
            System.out.println(message_text + " " + chat_id);
            sendmess(chat_id, message_text);
        }
 }

 public void sendmess(Long id, String str){
    SendMessage message = SendMessage.builder()
                    .chatId(id.toString()) //Who are we sending a message to
                    .text(str).build(); 
    try {
        execute(message); // Sending our message object to user
    } catch (TelegramApiException e) {
        e.printStackTrace();
    }

 }

}

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        Scanner sc=new Scanner(System.in);
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();                 
        botsApi.registerBot(bot);
        String mssg;
        do{
            mssg=sc.nextLine();
            bot.sendmess(1997750877L, mssg);
            
        }while(mssg!="quite");     
        sc.close();
        
    }
}