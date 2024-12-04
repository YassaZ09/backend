package com.example.polkadanawa.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Tamil")
public class Tamil {
    @Id
    private String id;
    private String topic;
    private String key;
    private String content;
}
