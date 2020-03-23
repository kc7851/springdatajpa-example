package com.skc.springdatajpaexample.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();

}
