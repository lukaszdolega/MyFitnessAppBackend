package com.myfitnessapp.chat.service;

import com.myfitnessapp.chat.model.Chat;
import com.myfitnessapp.chat.repository.ChatRepository;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final OpenAiApiService openService;
    private final ChatRepository chatRepository;

    public Chat createChat(Chat chat) {
        String question = chat.getQuestion();
        String response = askChatGpt(question);
        chat.setResponse(response);
        return chatRepository.save(chat);
    }

    private String askChatGpt(String question) {
        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .messages(List.of(new ChatMessage("user", question)))
                .model("gpt-3.5-turbo")
                .build();
        List<ChatCompletionChoice> choices = openService.getOpenAiService().createChatCompletion(completionRequest).getChoices();

        StringBuilder stringBuilder = new StringBuilder();

        choices.stream()
                .map(ChatCompletionChoice::getMessage)
                .map(ChatMessage::getContent)
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
