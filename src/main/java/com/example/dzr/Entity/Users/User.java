package com.example.dzr.Entity.Users;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Person> people;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Ticket> tickets;
}
