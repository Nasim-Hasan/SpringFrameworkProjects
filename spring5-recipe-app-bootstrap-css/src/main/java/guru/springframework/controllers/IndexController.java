package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */

@Controller
public class IndexController {
    private final RecipeService recipeService;

    static Logger log = Logger.getLogger(IndexController.class.getName());

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.info("Getting Index page");
        System.out.println("Getting Index page");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
