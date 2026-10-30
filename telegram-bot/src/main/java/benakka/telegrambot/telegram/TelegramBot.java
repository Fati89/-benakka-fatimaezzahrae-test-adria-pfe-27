package benakka.telegrambot.telegram;

import benakka.telegrambot.agents.AiAgent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import jakarta.annotation.PostConstruct;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.token}")
    private String telegramBotToken;

    private final AiAgent aiAgent; // ⚠️ Vérifiez le nom exact (AiAgent ou AIAgent)

    public TelegramBot(@Value("${telegram.token}") String telegramBotToken, AiAgent aiAgent) {
        super(telegramBotToken);
        this.telegramBotToken = telegramBotToken;
        this.aiAgent = aiAgent;
    }

    @Override
    public String getBotUsername() {
        // ⚠️ Remplacez par le @username de votre bot (sans le @)
        return "votre_nom_de_bot";
    }

    @PostConstruct
    public void registerTelegramBot() {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(this);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (!update.hasMessage() || !update.getMessage().hasText()) return;

            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            sendTyping(chatId);

            String answer = aiAgent.chat(messageText);

            sendText(chatId, answer);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void sendTyping(Long chatId) {
        SendChatAction action = new SendChatAction();
        action.setChatId(chatId.toString());
        action.setAction(ActionType.TYPING);
        try {
            execute(action);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendText(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}