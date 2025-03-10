package com.springboot.kafka.wikimedia.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Document(collation = "Wikimedia")
public class Wikimedia {

    @Id
    private String id;

    private String wikiEventData;
}
