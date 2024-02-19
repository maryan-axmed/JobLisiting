package com.example.jobListing.Controller;
import javax.servlet.http.HttpServletResponse;

import com.example.jobListing.Models.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
//    fetch all the post
    @GetMapping("/allPosts")
    public List<Post> getAllPosts(){
        return 
    }
}
