package com.example.jobListing.Repository;

import com.example.jobListing.Models.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Component
public class SearchRepoImplementation implements SearchRepo {
    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;
    @Override
    public List<Post> findByText(String text){

        final List<Post> post = new ArrayList<>();

        MongoDatabase database = client.getDatabase("joblisitng");
        MongoCollection<Document> collection = database.getCollection("jobPosts");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));


        result.forEach(doc -> post.add(converter.read(Post.class,doc)));

        return post;
    }
}
