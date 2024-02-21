package com.example.jobListing.Repository;

import com.example.jobListing.Models.Post;

import java.util.List;

public interface SearchRepo {
//    create a method
    List<Post> findByText(String text);
}
