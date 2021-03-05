package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService
{
    // Uding JPa -> communicate | EntityManagerFactory
    @Autowired
    private PostRepository postRepository;

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;

    public List<Post> getAllPosts()
    {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post p", Post.class);
//        List<Post> result = query.getResultList();
        return postRepository.getAllPosts();
    }

    public  void createPost(Post newPost)
    {
        postRepository.createPost(newPost);


//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        try
//        {
//            transaction.begin();
//            entityManager.persist(newPost);
//            transaction.commit();
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//            transaction.rollback();
//        }
    }

    public void deletePost(Integer postId)
    {
        postRepository.deletePost(postId);
    }

    // Singleton
//    private static ArrayList<Post> POSTS = new ArrayList<>();  //all data base data is here so it is private
//    static
//    {
//        Post post1 = new Post();
//        post1.setTitle("Worldwide");
//        post1.setBody("A news in Uttarakhand reported heavy floods in UK districts. Alert has been declared");
//        post1.setDate(new Date());
//        POSTS.add(post1);
//
//        Post post2 = new Post();
//        post2.setTitle("Music");
//        post2.setBody("Selena Gomez is about to drop her Spanish album, Two singles are also dropped");
//        post2.setDate(new Date());
//        POSTS.add(post2);
//
//        Post post3 = new Post();
//        post3.setTitle("Technology");
//        post3.setBody("Apple's new iOS 14.5, iPadOS 14.5, macOS 11.3 are out for registration BETA testers");
//        post3.setDate(new Date());
//        POSTS.add(post3);
//
//        Post post4= new Post();
//        post4.setTitle("National");
//        post4.setBody("COVID vaccine drive has started in India, where front-line workers are prioritisd");
//        post4.setDate(new Date());
//        POSTS.add(post4);
//    }
//
//    private final String url = "jdbc:postgresql://localhost:5432/technicalblog";
//    private final String username = "postgres";
//    private final String password = "1234";

//    public Connection connect() throws SQLException
//    {
//        return DriverManager.getConnection(url,username,password);
//    }
//
    // Need - EntityManagerFactory
    // Step 1 - Create the EntityManagerFactory
//    @PersistenceUnit(unitName = "techblog")
//    private EntityManagerFactory entityManagerFactory;

//    public ArrayList<Post> getAllPosts()
//    {
        // USING JPA

        // Step 2 - Create the instance for Entity Manager
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        // Step 3 - Prform Operations
//        TypedQuery<Post> query =  entityManager.createQuery("SELECT p from Post p ", Post.class);
//        List<Post> result = query.getResultList();
//        return result;
//
//
//         USING JDBC
//        try
//        {
//            // Business logic for connecting the database
//
//            // Step 1: Connect to the DB
//            Connection c = connect();
//
//            // Step 2: Get/ create the Statement
//            Statement s = c.createStatement();
//
//            // Execute the select query
//            ResultSet rs = s.executeQuery("SELECT * FROM posts");
//
//            // Step 4: Loop into the resultSet and get the data
//            while(rs.next())
//            {
//                Post post1 = new Post();
//                post1.setTitle(rs.getString("title"));
//                post1.setBody(rs.getString("body"));
//                post1.setDate(rs.getDate("date"));
//
//                // Store the data in the Singleton
//                POSTS.add(post1);
//            }
//        }
//        catch (SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        return POSTS;                   // returns POSTS to PostController
//    }
//    public void createPost(Post newPost)
//    {
//        // USING JPA
//
//         USING JDBC
//        String q = "INSERT INTO posts (title, body, date) VALUES(?, ?, ?)";
//        try
//        {
//            // Step 1: Connect to the DB
//            Connection c = connect();
//
//            // Step 2: Prepare a statement
//            PreparedStatement ps = c.prepareStatement(q,Statement.RETURN_GENERATED_KEYS);
//
//            // Step 3: Fix the valus from the VIEWS
//
//            ps.setString(1, newPost.getTitle());
//            ps.setString(2, newPost.getBody());
//            ps.setDate(3, new Date(newPost.getDate().getTime()));
//
//            int updatedRows = ps.executeUpdate();
//
//            if(updatedRows>0)
//            {
//                System.out.println("Update is working fine");
//            }
//
//        }
//        catch (SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        POSTS.add(newPost);            // adds the new post in the POSTS ArrayList
//    }
}
