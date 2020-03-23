package com.skc.springdatajpaexample.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String description;

    @ManyToOne
    private Post post;

}
