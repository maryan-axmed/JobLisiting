package com.example.jobListing;

import com.example.jobListing.Models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post, String> {

}
