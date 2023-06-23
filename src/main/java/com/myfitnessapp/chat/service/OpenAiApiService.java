package com.myfitnessapp.chat.service;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class OpenAiApiService {

    private final OpenAiService openAiService;
    private final String apiKey;

    @Autowired
    public OpenAiApiService(@Value("${openai.api.key}") String apiKey) {
        this.apiKey = apiKey;
        this.openAiService = new OpenAiService(apiKey, Duration.ofSeconds(30));
    }

    public OpenAiService getOpenAiService() {
        return openAiService;
    }
}

