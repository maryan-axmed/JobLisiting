package com.example.jobListing.Controller;
import javax.servlet.http.HttpServletResponse;

import com.example.jobListing.Models.Post;
import com.example.jobListing.Repository.PostRepo;
import com.example.jobListing.Repository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo postRepo;

    @Autowired
    SearchRepo searchRepo;
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
//    fetch all the post
    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    @GetMapping("/allPosts/{text}")
    public List<Post> search(@PathVariable String text){
        return searchRepo.findByText(text);
    }

//    adding a post
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return postRepo.save(post);
    }
}
