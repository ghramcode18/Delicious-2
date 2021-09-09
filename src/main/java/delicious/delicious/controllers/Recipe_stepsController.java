package delicious.delicious.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import delicious.delicious.repositories.Recipe_StepsRepo;

@RestController
@RequestMapping(path = {"/api/v1/Recipe_stepsController"})
public class Recipe_stepsController {
    @Autowired
    Recipe_StepsRepo recipe_steps; 
}
