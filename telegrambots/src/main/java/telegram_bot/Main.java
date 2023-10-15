package telegram_bot;

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
            System.out.println(message_text);

            SendMessage message = SendMessage.builder()
                    .chatId(chat_id.toString()) //Who are we sending a message to
                    .text(message_text).build(); 
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
  }
}

}

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
        System.out.println("Hello world!");
    }
}