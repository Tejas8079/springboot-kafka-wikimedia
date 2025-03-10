package com.springboot.kafka.wikimedia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.kafka.wikimedia.entity.Wikimedia;

@Repository
public interface WikimediaRepository extends MongoRepository<Wikimedia, String> {
    
}
