package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.model.UserProfile;
import com.upgrad.BlogPostApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;


    // GET Request to "/users/login"
    @RequestMapping(method = RequestMethod.GET, value="/users/login")
    public String login(Model model)
    {
        model.addAttribute("user",new User());
        return "users/login";
    }

    //POST Request to "/users/login"

    @RequestMapping(method= RequestMethod.POST,value="/users/login")
    public String loginUser(User user, HttpSession session)
    {
        User existingUser = userService.login(user);   // passing user to userService

        if(existingUser == null)        // login method of UserService class is called
        {
            System.out.println("USER DOES NOT EXIST");
            return "users/login";
        }
        else
        {
            //Maintain the session
            session.setAttribute("LogeedUser",existingUser);
            System.out.println("USER FOUND!");
            return "redirect:/posts";
        }
    }

    // AGENDA 3: Create the user registration
    // Registration :- "/users/registration"
    // Logout :- "users/logout"

    @RequestMapping(method = RequestMethod.GET,value = "/users/registration")
    public String Registration(Model model)
    {
        User user = new User();
        UserProfile userProfile = new UserProfile();

        user.setUserProfile(userProfile);
        model.addAttribute("user", user);

        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST,value = "users/registration")
    public String userRegistration(User user)
    {
        // Buisness logic to save the creds of the users to the given database
        userService.registerUser(user);
        return "redirect:/users/login";

    }
    @RequestMapping("users/logout")
    public String userLogout(HttpSession session)
    {
        // KILL the session
        session.invalidate();

        return "redirect:/";
    }
}
