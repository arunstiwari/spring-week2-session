package com.sapient.springsession.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private long id;

    private String name;
    private String email;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> address;

}
