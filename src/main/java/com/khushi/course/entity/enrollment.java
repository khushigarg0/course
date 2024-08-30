package com.khushi.course.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enrollment")
public class enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer e_id;

    public Integer id;
    public Integer course_id;
    public String status;
}
