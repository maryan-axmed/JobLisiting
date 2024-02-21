package com.example.jobListing.Repository;

import com.example.jobListing.Models.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchRepoImplementation implements SearchRepo {

    @Override
    public List<Post> findByText(String text){

        final List<Post> post = new ArrayList<>();
        return post;
    }
}
