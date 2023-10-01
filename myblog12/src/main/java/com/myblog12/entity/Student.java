package com.myblog12.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(  name="studentssss",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}

  )
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="content",nullable = false)
    private String content;

}
