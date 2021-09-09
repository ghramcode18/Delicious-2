package delicious.delicious.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import delicious.delicious.exceptions.UserException;
import delicious.delicious.models.RecipeModel;
import delicious.delicious.models.UserModel;
// import delicious.delicious.services.RecipeService;
import delicious.delicious.services.UserService;

@RestController
@RequestMapping(path = {"/api/v1/auth","/api/v1"})
public class UserController {
    @Autowired
    UserService userService;
    
    // @Autowired
    // RecipeService recipeService;
     @RequestMapping(value="/register", method=RequestMethod.POST)
     public Object registerUser(@RequestBody UserModel user) {
         try{
             return userService.registerUser(user);
         }catch(UserException e)
         {
             return e.getMessage();
         }
     }
     
    @RequestMapping(value="/signIn", method=RequestMethod.POST)
    public Object signIn(@RequestBody UserModel user) {
        try{
            return userService.signIn(user);
        }catch(UserException e)
        {
            return e.getMessage();
        }                                                                                                                                                                       
    }
    
   
    
   @RequestMapping(value ="/getFavorites/{num}",method = RequestMethod.GET)
   public List<RecipeModel> getFavorite(@PathVariable (name = "num")Integer id)
   {
    return  userService.getFavorite(id);
   }
 
   @RequestMapping(value ="/addFavorite/{num}",method = RequestMethod.POST)
   public UserModel addFavorite(@PathVariable (name = "num")Integer id,RecipeModel rModel)
   {
    return userService.addFavorite(id, rModel);
   }
 

 }
