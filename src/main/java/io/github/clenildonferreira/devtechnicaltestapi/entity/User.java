package io.github.clenildonferreira.devtechnicaltestapi.entity;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public Long getId() {
        return id;
    }
    
}
