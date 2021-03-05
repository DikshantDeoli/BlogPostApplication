package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.ArrayList;

@Controller            // not a normal java class
public class HomeController
{
    @RequestMapping("/")           // home page
    public String getAllPosts(Model model)
    {
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("iPhone");
        post1.setBody("iPhones are not better than Android");
        post1.setDate(new Date());


        Post post2 = new Post();
        post2.setTitle("Beauty");
        post2.setBody("Selena Gomez has started her own makeup time");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Technology");
        post3.setBody("Tesla CEO is promoting SpaceX");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);


        model.addAttribute("posts",posts);       // name and model value

        return "index";
    }
}
