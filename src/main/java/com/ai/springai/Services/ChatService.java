package com.ai.springai.Services;

//import org.springframework.ai.chat.model.ChatModel;
import org.checkerframework.checker.units.qual.Temperature;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final GoogleGenAiChatModel chatModel;

    public ChatService(GoogleGenAiChatModel chatModel) {

        this.chatModel =chatModel;

    }

    public String getResponse(String prompt){

        return chatModel.call(prompt);

    }

    public ChatResponse getResponseOptions(String prompt){

        GoogleGenAiChatOptions options =
                GoogleGenAiChatOptions.builder()
                        .temperature(0.4)
                        .build();

        return chatModel.call(new Prompt(prompt, options));
    }
}
