package com.sapient.springsession.mongodb.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
@CompoundIndexes({@CompoundIndex(name = "name_age", def = "{'name':1, 'age':1}", unique = true)})
public class User {
    @Id
    private String id;

//    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    private Integer age;


    private List<Address> addresses;


}
