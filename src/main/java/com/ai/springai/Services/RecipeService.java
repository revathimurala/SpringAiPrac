package com.ai.springai.Services;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {
    GoogleGenAiChatModel chatModel;

    public RecipeService(GoogleGenAiChatModel chatModel) {

        this.chatModel = chatModel;
    }
    public String createRecipe(String ingredients,
                               String cuisine,
                               String dietaryRestrictions){
        String template= """
                Create a clean and detailed recipe using:
                
                Ingredients: {ingredients}
                Cuisine: {cuisine}
                Dietary Restrictions: {dietaryRestrictions}
                
                Include:
                - Recipe title
                - Ingredients list
                - Step-by-step instructions
                in text format not in html format
                
                \s
               \s""";
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params=Map.of(
                "ingredients",ingredients,
                "cuisine",cuisine,
                "dietaryRestrictions",dietaryRestrictions
        );
        Prompt prompt = promptTemplate.create(params);
        return chatModel.call(prompt).getResult().getOutput().getText();
    }
}
