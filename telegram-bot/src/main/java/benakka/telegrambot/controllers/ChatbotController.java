package benakka.telegrambot.controllers;

import benakka.telegrambot.agents.AiAgent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatbotController {
    private AiAgent aiAgent;

    public ChatbotController(AiAgent aiAgent) {
        this.aiAgent = aiAgent;
    }

    @GetMapping(value = "/chat", produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(@RequestParam(name="query", defaultValue="Bonjour") String query) {
        return aiAgent.chat(query);
    }

    @GetMapping(value = "/chatStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> chatStream(@RequestParam(name="query", defaultValue="Bonjour") String query){
        return aiAgent.chatStream(query);
    }

}