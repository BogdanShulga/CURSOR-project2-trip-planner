package com.good.fly.trip_planner.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "places")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Trip trip;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int rating;

    @OneToMany(mappedBy = "place", cascade = CascadeType.PERSIST)
    private List<Comment> comments;
}
