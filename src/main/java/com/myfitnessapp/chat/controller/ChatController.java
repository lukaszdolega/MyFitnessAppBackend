package com.myfitnessapp.chat.controller;

import com.myfitnessapp.chat.model.Chat;
import com.myfitnessapp.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/chats")
    public Chat createChat(@RequestBody Chat chat) {
        return chatService.createChat(chat);
    }
}