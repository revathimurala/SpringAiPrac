package com.ai.springai.controllers;

import com.ai.springai.Services.ChatService;
import com.ai.springai.Services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    ChatService chatService;
//    ImageService imageService;
    RecipeService recipeService;
    public AiController(ChatService chatService, RecipeService recipeService) {

        this.chatService = chatService;
        this.recipeService = recipeService;
    }
//    public ChatController(RecipeService recipeService) {
//        this.recipeService = recipeService;
//    }

    @GetMapping("/chatai")
    public String getResponse(@RequestParam String prompt) {

        return chatService.getResponse(prompt);
    }
    @GetMapping("/recipeai")
    public String recipeCreator(@RequestParam String ingredients,
                                      @RequestParam(defaultValue="any") String cuisine,
                                      @RequestParam(defaultValue="") String dietaryRestrictions) {

        return recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions);
    }
}
