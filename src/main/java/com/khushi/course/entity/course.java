package com.khushi.course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class course extends courseEnt{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer course_id;

    private String title;
    private String duration;
    private String author;

}
